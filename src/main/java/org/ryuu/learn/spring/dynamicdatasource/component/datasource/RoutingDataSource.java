package org.ryuu.learn.spring.dynamicdatasource.component.datasource;

import lombok.AllArgsConstructor;
import org.ryuu.learn.spring.dynamicdatasource.component.datasource.context.DataSourceContextHolder;
import org.ryuu.learn.spring.dynamicdatasource.configuration.DatasourceConfig;
import org.ryuu.learn.spring.dynamicdatasource.dto.DataSourceDefinition;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class RoutingDataSource extends AbstractRoutingDataSource {
    private DatasourceConfig datasourceConfig;

    @Override
    public void afterPropertiesSet() {
        Map<Object, Object> targetDataSources = datasourceConfig
                .getDefinitions()
                .stream()
                .collect(Collectors.toMap(
                        DataSourceDefinition::getName,
                        config -> DataSourceBuilder.create()
                                .url(config.getUrl())
                                .username(config.getUsername())
                                .password(config.getPassword())
                                .driverClassName(config.getDriverClassName())
                                .build()
                ));
        setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getContext().getDataSourceKey();
    }
}
