package fr.norsys.backend.service;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.backend.entity.Competition;

public interface ICompetitionService {

	List<Competition> findAll() throws SQLException;

	public int add(Competition competition) throws SQLException;

	public int update(Competition competition) throws SQLException;

	public void delete(Long id) throws SQLException;

}
