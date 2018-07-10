package com.ipd12.application;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.ipd12.model.Student;
import com.ipd12.model.Student3;
import com.ipd12.utilities.HibernateUtil;

public class MainAppUsingHibUtils {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		/*List<Student> list = session.createQuery("from Student").list();
		
		for(Student s : list) {
			System.out.println(s);
		}*/
		Student3 s = new Student3();
		//s.setStudentID("");
		s.setCity("city");
		s.setUsername("user");
		s.setPassword("pass");
		
		session.save(s);
		session.getTransaction().commit();
		
		//session.clear();
		session.close();
		
	}
}
