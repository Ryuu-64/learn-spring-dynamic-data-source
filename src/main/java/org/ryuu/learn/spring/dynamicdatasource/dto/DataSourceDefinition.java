package org.ryuu.learn.spring.dynamicdatasource.dto;

import lombok.Data;

@Data
public class DataSourceDefinition {
    private String name;

    private String driverClassName;

    private String url;

    private String username;

    private String password;
}
