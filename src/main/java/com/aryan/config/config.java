package com.aryan.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class config {

	@Bean(name = "Postgredb")
	@Primary
	@ConfigurationProperties(prefix = "postgre.datasource")
	public DataSource postgresqlDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "postgreJdbc")
	public JdbcTemplate drupalJdbcTemplate(@Qualifier("Postgredb") DataSource dMySql) {
		return new JdbcTemplate(dMySql);
	}

	@Bean(name = "MySqldb")
	@ConfigurationProperties(prefix = "mysql.datasource")
	public DataSource mysqlDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "mysqlJdbc")
	public JdbcTemplate myJdbcTemplate(@Qualifier("MySqldb") DataSource MySqls) {
		return new JdbcTemplate(MySqls);
	}
}
