package com.aryan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aryan.model.Customer;
import com.aryan.repository.DAOImpl;

@RestController
public class HomeController {
	@Autowired
	DAOImpl daoimpl;

	@RequestMapping("/")
	public String home() {

		System.out.println("postgre");
		List<Customer> list = daoimpl.findAll();
		list.forEach(x -> System.out.println(x.name));

		System.out.println(list.get(0).name);

		System.out.println("mysql");

		List<Customer> lists = daoimpl.findAllmysql();
		lists.forEach(x -> System.out.println(x.name));

		return "Aryan!";

	}

}
