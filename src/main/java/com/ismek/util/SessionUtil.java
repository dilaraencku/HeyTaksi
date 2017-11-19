package com.ismek.util;

import org.hibernate.Session;

public class SessionUtil {
	
	public static Session session;
	
	public static Session getInstance(){
		if (session == null) {
			session = HibernateUtil.getSessionFactory().openSession();
		}
		return session;
	}

}
