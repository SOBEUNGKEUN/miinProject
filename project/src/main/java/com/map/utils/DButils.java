package com.map.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DButils {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	// 사용하고자 하는 스키마(Database)이름
	private static final String DATABASE_NAME = "mapdb";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";

	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	// JDBC4.0 이후로 모든 드라이버들은 클래스패르세 자동으로 로딩됨 - 기존에는 원칙적으로 드라이버를 먼저 로딩(Loading)을 해야함.
	//

	// Java와 MySQL Database를 연결
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		return connection;
	}

	// DDL, 테이블 생성 메서드
	public static void dropAndCreateTableUser() {

		// Java와 MySQL연결
		// try - with resources 구문
		try (Connection connection = getConnection(); Statement statement = connection.createStatement();) {

			final String dropTableQueryIfExists = "DROP TABLE IF EXISTS user";

			statement.execute(dropTableQueryIfExists);

			final String createTableQueryUser = "CREATE TABLE user(\r\n" + "user_name VARCHAR(20) NOT NULL,\r\n"
					+ "user_distance FLOAT NOT NULL,\r\n" + "user_home VARCHAR(45) NOT NULL UNIQUE,\r\n"
					+ "user_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT );";

				statement.execute(createTableQueryUser);
				System.out.println("테이블 생성11");


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void dropAndCreateTableUserInfo() {

		// Java와 MySQL연결
		// try - with resources 구문
		try (Connection connection = getConnection(); Statement statement = connection.createStatement();) {

			final String dropTableQueryIfExists = "DROP TABLE IF EXISTS user_info";

			statement.execute(dropTableQueryIfExists);

			final String createTableQueryUser = "CREATE TABLE user_info(\r\n" + 
					"user_home VARCHAR(45) NOT NULL,\r\n" + 
					"user_w3w VARCHAR(20) NOT NULL,\r\n" + 
					"user_latitude FLOAT NOT NULL,\r\n" + 
					"user_longitude FLOAT NOT NULL,\r\n" + 
					"CONSTRAINT FOREIGN KEY(user_home) REFERENCES user(user_home) ON UPDATE AND DELETE CASCADE);";

				statement.execute(createTableQueryUser);
				System.out.println("테이블 생성22 ");
//
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
