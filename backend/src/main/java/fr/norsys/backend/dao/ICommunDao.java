package fr.norsys.backend.dao;

import java.sql.SQLException;

public interface ICommunDao<T> {

	public int add(T object) throws SQLException;

	public int update(T object) throws SQLException;

}
