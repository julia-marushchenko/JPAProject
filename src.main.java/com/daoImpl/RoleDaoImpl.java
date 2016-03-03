package com.daoImpl;

import java.util.*;
import org.hibernate.Session;
import com.dao.Dao;
import com.java.NotFoundException;
import com.java.Role;
import com.util.HibernateUtil;

public class RoleDaoImpl implements Dao<Role> {

	@Override
	public void create(Role role) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(role);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

	@Override
	public List<Role> read() {
		List<Role> list = new ArrayList<>();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			list = session.createCriteria(Role.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return list;
	}

	@Override
	public Role read(int id) throws NotFoundException {
		Role role = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			role = (Role) session.load(Role.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return role;
	}

	@Override
	public boolean update(Role obj) {
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
		Role role = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			role = read(id);
			session.delete(role);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

}
