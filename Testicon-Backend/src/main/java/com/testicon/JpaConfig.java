package com.testicon;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.testicon.repository")
public class JpaConfig {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(dataSource());
	      em.setPackagesToScan(new String[] { "com.testicon.model" });
	 
	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter);
	      Properties properties = new Properties();        
	     // properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
	      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle8iDialect");
	     // properties.setProperty("hibernate.hbm2ddl.auto", "update");
	      properties.setProperty("hibernate.format_sql", "true");

	      em.setJpaProperties(properties);
	 
	      return em;
	}
	
	@Bean
	public DriverManagerDataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    //dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	    //dataSource.setUrl("jdbc:mysql://localhost:3306/fitnessTracker?autoReconnect=true");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/orcl");
		//jdbc:oracle:thin:@//localhost:5221/orcl
	    
	    dataSource.setUsername("HR");
	    dataSource.setPassword("HR");
	    return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
	      JpaTransactionManager transactionManager = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(emf);
	 
	      return transactionManager;
	}



}
