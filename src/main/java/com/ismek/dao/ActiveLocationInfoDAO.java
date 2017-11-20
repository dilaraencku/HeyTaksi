package com.ismek.dao;

import com.ismek.entity.ActiveLocationInfo;
import com.ismek.entity.User;
import com.ismek.util.HibernateUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

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
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss");
        return (ActiveLocationInfo) session.createCriteria(ActiveLocationInfo.class)
                .add(Restrictions.eq("driverId", id))
                .uniqueResult();
    }

    public boolean save(ActiveLocationInfo activeLocationInfo) {
        try {
            session.getTransaction().begin();
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
