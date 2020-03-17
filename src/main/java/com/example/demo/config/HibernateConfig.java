package com.example.demo.config;	
	

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
 
@Configuration
public class HibernateConfig {
 
    @Autowired
    private DataSource dataSource;
    
    @Bean
    @Primary
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("com.example.demo.models");
        sessionFactory.setHibernateProperties(hibernateProperties());
 
        return sessionFactory;
    }
 
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource  ds = new DriverManagerDataSource ();
//        ds.setDriverClassName("org.h2.Driver");
//        ds.setUrl("jdbc:h2:file:/C:/Users/admin/test1");
//        ds.setUsername("sa");
//        ds.setPassword("password");
// 
//        return ds;
//    }
// 
    private final Properties hibernateProperties() {
        Properties hibernate = new Properties();
        hibernate.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        hibernate.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernate.setProperty("hibernate.show_sql", "true");
 
        return hibernate;
    }    
    
    /*@Bean
        public PlatformTransactionManager hibernateTransactionManager() {
            HibernateTransactionManager transactionManager = new HibernateTransactionManager();
            transactionManager.setSessionFactory(sessionFactory().getObject());
            return transactionManager;
        }*/

}