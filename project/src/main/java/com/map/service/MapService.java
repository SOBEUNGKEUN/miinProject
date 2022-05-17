package com.map.service;

import java.util.List;
import com.map.dao.MapDAO;
import com.map.model.User;
import com.map.model.User_Info;

public class MapService {

	private final MapDAO mapDAO;

	public MapService() {
		mapDAO = new MapDAO();
	}

	// CREATE
	public int insertUser(User users) {
		return mapDAO.insertUser(users);
	}

	public int insertUserInfo(User_Info newUserInfo) {
		return mapDAO.insertUserInfo(newUserInfo);
	}

	// READ
	public List<User> readUser() {
		return mapDAO.readUser();
	}

	public List<User_Info> readUserInfo() {
		return mapDAO.readUserInfo();
	}

	// UPDATE
	public int updateUser(long userIds, User user) {
		return mapDAO.updateUser(userIds, user);
	}

	public int updateUserInfo(User_Info user) {
		return mapDAO.updateUserInfo(user);
	}

	// DELETE
	public int deleteUser(long userId) {
		return mapDAO.deleteUser(userId);
	}

	// AVG
	public List<Float> readAVG() {
		return mapDAO.readAVG();
	}

	// Max
	public List<String> readMax() {
		return mapDAO.readMax();
	}

	// Min
	public List<String> readMin() {
		return mapDAO.readMin();
	}

}
