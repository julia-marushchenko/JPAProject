package com.daoImpl;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import com.java.Address;
import com.java.NotFoundException;
import com.util.HibernateUtil;
import com.dao.Dao;

public class AddressDaoImpl implements Dao<Address> {

	@Override
	public void create(Address obj) {
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
	public List<Address> read() {
		List<Address> list = new ArrayList<>();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			list = session.createCriteria(Address.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return list;
	}

	@Override
	public Address read(int id) throws NotFoundException {
		Address address = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			address = (Address) session.load(Address.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return address;
	}

	@Override
	public boolean update(Address obj) {
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
		Address address = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			address = read(id);
			session.delete(address);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}

	}

}
