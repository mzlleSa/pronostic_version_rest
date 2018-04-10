package fr.norsys.backend.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import fr.norsys.backend.entity.Match;

public interface IMatchService {

	List<Match> getMatchsPouleWithEquipes(Long idCompetition, int poule) throws SQLException;

	List<Match> getMatchsPoule(Long idCompetition, int poule) throws SQLException;

	List<Match> getNotPlayedMatch() throws SQLException;

	List<Match> getPlayedMatch() throws SQLException;

	Optional<Match> getById(Long id) throws SQLException;

	List<Match> findAll() throws SQLException;

	int setTrueForPlayedMatch() throws SQLException;

	int update(Match match) throws SQLException;

	int add(Match match) throws SQLException;

	void delete(Long id) throws SQLException;

	Optional<Match> getNextMatch() throws SQLException;

	Match getNextMatchWithEquipes() throws SQLException;

}
