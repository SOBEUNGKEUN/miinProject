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
}