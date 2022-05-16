package com.map.view;

import java.util.List;

import com.map.model.User;
import com.map.model.User_Info;

public class MapView {

	public void readUser(List<User> users) {
		System.out.println("User테이블 조회결과입니다.");
		for (User user : users) {
			System.out.print(String.format("%s의 집은 %s 입니다.",user.getUser_name(),user.getUser_home()));
			System.out.println(String.format(" %s에서 학원까지의 거리는  %.2fKM입니다.",user.getUser_home(),user.getUser_distance()));
			System.out.println();
		}
		
	}

	public void readUserInfo(List<User_Info> infos) {
		System.out.println("User_Info 테이블 조회결과입니다.");
		for (User_Info user_Info : infos) {
			System.out.print(String.format("%s 을 W3W주소로 변환시면    %s 입니다.", user_Info.getUser_home(), user_Info.getUser_w3w()));
			System.out.println(String.format(" 주소지에 위도는 %.2f 경도는  %.2f 입니다.",user_Info.getUser_latitude(), user_Info.getUser_longitude()));
		}
	}
	
	public void successPage() {
		System.out.println("정상 등록 되었습니다.");
	}	

	public void errorPage(Exception error) {
		System.out.println("문제가 발생하였습니다." + error.getMessage());
	}
	public void delete(int deletedTodo) {
		System.out.println("정상 삭제 되었습니다.");
	}
}
