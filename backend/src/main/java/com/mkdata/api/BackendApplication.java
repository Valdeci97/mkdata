package com.mkdata.api;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		// Logger logger = LoggerFactory.getLogger(BackendApplication.class);
		// Connection connection = null;
		// Statement statement = null;
		// try {
		// logger.info("Checking database status");
		// connection = DriverManager.getConnection(
		// "jdbc:postgresql://localhost:5432/clients",
		// "postgres",
		// "docker");
		// statement = connection.createStatement();
		// statement.executeQuery("SELECT count(*) FROM pg_database WHERE datname =
		// 'clients'");
		// ResultSet result = statement.getResultSet();
		// result.next();
		// int count = result.getInt(1);
		// if (count <= 0) {
		// logger.warn("Database does not exists!");
		// logger.info("Creating database...");
		// statement.executeUpdate("CREATE DATABASE clients");
		// logger.info("Database created.");
		// } else {
		// logger.warn("Database already exists.");
		// }
		// } catch (SQLException err) {
		// logger.error(err.getMessage());
		// } finally {
		// try {
		// if (statement != null) {
		// statement.close();
		// logger.debug("Closed statement.");
		// }
		// if (connection != null) {
		// connection.close();
		// logger.debug("Closed connection.");
		// }
		// } catch (SQLException err) {
		// logger.error(err.getMessage());
		// }
		// }
		SpringApplication.run(BackendApplication.class, args);
	}

}
