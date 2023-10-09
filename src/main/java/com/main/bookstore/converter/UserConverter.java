package com.main.bookstore.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.bookstore.entity.User;
import com.main.bookstore.model.UserModel;
import com.main.bookstore.repository.RoleRepository;

@Component
public class UserConverter implements Converter<User, UserModel>{

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public UserModel toModel(User entity) {
		UserModel model = new UserModel();
		model.setId(entity.getUserId());
		model.setName(entity.getUserName());
		model.setPassword(entity.getPassword());
		model.setIsEnable(entity.getIsEnabled());
		model.setRoleId(entity.getRole().getRoleId());
		return model;
	}

	@Override
	public User toEntity(UserModel model) {
		User entity = new User();
		entity.setUserId(model.getId());
		entity.setUserName(model.getName());
		entity.setPassword(model.getPassword());
		entity.setIsEnabled(model.getIsEnable());
		entity.setRole(roleRepository.getReferenceById(model.getRoleId()));
		return entity;
	}

}
