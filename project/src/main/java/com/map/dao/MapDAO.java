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
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pstmt;

	// user테이블에 새로운 데이터 추가
	public int insertUser(User users) {
		String insertQuery = "INSERT INTO user VALUES ( ?, ?, ?, ?)";
		int affectedRows = 0;
		try (Connection connection = DButils.getConnection();
				PreparedStatement preparedStatement = createPreparedStatement1(connection, insertQuery, users)) {
			affectedRows = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	// INSERT user
	private PreparedStatement createPreparedStatement1(Connection connection, String sql, User user)
			throws SQLException {
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, user.getUser_name());
		pstmt.setFloat(2, user.getUser_distance());
		pstmt.setString(3, user.getUser_home());
		pstmt.setLong(4, user.getUser_id());
		return pstmt;
	}

	// user_info테이블에 새로운 데이터 추가
	public int insertUserInfo(User_Info newUserInfo) {

		String insertQuery = "INSERT INTO user_info VALUES ( ?, ?, ?, ?)";
		int affectedRows = 0;
		try (Connection connection = DButils.getConnection();
				PreparedStatement preparedStatement = createPreparedStatement2(connection, insertQuery, newUserInfo)) {
			affectedRows = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	// INSERT user_info
	private PreparedStatement createPreparedStatement2(Connection connection, String sql, User_Info newUserInfo)
			throws SQLException {
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, newUserInfo.getUser_home());
		pstmt.setString(2, newUserInfo.getUser_w3w());
		pstmt.setFloat(3, newUserInfo.getUser_latitude());
		pstmt.setFloat(4, newUserInfo.getUser_longitude());
		return pstmt;
	}

	// user테이블에서 전체 데이터 조회
	public List<User> readUser() {
		final String selectQuery = "SELECT * FROM user";
		List<User> users = new ArrayList<>();
		try {
			conn = DButils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectQuery);
			while (rs.next()) {
				Long user_id = rs.getLong("user_id");
				String user_name = rs.getString("user_name");
				Float user_distance = rs.getFloat("user_distance");
				String user_home = rs.getString("user_home");
				user = new User(user_id, user_name, user_distance, user_home);
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return users;
	}

	// user_info테이블에서 전체 데이터 조회
	public List<User_Info> readUserInfo() {
		final String selectQuery = "SELECT * FROM user_info";
		List<User_Info> User_Infos = new ArrayList<>();
		try {
			conn = DButils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectQuery);
			while (rs.next()) {
				String user_home = rs.getString("user_home");
				String user_w3w = rs.getString("user_w3w");
				Float user_latitude = rs.getFloat("user_latitude");
				Float user_longitude = rs.getFloat("user_longitude");
				user_info = new User_Info(user_home, user_w3w, user_latitude, user_longitude);
				User_Infos.add(user_info);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return User_Infos;
	}

	// user테이블에서 데이터 수정
	public int updateUser(long userIds, User user) {
		String updateQuery = "UPDATE user SET user_name=?, user_distance=?, user_home=? WHERE user_id= ?;";
		int affectedRows = 0;

		try (Connection conn = DButils.getConnection();
				PreparedStatement preparedStatement = createPreparedStatement3(conn, updateQuery, user);) {

			affectedRows = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	private PreparedStatement createPreparedStatement3(Connection conn, String sql, User user) throws SQLException {

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUser_name());
		pstmt.setFloat(2, user.getUser_distance());
		pstmt.setString(3, user.getUser_home());
		pstmt.setLong(4, user.getUser_id());

		return pstmt;
	}

	// user_info테이블에서 데이터 수정
	public int updateUserInfo(User_Info user_info) {
		String updateQuery = "UPDATE user_info SET user_home=?, user_w3w= ?, user_latitude= ?, user_longitude= ?;";
		int affectedRows = 0;
		try (Connection connection = DButils.getConnection(); // 자원을 해제할 수 있는 것만 넣을수 있다.
				PreparedStatement preparedStatement = createPreparedStatement4(connection, updateQuery, user_info);) {

			affectedRows = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	private PreparedStatement createPreparedStatement4(Connection conn, String sql, User_Info user_info)
			throws SQLException {

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_info.getUser_home());
		pstmt.setString(2, user_info.getUser_w3w());
		pstmt.setFloat(3, user_info.getUser_latitude());
		pstmt.setFloat(4, user_info.getUser_longitude());

		return pstmt;
	}

	// user테이블 데이터 삭제
	public int deleteUser(Long user_id) {
		String deleteQuery = "DELETE FROM user WHERE user_id = ? ";

		int affectedRows = 0;

		try (Connection conn = DButils.getConnection(); // 자원을 해제할 수 있는 것만 넣을수 있다.
				PreparedStatement preparedStatement = createPreparedStatement5(conn, deleteQuery, user_id);) {
			affectedRows = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	private PreparedStatement createPreparedStatement5(Connection conn, String sql, Long user_id) throws SQLException {

		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, user_id);

		return pstmt;
	}

	// AVG
	public List<Float> readAVG() {
		final String selectQuery = "SELECT AVG(user_distance) AS AVG FROM USER";
		List<Float> users = new ArrayList<>();
		try {
			conn = DButils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectQuery);

			while (rs.next()) {
				Float avg_user_distance = rs.getFloat("AVG");
				users.add(avg_user_distance);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	
	// Max
	public List<String> readMax() {
		final String selectQuery = "SELECT user_name, user_distance AS MAX FROM USER ORDER BY user_distance DESC LIMIT 1";
		List<String> users = new ArrayList<>();
		try {
			conn = DButils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectQuery);

			while (rs.next()) {
				String max_user_distance = rs.getString("MAX");
				String max_user_name = rs.getString("user_name");
			
				users.add(max_user_distance);
				users.add(max_user_name);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	public List<String> readMin() {
		final String selectQuery = " SELECT user_name, user_distance AS MIN FROM USER ORDER BY user_distance ASC LIMIT 1 ";
		List<String> users = new ArrayList<>();
		try {
			conn = DButils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectQuery);

			while (rs.next()) {
				String min_user_distance = rs.getString("MIN");
				String min_user_name = rs.getString("user_name");
			
				users.add(min_user_distance);
				users.add(min_user_name);
		
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
}
