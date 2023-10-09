package com.main.bookstore.repository;

import com.main.bookstore.entity.RefreshToken;
import com.main.bookstore.entity.User;

public interface RefreshTokenRepository extends GenericRepository<RefreshToken, Integer> {
	RefreshToken findByToken(String token);
	
	RefreshToken findByUser(User user);
	
}
