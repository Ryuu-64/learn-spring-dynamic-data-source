package org.ryuu.learn.spring.dynamicdatasource.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ryuu.learn.spring.dynamicdatasource.component.datasource.context.DataSourceContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class DataSourceRoutingFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceRoutingFilter.class);

    private final ObjectMapper objectMapper;

    private final String dataSourceKeyName;

    public DataSourceRoutingFilter(
            ObjectMapper objectMapper,
            @Value("${datasource.data-source-key-name}") String dataSourceKeyName
    ) {
        this.objectMapper = objectMapper;
        this.dataSourceKeyName = dataSourceKeyName;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain
    ) throws ServletException, IOException {
        tryGetDataSourceKey(request);
        try {
            filterChain.doFilter(request, response);
        } finally {
            DataSourceContextHolder.getContext().clearDataSourceKey();
        }
    }

    private void tryGetDataSourceKey(HttpServletRequest request) {
        JsonNode requestBodyjsonNode;
        try {
            requestBodyjsonNode = objectMapper.readTree(request.getReader());
        } catch (IOException e) {
            logger.warn("Error when readTree from request reader.", e);
            return;
        }
        if (!requestBodyjsonNode.has(dataSourceKeyName)) {
            return;
        }
        JsonNode dataSourceKeyNode = requestBodyjsonNode.get(dataSourceKeyName);
        String dataSourceKey = dataSourceKeyNode.asText();
        if (ObjectUtils.isEmpty(dataSourceKey)) {
            return;
        }

        DataSourceContextHolder.getContext().setDataSourceKey(dataSourceKey);
    }
}
