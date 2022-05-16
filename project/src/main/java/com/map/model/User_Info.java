package com.map.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter // setter 메서드 자동 생성
@Getter
@NoArgsConstructor // NoArgs(Arguments)인자값이 없는 기본 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자
@Builder

// 기존 생성자
//public User_Info(String user_home, String user_w3w, Float user_latitude, Float user_longitude) {
//	super();
//	this.user_home = user_home;
//	this.user_w3w = user_w3w;
//	this.user_latitude = user_latitude;
//	this.user_longitude = user_longitude;
//}

public class User_Info {
	private String user_home;
	private String user_w3w;
	private Float user_latitude;
	private Float user_longitude;

	public User_Info(Builder builder) {
		this.user_home = builder.user_home;
		this.user_w3w = builder.user_w3w;
		this.user_latitude = builder.user_latitude;
		this.user_longitude = builder.user_longitude;
	}

	// 내부에 정적클래스 생성
	// Builder 적용
	// 정적인 클래스 Builder 생성
	public static class Builder {
		private String user_home;
		private String user_w3w;
		private Float user_latitude;
		private Float user_longitude;

		
		public Builder(String user_home) {
			this.user_home = user_home;
		}

		public Builder user_w3w(String user_w3w) {
			this.user_w3w = user_w3w;
			return this;
		}

		public Builder user_latitude(Float user_latitude) {
			this.user_latitude = user_latitude;
			return this;
		}

		public Builder user_longitude(Float user_longitude) {
			this.user_longitude = user_longitude;
			return this;
		}

		public User_Info build() {
			return new User_Info(this);
		}
	}

	@Override
	public String toString() {
		return "User_Info [user_home=" + user_home + ", user_w3w=" + user_w3w + ", user_latitude=" + user_latitude
				+ ", user_longitude=" + user_longitude + "]";
	}
}