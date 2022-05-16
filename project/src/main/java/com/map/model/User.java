package com.map.model;

import java.time.LocalDate;

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
public class User {
	private Long user_id;
	private String user_name;
	private Float user_distance;
	private String user_home;

	// 생성자
//	public Todo(Long id, String title, String description, LocalDate dueDate ) {
//		this.id = id;
//		this.title = title;
//		this.description = description;
//		this.dueDate = dueDate; 
//		this.isCompleted = false; 
//	}

	public User(Builder builder) {
		this.user_id = builder.user_id;
		this.user_name = builder.user_name;
		this.user_distance = builder.user_distance;
		this.user_home = builder.user_home;
	}

	// 내부에 정적클래스 생성
	// Builder 적용
	// 정적인 클래스 Builder 생성
	public static class Builder {
		private Long user_id;
		private String user_name;
		private Float user_distance;
		private String user_home;

		// 필수적인 필드 : id
		public Builder(Long user_id) {
			this.user_id = user_id;
		}

		public Builder user_name(String user_name) {
			this.user_name = user_name;
			return this;
		}

		public Builder user_distance(Float user_distance) {
			this.user_distance = user_distance;
			return this;
		}

		public Builder user_home(String user_home) {
			this.user_home = user_home;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_distance=" + user_distance
				+ ", user_home=" + user_home + "]";
	}


}
