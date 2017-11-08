package com.niit.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.models.Blog;
import com.niit.models.Friend;
import com.niit.models.Job;
import com.niit.models.JobApplication;
import com.niit.models.User;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class ApplicationContextConfig {
	
		private static final Logger logger = LoggerFactory.getLogger(ApplicationContextConfig.class);

		@Bean(name = "dataSource")
		public DataSource getOracleDataSource() {
			logger.debug("Starting of the method getOracleDataSource");
			DriverManagerDataSource dataSource = new DriverManagerDataSource();

			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");

			dataSource.setUsername("COLLABRATION"); // Schema name
			dataSource.setPassword("pratima");

			Properties connectionProperties = new Properties();

			connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			connectionProperties.setProperty("hibernate.hbm2ddl.auto", "update");
			connectionProperties.setProperty("hibernate.show_sql", "true");
			connectionProperties.setProperty("hibernate.formate_sql","true");
			dataSource.setConnectionProperties(connectionProperties);
			logger.debug("Setting the data source :" + dataSource.getConnectionProperties());
			logger.debug("Ending of the method getOracleDataSource");
			return dataSource;
		}

		@Autowired
		@Bean(name = "sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource) {
System.out.println("hii");
			logger.debug("Starting of the method getSessionFactory");
			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
			Properties connectionProperties = new Properties();

			connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	       
			sessionBuilder.addProperties(connectionProperties);
			sessionBuilder.scanPackages("com.niit");
			
			logger.debug("Ending of the method getSessionFactory");
			return sessionBuilder.buildSessionFactory();
		}

		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

			logger.debug("Starting of the method getTransactionManager");
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

			logger.debug("Ending of the method getTransactionManager");
			return transactionManager;
		}


	}

