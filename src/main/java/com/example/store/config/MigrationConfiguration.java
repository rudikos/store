package com.example.store.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author rudolf.shakhgaldyan on 2/21/2021.
 */
@Configuration
public class MigrationConfiguration {


//	/**
//	 * Override default flyway initializer to do nothing
//	 */
//	@Bean
//	FlywayMigrationInitializer flywayInitializer(Flyway flyway) {
//		return new FlywayMigrationInitializer(flyway, (f) -> {
//		});
//	}
//
//
//	/**
//	 * Create a second flyway initializer to run after jpa has created the schema
//	 */
//	@Bean
//	FlywayMigrationInitializer delayedFlywayInitializer(Flyway flyway) {
//		return new FlywayMigrationInitializer(flyway, null);
//	}

	@Autowired
	public void flywayConfiguration(DataSource dataSource) {
		Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
	}


}
