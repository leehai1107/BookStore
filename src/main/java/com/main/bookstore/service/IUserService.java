package com.main.bookstore.service;

import com.main.bookstore.entity.User;

public interface IUserService {

	User findUserByUserName(String userName);

	String addUser(User userInfo);

}
