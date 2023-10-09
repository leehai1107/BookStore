package com.main.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
	private int id;
	private String name;
	private String password;
	private Boolean isEnable;
	private int roleId;
}
