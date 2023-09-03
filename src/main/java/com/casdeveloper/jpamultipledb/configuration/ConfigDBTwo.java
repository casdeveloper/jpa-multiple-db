package com.casdeveloper.jpamultipledb.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.casdeveloper.jpamultipledb.repository.two"},
        entityManagerFactoryRef = "managerFactoryTwo",
        transactionManagerRef = "transactionManagerTwo"
)
public class ConfigDBTwo {

    @Bean(name = "twoProperties")
    @ConfigurationProperties("spring.datasource.two")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean(name = "twoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource dataSource(@Qualifier("twoProperties") DataSourceProperties properties){
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "managerFactoryTwo")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder, @Qualifier("twoDataSource") DataSource dataSource){
        return builder.dataSource(dataSource)
                .packages("com.casdeveloper.jpamultipledb.model.two")
                .persistenceUnit("twoUnit")
                .build();
    }

    @Bean(name = "transactionManagerTwo")
    @ConfigurationProperties("spring.jpa.two")
    public PlatformTransactionManager transactionManager(@Qualifier("managerFactoryTwo") EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
