package com.map.controller;

import java.util.List;
import com.map.model.User;
import com.map.model.User_Info;
import com.map.service.MapService;
import com.map.view.MapView;

public class MapController {
	private List<User> users;
	private List<User_Info> infos;
	private List<Float> avg;
	private List<String> max, min;
	private Exception errorObject;
	private final MapService mapService;
	private final MapView mapView;

	// 기본생성자
	public MapController() {
		this.mapView = new MapView();
		this.mapService = new MapService();
	}

	// C
	public void insertUser(User newuser) {
		int result = mapService.insertUser(newuser);

		if (result > 0) {
			mapView.successPage();
		} else {
			mapView.errorPage(errorObject);
		}
	}

	public void insertUserInfo(User_Info newUserInfo) {
		int result = mapService.insertUserInfo(newUserInfo);

		if (result > 0) {
			mapView.successPage();
		} else {
			mapView.errorPage(errorObject);
		}
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
	public void updateUser(long userIds, User user) {
		int previousUser = mapService.updateUser(userIds, user);

		if (previousUser > 0) {
			mapView.update(previousUser);
		} else {
			errorObject = new Exception("업데이트 실패");
			mapView.errorPage(errorObject);
		}
	}

	public void updateUserInfo(User_Info user) {
		int previousUser = mapService.updateUserInfo(user);

		if (previousUser > 0) {
			mapView.update(previousUser);
		} else {
			errorObject = new Exception("업데이트 실패");
			mapView.errorPage(errorObject);
		}
	}

	// D
	public void deleteUser(long userId) {
		int deleteduser = mapService.deleteUser(userId);

		if (deleteduser > 0) {
			mapView.delete(deleteduser);
		} else {
			errorObject = new Exception("삭제 실패");
			mapView.errorPage(errorObject);
		}
	}

	// AVG
	public void readAVG() {
		avg = mapService.readAVG();
		mapView.readAVG(avg);
	}

	
	// Max
	public void readMax() {
		max = mapService.readMax();
		mapView.readMax(max);
	}

	public void readMin() {
		min = mapService.readMin();
		mapView.readMin(min);
		
	}

}
