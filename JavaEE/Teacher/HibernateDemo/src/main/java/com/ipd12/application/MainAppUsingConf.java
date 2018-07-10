package com.ipd12.application;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.ipd12.model.Student;

public class MainAppUsingConf {

	public static void main(String[] args) {
		
		//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		Configuration cfg = new Configuration()
			    .addClass(Student.class)
			    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
			    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/db1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
			    .setProperty("hibernate.connection.username", "root")
			    .setProperty("hibernate.connection.password", "root")
			    .setProperty("hibernate.show_sql", "true")
			    .setProperty("hibernate.connection.release_mode", "auto")
				.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		Session session = cfg.buildSessionFactory().openSession();
		session.beginTransaction();
		
		List<Student> list = session.createQuery("from Student").list();
		
		for(Student s : list) {
			System.out.println(s);
		}
		
		session.clear();
		session.close();
		
	}
}
