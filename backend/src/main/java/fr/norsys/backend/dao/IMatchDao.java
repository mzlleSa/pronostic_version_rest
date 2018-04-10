package fr.norsys.backend.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import fr.norsys.backend.entity.Match;

public interface IMatchDao extends ICommunDao<Match> {

	List<Match> getMatchsPoule(Long idCompetition, int poule) throws SQLException;

	List<Match> getNotPlayedMatch() throws SQLException;

	List<Match> getPlayedMatch() throws SQLException;

	Optional<Match> getById(Long idMatch) throws SQLException;

	void delete(Long idMatch) throws SQLException;

	List<Match> findAll() throws SQLException;

	Optional<Match> getNextMatch() throws SQLException;

}
