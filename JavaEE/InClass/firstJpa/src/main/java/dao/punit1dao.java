package dao;

import model.*;

import java.util.ArrayList;

import javax.persistence.*;

public class punit1dao {
	
	EntityManagerFactory emf = 	Persistence.createEntityManagerFactory("punit1");
	EntityManager em = emf.createEntityManager();

	public student getStudentById(int id) {
				
		return em.find(student.class, id);
		//return em.find(student2.class, 5);

	}
	
	public void addNewStudent(String name, String pass) {
		
		student s = new student();
		
		s.setName(name);
		s.setPass(pass);
		
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();

		/*
		em.close();
		emf.close();
		 */
	}
	
	public void updateStudentById(int id) {
		
		student s = getStudentById(id);
		
		s.setName("updatetest");
		s.setPass("updated");
		
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();

	}

	public ArrayList<Integer> getAllIds() {
		
		String queryString = "Select id from student";
		Query query = em.createQuery(queryString);

		return (ArrayList<Integer>) query.getResultList();

	}
}
