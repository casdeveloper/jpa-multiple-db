package com.casdeveloper.jpamultipledb.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.casdeveloper.jpamultipledb.repository.one"},
        entityManagerFactoryRef = "managerFactoryOne",
        transactionManagerRef = "transactionManagerOne"
)
public class ConfigDBOne {

    @Primary
    @Bean(name = "oneProperties")
    @ConfigurationProperties("spring.datasource.one")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "oneDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.one")
    public DataSource dataSource(@Qualifier("oneProperties") DataSourceProperties properties){
        return properties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name = "managerFactoryOne")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder, @Qualifier("oneDataSource") DataSource dataSource){
        return builder.dataSource(dataSource)
                .packages("com.casdeveloper.jpamultipledb.model.one")
                .persistenceUnit("oneUnit")
                .build();
    }

    @Primary
    @Bean(name = "transactionManagerOne")
    @ConfigurationProperties("spring.jpa.one")
    public PlatformTransactionManager transactionManager(@Qualifier("managerFactoryOne")EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
