package com.main.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.bookstore.repository.RoleRepository;
import com.main.bookstore.service.IRoleService;

@Service
public class RoleService implements IRoleService{
	@Autowired
	RoleRepository roleRepository;
}
