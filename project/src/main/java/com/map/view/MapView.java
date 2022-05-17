
package com.map.view;

import java.util.List;

import com.map.model.User;
import com.map.model.User_Info;

public class MapView {

	public void readUser(List<User> users) {
		System.out.println("User테이블 조회결과입니다.");
		System.out.println();
		for (User user : users) {
			System.out.print(String.format("%s의 집은 %s 입니다.", user.getUser_name(), user.getUser_home()));
			System.out.println(String.format(" 학원까지의 거리는  %.2fKM 입니다.", user.getUser_distance()));
			System.out.println();
		}
	}

	public void readUserInfo(List<User_Info> infos) {
		System.out.println("User_Info 테이블 조회결과입니다.");
		System.out.println();
		for (User_Info user_Info : infos) {
			System.out.print(String.format("%s \nW3W주소 : %s", user_Info.getUser_home(), user_Info.getUser_w3w()));
			System.out.println(String.format("  | 위도 : %f | 경도 : %f", user_Info.getUser_latitude(),user_Info.getUser_longitude()));
			System.out.println();
		}
	}

	public void successPage() {
		System.out.println("정상 등록되었습니다.");
	}

	public void errorPage(Exception error) {
		System.out.println("문제가 발생하였습니다." + error.getMessage());
	}

	public void delete(int deletedTodo) {
		System.out.println("정상 삭제 되었습니다.");
	}

	public void update(int previousUser) {
		System.out.println("업데이트 성공되었습니다.");
	}

	public void readAVG(List<Float> avg) {
		System.out.print("전체 학생의 학원까지의 평균 거리 : ");
		System.out.println(avg.get(0)+"KM");
	}

	public void readMax(List<String> max) {
		System.out.print("학원에서 가장 멀리사는 학생 이름 : ");
		System.out.println(max.get(1));
		System.out.println("최장 거리 : "+max.get(0)+"KM");
		System.out.println("늦어도 이해 해주세요ㅠㅠ");
	}

	public void readMin(List<String> min) {
		System.out.print("학원에서 가장 가까이사는 학생 이름 : ");
		System.out.println(min.get(1));
		System.out.println("최단 거리 : "+min.get(0)+"KM");
		System.out.println("넌 늦으면 안되지");
	}
}