package fr.norsys.backend.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.backend.dao.IEquipeDao;
import fr.norsys.backend.dao.IMatchDao;
import fr.norsys.backend.entity.Match;
import fr.norsys.backend.service.IMatchService;

@Service
public class MatchServiceImpl implements IMatchService {

	@Autowired
	private IMatchDao matchDao;

	@Autowired
	private IEquipeDao equipeDao;

	@Override
	public List<Match> getMatchsPouleWithEquipes(Long idCompetition, int poule) throws SQLException {
		List<Match> matchs = new ArrayList<Match>();
		List<Match> matchSansEquipes = matchDao.getMatchsPoule(idCompetition, poule);
		for (Match match : matchSansEquipes) {
			match.setEquipes(equipeDao.getEquipesByMatch(match.getId()));
			matchs.add(match);
		}
		return matchs;
	}

	@Override
	public List<Match> getMatchsPoule(Long idCompetition, int poule) throws SQLException {
		return matchDao.getMatchsPoule(idCompetition, poule);
	}

	@Override
	public int setTrueForPlayedMatch() throws SQLException {
		int compteur = 0;
		List<Match> matchs = this.matchDao.getNotPlayedMatch();
		for (Match match : matchs) {
			match.setEstJouer(true);
			compteur += this.matchDao.update(match);
		}
		return compteur;
	}

	@Override
	public Optional<Match> getById(Long id) throws SQLException {
		return matchDao.getById(id);
	}

	@Override
	public int update(Match match) throws SQLException {
		return matchDao.update(match);
	}

	@Override
	public List<Match> getNotPlayedMatch() throws SQLException {
		return matchDao.getNotPlayedMatch();
	}

	@Override
	public int add(Match match) throws SQLException {
		return matchDao.add(match);
	}

	@Override
	public List<Match> getPlayedMatch() throws SQLException {
		return matchDao.getPlayedMatch();
	}

	@Override
	public void delete(Long idMatch) throws SQLException {
		this.matchDao.delete(idMatch);
	}

	@Override
	public List<Match> findAll() throws SQLException {
		return this.matchDao.findAll();
	}

	@Override
	public Optional<Match> getNextMatch() throws SQLException {
		return this.matchDao.getNextMatch();
	}

	@Override
	public Match getNextMatchWithEquipes() throws SQLException {
		Optional<Match> match = this.matchDao.getNextMatch();
		match.get().setEquipes(equipeDao.getEquipesByMatch(match.get().getId()));
		return match.get();
	}

	public void setMatchDao(IMatchDao matchDao) {
		this.matchDao = matchDao;
	}

	public void setEquipeDao(IEquipeDao equipeDao) {
		this.equipeDao = equipeDao;
	}

}
