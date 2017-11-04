package com.ismek.dao;

import java.util.List;

import org.hibernate.Session;

import com.ismek.entity.User;
import com.ismek.util.HibernateUtil;

public class UserDAO {
	Session session = HibernateUtil.getSessionFactory().openSession();
	public boolean save(User user){
		boolean result = true;
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			session.close();
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAll(String deneme){
		return session.createCriteria(User.class).list();
	}
}
