package com.ipd12.application;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.ipd12.model.Student;

public class MainApplication {

	final static StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
	public static void main(String[] args) {
		
		
		SessionFactory sf = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		List<Student> list = session.createQuery("from Student").list();
		
		for(Student s : list) {
			System.out.println(s);
		}
		
		session.clear();
		session.close();
		
	}
}
