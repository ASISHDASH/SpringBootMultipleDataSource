package com.aryan.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aryan.model.Customer;

@Repository
public class DAOImpl {

	@Autowired
	@Qualifier("postgreJdbc")
	private JdbcTemplate Jdbcpostgre;

	@Autowired
	@Qualifier("mysqlJdbc")
	private JdbcTemplate Jdbcmysql;

	public List<Customer> findAll() {
		List<Customer> result = Jdbcpostgre.query("SELECT id, name, email, created_date FROM customer",
				(rs, rowNum) -> new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getDate("created_date")));
		return result;
	}

	public List<Customer> findAllmysql() {

		// System.out.println(Jdbcmysql);

		List<Customer> result = Jdbcmysql.query("SELECT id, name, email, created_date FROM customer",
				(rs, rowNum) -> new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getDate("created_date")));
		return result;
	}

}
