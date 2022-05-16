package com.map.controller;

import java.util.List;

import com.map.model.User;
import com.map.model.User_Info;
import com.map.service.MapService;
import com.map.view.MapView;

public class MapController {
	private List<User> users;
	private List<User_Info> infos;
	private Exception errorObject;
	private final MapService mapService;
	private final MapView mapView;

	// 기본생성자
	public MapController() {
		this.mapView = new MapView();
		this.mapService = new MapService();
	}

	// C
	public void insert(User newTodo) {

	}

	// R
	public void readUser() {
		users = mapService.readUser();
		mapView.readUser(users);
	}

	public void readUserInfo() {
		infos = mapService.readUserInfo();
		mapView.readUserInfo(infos);
	}

	// U
	public void update(Long todoNumber, User todo) {

	}

	// D
	public void delete(Long todoNumber) {

	}

	public void deleteUser(long userId) {
		int deleteduser = mapService.deleteUser(userId);

		if (deleteduser > 0) {
			mapView.delete(deleteduser);
		} else {
			errorObject = new Exception("삭제 실패");
			mapView.errorPage(errorObject);
		}
	}

}
