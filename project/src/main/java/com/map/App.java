package com.map;

import com.map.controller.MapController;
import com.map.model.User;
import com.map.model.User_Info;
import com.map.utils.DButils;

public class App {
	public static void main(String[] args) {
		DButils.dropAndCreateTableUser();
		DButils.dropAndCreateTableUserInfo();

		MapController mapController = new MapController();

		// CREATE
		User newuser = new User.Builder(3L).user_name("아이유").user_distance(12.24f).user_home("경기도").build();
		mapController.insertUser(newuser);

		User_Info newUserInfo = new User_Info.Builder("서울시 구로구 신도림역").user_w3w("도전.나눔.개방").user_latitude(37.53851f)
				.user_longitude(127.12343f).build();
		mapController.insertUserInfo(newUserInfo);

		// READ
		mapController.readUser();
		System.out.println();
		mapController.readUserInfo();

		// UPDATE
		long userIds = 7L;
		User user = new User.Builder(userIds).user_name("전지현").user_distance(6.6f).user_home("과천시 별양동 과천역").build();
		mapController.updateUser(userIds, user);

		User_Info userInfo = new User_Info.Builder("서울시 은평구 불광역").user_w3w("유리병.캠핑.조심").user_latitude(37.53581f)
				.user_longitude(126.954029f).build();
		mapController.updateUserInfo(userInfo);

		// DELETE
		long userId2 = 2L;
		mapController.deleteUser(userId2);

		// AVG
		mapController.readAVG();

		System.out.println();

		// Max
		mapController.readMax();

		System.out.println();
		
		// Min
		mapController.readMin();
	}
}