package org.ryuu.learn.spring.dynamicdatasource.configuration;

import lombok.Getter;
import lombok.Setter;
import org.ryuu.learn.spring.dynamicdatasource.dto.DataSourceDefinition;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(value = "datasource")
public class DatasourceConfig {
    @Setter
    @Getter
    private List<DataSourceDefinition> definitions;
}
