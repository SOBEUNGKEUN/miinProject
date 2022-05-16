package com.map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.map.model.User;
import com.map.model.User_Info;
import com.map.utils.DButils;

public class MapDAO {

	private User user;
	private User_Info user_info;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;

	// User 테이블 조회
	public List<User> readUser() {
		final String selectQuery = "SELECT * FROM user";
		List<User> users = new ArrayList<>();
		try {
			connection = DButils.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectQuery);
			while (resultSet.next()) {
				Long user_id = resultSet.getLong("user_id");
				String user_name = resultSet.getString("user_name");
				Float user_distance = resultSet.getFloat("user_distance");
				String user_home = resultSet.getString("user_home");
				user = new User(user_id, user_name, user_distance, user_home);
				users.add(user);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return users;
	}

	// User_Info 테이블 조회
	public List<User_Info> readUserInfo() {
		final String selectQuery = "SELECT * FROM user_info";
		List<User_Info> User_Infos = new ArrayList<>();
		try {
			connection = DButils.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectQuery);
			while (resultSet.next()) {
				String user_home = resultSet.getString("user_home");
				String user_w3w = resultSet.getString("user_w3w");
				Float user_latitude = resultSet.getFloat("user_latitude");
				Float user_longitude = resultSet.getFloat("user_longitude");
				user_info = new User_Info(user_home, user_w3w, user_latitude, user_longitude);
				User_Infos.add(user_info);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return User_Infos;
	}

//	public int insert(User user) {
//
//	}
//
	public int deleteUser(Long user_id) {
		String deleteQuery = "DELETE FROM user WHERE user_id = ? ";
		
		int affectedRows = 0;

		try (Connection connection = DButils.getConnection(); // 자원을 해제할 수 있는 것만 넣을수 있다.
				PreparedStatement preparedStatement = createPreparedStatement(connection, deleteQuery, user_id);) {
			affectedRows = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	private PreparedStatement createPreparedStatement(Connection connection, String sql, Long user_id)
			throws SQLException {

		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1, user_id);

		return preparedStatement;
	}
//
//	public int update(Long user_id, User user) {
//
//	}

}
