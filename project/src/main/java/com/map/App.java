package com.map;

import com.map.controller.MapController;
import com.map.utils.DButils;


public class App {
	public static void main(String[] args) {
//		DButils.dropAndCreateTableUser();
//		DButils.dropAndCreateTableUserInfo();
		
		
		MapController mapController = new MapController();
		mapController.readUser();
		mapController.readUserInfo();
		
		long userId = 1L;
		mapController.deleteUser(userId);
		System.out.println("세운_수정내용");
	}
}