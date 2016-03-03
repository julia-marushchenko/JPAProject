package com.dao;

import java.util.List;
import com.java.NotFoundException;

public interface Dao <T> {
	void create(T obj);

	List<T> read();

	T read(int id) throws NotFoundException;

	boolean update(T obj);

	void delete(int id);
}
