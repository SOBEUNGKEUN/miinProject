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
	
//	public int insert(User newTodo) {
//		return mapDAO.insert(newTodo);
//	}
	
	public List<User> readUser() {
		return mapDAO.readUser();
	}
//	
//	public int update(Long user_id, User user) {
//		return mapDAO.update(user_id, user);
//	}
//	
//	public int delete(Long user_id) {
//		return mapDAO.delete(user_id);
//	}

	public List<User_Info> readUserInfo() {
		return mapDAO.readUserInfo();
	}

	public int deleteUser(long userId) {
		return mapDAO.deleteUser(userId);
	}
}
