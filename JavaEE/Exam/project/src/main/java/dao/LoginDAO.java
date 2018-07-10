package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Customer;
import utilities.HibernateUtil;

public class LoginDAO {

	public int validateLogin(String username, String password) {
		
		int result = 0;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Customer> list = session.createQuery("FROM Customer").list();
		
		for (Customer c : list) {
			if (c.getUsername().equals(username) && c.getPassword().equals(password)) {
				result = 1;
			}
		}
		
		session.getTransaction().commit();
        session.close();
        
		return result;				

	}
	
	public int addNewCustomer(Customer c) {
			
		int result = 0;
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			session.save(c);
			
			session.getTransaction().commit();
	        
			session.close();
			
			result = 1;
			return result;			
			
		}
		catch (Exception e) {
			return result;
		}        

	}
}
