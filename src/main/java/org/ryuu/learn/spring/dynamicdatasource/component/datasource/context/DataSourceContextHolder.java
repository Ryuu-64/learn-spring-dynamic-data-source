package org.ryuu.learn.spring.dynamicdatasource.component.datasource.context;

public class DataSourceContextHolder {
    private static DataSourceContext dataSourceContext;

    static {
        initialize();
    }

    public static DataSourceContext getContext() {
        return dataSourceContext;
    }

    private static void initialize() {
        dataSourceContext = new ThreadLocalDataSourceContext();
    }
}
