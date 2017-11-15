package com.ismek.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ismek.entity.User;
import com.ismek.util.HibernateUtil;

public class UserDAO {
    Session session = HibernateUtil.getSessionFactory().openSession();

    public boolean save(User user) {
        boolean result = true;
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            session.close();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return session.createCriteria(User.class).list();
    }

    public User findUserbyId(long userId) {
        return (User) session.createQuery("from User where id=:id").
                setParameter("id", userId).uniqueResult();
    }

    public void deleteUser(long userId) {
        try {
            session.beginTransaction();
            session.createQuery("delete from User where id =:id").setParameter("id", userId).
                    executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return;
    }

    public void updateUser(User user){
        try {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return;
    }
}
