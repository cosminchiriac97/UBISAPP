package com.tickets.order;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class Application {
	private static final String DB_FILE = "Database.db";
	private static ComboPooledDataSource cpds;
	private static final String url = "jdbc:sqlite:./" + DB_FILE;
	static {
		    cpds = new ComboPooledDataSource();
			cpds.setJdbcUrl(url);
			cpds.setInitialPoolSize(5);
			cpds.setMinPoolSize(5);
			cpds.setAcquireIncrement(5);
			cpds.setMaxPoolSize(20);
			cpds.setMaxStatements(100);
		}
	public static Connection getConnection() {
		Connection connection = null;
			try {
				connection = cpds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
	}

	public static void main(String[] args) {SpringApplication.run(Application.class, args);
	}
}
