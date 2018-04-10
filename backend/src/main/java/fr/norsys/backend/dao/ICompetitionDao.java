package fr.norsys.backend.dao;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.backend.entity.Competition;

public interface ICompetitionDao extends ICommunDao<Competition> {

	List<Competition> findAll() throws SQLException;

	void delete(Long idCompetition) throws SQLException;

}
