package com.map.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	private Long user_id;
	private String user_name;
	private Float user_distance;
	private String user_home;

	public User(Builder builder) {
		this.user_id = builder.user_id;
		this.user_name = builder.user_name;
		this.user_distance = builder.user_distance;
		this.user_home = builder.user_home;

	}

	public static class Builder {
		private Long user_id;
		private String user_name;
		private Float user_distance;
		private String user_home;

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

}
