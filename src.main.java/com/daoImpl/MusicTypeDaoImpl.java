package com.daoImpl;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.dao.Dao;
import com.java.MusicType;
import com.java.NotFoundException;
import com.java.Role;
import com.util.HibernateUtil;

public class MusicTypeDaoImpl implements Dao<MusicType> {

	@Override
	public void create(MusicType obj) {
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
	public List<MusicType> read() {
		List<MusicType> list = new ArrayList<>();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			list = session.createCriteria(MusicType.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return list;
	}

	@Override
	public MusicType read(int id) throws NotFoundException {
		MusicType musicType = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			musicType = (MusicType) session.load(MusicType.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return musicType;
	}

	@Override
	public boolean update(MusicType obj) {
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
		MusicType musicType = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			musicType = read(id);
			session.delete(musicType);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		
	}
	

}
