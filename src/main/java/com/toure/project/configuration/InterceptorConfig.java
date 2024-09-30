package com.toure.project.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.toure.project.interceptor.Interceptors;

@Configuration
public class InterceptorConfig {
	
	private String sql;
	private Interceptors intercept;
	
	
	/*
	 * @Bean public LocalContainerEntityManagerFactoryBean
	 * entityManagementFactory(DataSource dataSource) {
	 * 
	 * LocalContainerEntityManagerFactoryBean factoryBean = new
	 * LocalContainerEntityManagerFactoryBean();
	 * factoryBean.setDataSource(dataSource);
	 * factoryBean.setPackagesToScan("com.toure.project.model");
	 * 
	 * Properties properties = new Properties(); properties.put("hibernate.dialect",
	 * "org.hibernate.dialect.PostgreSQLDialect");
	 * properties.put("hibernate.show_sql", "true");
	 * properties.put("hibernate.statement_inspector", new Interceptors());
	 * 
	 * factoryBean.setJpaProperties(properties);
	 * 
	 * 
	 * return factoryBean; }
	 */

	    @Bean(name = "entityManagerFactory")
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
	        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
	        factoryBean.setDataSource(dataSource);
	        factoryBean.setPackagesToScan("com.toure.project.model");

	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
	        properties.put("hibernate.show_sql", "true");
	        properties.put("hibernate.format_sql", "true");
	        properties.put("hibernate.statement_inspector", new Interceptors()); // Enregistrement de l'intercepteur

	        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
	        factoryBean.setJpaProperties(properties);
	        
	        
	        
	        //System.out.println("This is the intercepted request : ");
	        
	        return factoryBean;
	    }

}
