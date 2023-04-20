package org.ryuu.learn.spring.dynamicdatasource.component.datasource.context;

public interface DataSourceContext {
    void setDataSourceKey(Object dataSourceKey);

    Object getDataSourceKey();

    void clearDataSourceKey();
}
