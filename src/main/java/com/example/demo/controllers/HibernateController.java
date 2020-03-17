package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DAO.MappingHibernateDAO;
import com.example.demo.models.User;

@RestController
@RequestMapping("hibernate/")
public class HibernateController {
	
	@Autowired
	MappingHibernateDAO  dao;
	
	@GetMapping("/addUser")
	public long addUser(){
		return dao.addUser();		
	}
	
	
	@GetMapping("/addHobby")
	public long addHobby(){
		return dao.addHobby();		
	}	
	
}
