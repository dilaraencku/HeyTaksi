package com.ismek.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ismek.entity.ActiveLocationInfo;
import com.ismek.util.HibernateUtil;

/**
 * Created by İhsan on 11/20/2017.
 */
public class ActiveLocationInfoDAO {

    Session session = HibernateUtil.getSessionFactory().openSession();

    @SuppressWarnings("unchecked")
    public List<ActiveLocationInfo> findAll() {
        return session.createCriteria(ActiveLocationInfo.class).list();
    }

    public ActiveLocationInfo findById(long id) {
        return (ActiveLocationInfo) session.createCriteria(ActiveLocationInfo.class).
                add(Restrictions.eq("id", id)).uniqueResult();

    }

    public ActiveLocationInfo findByDriverId(long id) {
        ActiveLocationInfo activeLocationInfo = (ActiveLocationInfo) session.createCriteria(ActiveLocationInfo.class)
                .add(Restrictions.eq("driverId", id))
                .uniqueResult();
        //System.out.println(DateUtil.parseDate(activeLocationInfo.getCdate()));
        //activeLocationInfo.setCdate(DateUtil.parseDate(activeLocationInfo.getCdate()));
        return activeLocationInfo;
    }

    public boolean save(ActiveLocationInfo activeLocationInfo) {
        try {
            session.getTransaction().begin();
            //activeLocationInfo.setCdate(DateUtil.convertToSQLDate(activeLocationInfo.getCdate()));
            session.save(activeLocationInfo);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean delete(long id) {
        try {
            session.getTransaction().begin();
            ActiveLocationInfo data = (ActiveLocationInfo) session.get(ActiveLocationInfo.class, id);
            session.delete(data);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean update(ActiveLocationInfo activeLocationInfo) {
        try {
            session.getTransaction().begin();
            //activeLocationInfo.setCdate(DateUtil.convertToSQLDate(activeLocationInfo.getCdate()));
            session.update(activeLocationInfo);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
}
