package com.map.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DButils {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String DATABASE_NAME = "mapdb";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";

	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		return connection;
	}

	public static void dropAndCreateTableUser() {

		try (Connection connection = getConnection(); Statement statement = connection.createStatement();) {

			final String dropTableQueryIfExists = "DROP TABLE IF EXISTS user";

			statement.execute(dropTableQueryIfExists);

			final String createTableQueryUser = "CREATE TABLE user(\r\n" + "user_name VARCHAR(20) NOT NULL,\r\n"
					+ "user_distance FLOAT NOT NULL,\r\n" + "user_home VARCHAR(45) NOT NULL UNIQUE,\r\n"
					+ "user_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT );";
			statement.execute(createTableQueryUser);
			System.out.println("user테이블 생성");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void dropAndCreateTableUserInfo() {

		try (Connection connection = getConnection(); Statement statement = connection.createStatement();) {

			final String dropTableQueryIfExists = "DROP TABLE IF EXISTS user_info";

			statement.execute(dropTableQueryIfExists);

			final String createTableQueryUser = "CREATE TABLE user_info(\r\n" + "user_home VARCHAR(45) NOT NULL,\r\n"
					+ "user_w3w VARCHAR(20) NOT NULL,\r\n" + "user_latitude FLOAT NOT NULL,\r\n"
					+ "user_longitude FLOAT NOT NULL,\r\n"
					+ "CONSTRAINT FOREIGN KEY(user_home) REFERENCES user(user_home) ON UPDATE CASCADE ON DELETE CASCADE);";
			statement.execute(createTableQueryUser);
			System.out.println("user_info테이블 생성");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
