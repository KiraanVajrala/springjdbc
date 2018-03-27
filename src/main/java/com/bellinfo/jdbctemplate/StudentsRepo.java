package com.bellinfo.jdbctemplate;

import javax.sql.DataSource;
import java.sql.DriverManager;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



public class StudentsRepo {
	public DataSource dataSource() {
		 
	 	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 	dataSource.setDriverClassName("org.postgresql.Driver");
	 	
	 	dataSource.setUrl("jdbc:postgresql://bellinfo8.cyi13ze3gxwt.us-east-1.rds.amazonaws.com:5432/Bellinfodb");
	 	dataSource.setUsername("postgres");
	 	dataSource.setPassword("postgres");
	 	
	 	
		return dataSource;
	 	
	 }
	 
	 
	 private JdbcTemplate jdbcTemplate() {
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		 return jdbcTemplate;
	}
	 
	 public void persist(Students students) {
		 JdbcTemplate template = jdbcTemplate();
		 template.update("insert into students (name) values (?)", students.getName());
		 System.out.println("inserted success");
		 }

	 public boolean verify(String name) {
		
		 JdbcTemplate template = jdbcTemplate();
		 String name1 = null;
		try {
			name1 = template.queryForObject("select name from students where name=?", new Object[] {name}, String.class);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(name1 !=null) {
			 return true;
		 }
		 
		return false;
		 
	 }

}
