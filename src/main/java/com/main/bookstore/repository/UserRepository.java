package com.main.bookstore.repository;

import com.main.bookstore.entity.User;


public interface UserRepository extends GenericRepository<User, Integer>{
	User findUserByUserName(String userName);
}
