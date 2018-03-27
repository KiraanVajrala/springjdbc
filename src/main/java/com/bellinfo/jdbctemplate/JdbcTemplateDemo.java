package com.bellinfo.jdbctemplate;

import javax.sql.DataSource;

public class JdbcTemplateDemo {
	public static void main (String[] args) {
		StudentsRepo repo = new StudentsRepo();
		
		/*Students std = new Students();
		std.setName("vajrala");
		repo.persist(std);
		*/
	
System.out.println(repo.verify("vajrala"));
	}

	
	
}