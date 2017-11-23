package com.ismek.dao;

import java.util.List;

import org.hibernate.Session;

import com.ismek.entity.TravelSatisfactionInformation;
import com.ismek.util.HibernateUtil;
import com.ismek.util.SessionUtil;

public class TravelSatisfactionInformationDAO {

public boolean save(TravelSatisfactionInformation travelsatisfactioninformation) {
	Session session = SessionUtil.getInstance();
	boolean result=true;
	
	try {
		session.beginTransaction();
		session.save(travelsatisfactioninformation);
		session.getTransaction().commit();
	}catch(Exception e) {
		e.printStackTrace();
		result=false;
	}
	
	return result;
}

public List<TravelSatisfactionInformation> findAll(){
	Session session =SessionUtil.getInstance();
	List<TravelSatisfactionInformation> tsis=null;
	try {
		tsis=session.createCriteria(TravelSatisfactionInformation.class).list();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return tsis;
}

public TravelSatisfactionInformation findtravelsatisfactioninformationbyId(long travelsatisfactioninformationId) {
	Session session =SessionUtil.getInstance();
	return (TravelSatisfactionInformation)session.createQuery("from Travelsatisfactioninformation where id=: id").
			setParameter("id",travelsatisfactioninformationId).uniqueResult();
}
public void deleteTravelSatisfactionInformation(long travelsatisfactioninformationId) {
	Session session =SessionUtil.getInstance();
	try {
		session.getTransaction().begin();
		session.createQuery("delete from travel satisfaction information where id=:id").setParameter("id",travelsatisfactioninformationId).
	           executeUpdate();
		session.getTransaction().commit();
		System.out.println("delete successfully");
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println("delete failed");
		session.getTransaction().rollback();
		}
	return;
}

public void updateTravelSatisfactionInformation(TravelSatisfactionInformation travelsatisfactioninformation) {
	Session session =SessionUtil.getInstance();
	try {
		session.getTransaction().begin();
		session.update(travelsatisfactioninformation);
		session.getTransaction().commit();
		System.out.println("uptated successfully");
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println("failed update");
	}
	return;
}
}
