package com.daoImpl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import com.dao.Dao;
import com.java.NotFoundException;
import com.java.User;
import com.util.HibernateUtil;

public class UserDaoImpl implements Dao<User> {

	@Override
	public void create(User obj) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}

	}

	@Override
	public List<User> read() {
		List<User> list = new ArrayList<>();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			list = session.createCriteria(User.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return list;
	}

	@Override
	public User read(int id) throws NotFoundException {
		User user = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			user = (User) session.load(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return user;
	}

	@Override
	public boolean update(User obj) {
		Session session = null;
		boolean updated = false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.update(obj);
			updated = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return updated;
	}

	@Override
	public void delete(int id) {
		Session session = null;
		User user = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			user = read(id);
			session.delete(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

}
