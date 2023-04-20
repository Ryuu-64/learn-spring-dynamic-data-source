package org.ryuu.learn.spring.dynamicdatasource.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.ryuu.learn.spring.dynamicdatasource.component.datasource.context.DataSourceContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class DataSourceRoutingFilter extends OncePerRequestFilter {
    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain
    ) throws ServletException, IOException {
        tryGetDataSourceKey(request);
        filterChain.doFilter(request, response);
    }

    private void tryGetDataSourceKey(HttpServletRequest request) throws IOException {
        JsonNode requestBodyjsonNode = objectMapper.readTree(request.getReader());
        JsonNode dataSourceKeyNode = requestBodyjsonNode.get("dataSourceKey");
        String dataSourceKey = dataSourceKeyNode.asText();
        // TODO replace deprecated
        if (StringUtils.isEmpty(dataSourceKey)) {
            return;
        }
        DataSourceContextHolder.getContext().setDataSourceKey(dataSourceKey);
    }
}
