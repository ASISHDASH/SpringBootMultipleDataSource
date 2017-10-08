package com.aryan.model;

import java.util.Date;

public class Customer {

	public int id;
	public String name;
	public String email;
	public Date date;

	public Customer(int id, String name, String email, Date date) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.date = date;
	}

	// getters and setters and toString...
}
