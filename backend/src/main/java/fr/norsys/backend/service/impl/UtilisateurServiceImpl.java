package fr.norsys.backend.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.backend.dao.IPronosticDao;
import fr.norsys.backend.dao.IResultatDao;
import fr.norsys.backend.dao.IUtilisateurDao;
import fr.norsys.backend.entity.Pronostic;
import fr.norsys.backend.entity.Utilisateur;
import fr.norsys.backend.service.IUtilisateurService;
import fr.norsys.backend.util.UtilisateurUtil;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

	@Autowired
	private IUtilisateurDao utilisateurDao;

	@Autowired
	private IPronosticDao pronosticDao;

	@Autowired
	private IResultatDao resultatDao;

	@Override
	public int add(Utilisateur utilisateur) throws SQLException {
		return utilisateurDao.add(utilisateur);
	}

	@Override
	public Optional<Utilisateur> findByIdentifiant(String identifiant) throws SQLException {
		return utilisateurDao.findByIdentifiant(identifiant);
	}

	@Override
	public Optional<Utilisateur> findByEmail(String email) throws SQLException {
		return utilisateurDao.findByEmail(email);
	}

	@Override
	public Optional<Utilisateur> findByIdentifiantMotDePasse(String identifiant, String motDePasse)
			throws SQLException {
		return utilisateurDao.findByIdentifiantMotDePasse(identifiant, motDePasse);
	}

	public void setDaoUtilisateur(IUtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

	@Override
	public Optional<Utilisateur> signOn(String identifiant, String motDePasse) throws SQLException {
		return this.utilisateurDao.findByIdentifiantMotDePasse(identifiant, motDePasse);

	}

	@Override
	public Optional<Utilisateur> findById(Long idUtilisateur) throws SQLException {
		return utilisateurDao.findById(idUtilisateur);
	}

	@Override
	public List<Utilisateur> findAll() throws SQLException {
		return utilisateurDao.findAll();
	}

	@Override
	public void setScoreForUser(Long idUtilisateur, Long idMatch) throws SQLException {
		List<Pronostic> pronostics = pronosticDao.findByIdUtilisateurIdMatch(idUtilisateur, idMatch);
		if (!pronostics.isEmpty()) {
			int score1 = resultatDao.findByIdMatchIdEquipe(idMatch, pronostics.get(0).getIdEquipe()).get().getScore();
			int score2 = resultatDao.findByIdMatchIdEquipe(idMatch, pronostics.get(1).getIdEquipe()).get().getScore();
			int prediction1 = pronostics.get(0).getPrediction();
			int prediction2 = pronostics.get(1).getPrediction();
			int points = UtilisateurUtil.calculatePoints(score1, score2, prediction1, prediction2);
			Utilisateur utilisateur = utilisateurDao.findById(idUtilisateur).get();
			utilisateur.setScore(utilisateur.getScore() + points);
			utilisateurDao.update(utilisateur);
		}
	}

	@Override
	public void setRankForUser() throws SQLException {
		List<Utilisateur> utilisateurs = utilisateurDao.findAll();
		UtilisateurUtil.sortListByScore(utilisateurs);
		for (Utilisateur utilisateur : utilisateurs) {
			utilisateur.setClassement(utilisateurs.indexOf(utilisateur) + 1);
			utilisateurDao.update(utilisateur);
		}
	}

	public void setUtilisateurDao(IUtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

	@Override
	public int update(Utilisateur utilisateur) throws SQLException {
		return utilisateurDao.update(utilisateur);
	}

	@Override
	public void delete(Long idUtilisateur) throws SQLException {
		this.utilisateurDao.delete(idUtilisateur);
	}

	public void setPronosticDao(IPronosticDao pronosticDao) {
		this.pronosticDao = pronosticDao;
	}

	public void setResultatDao(IResultatDao resultatDao) {
		this.resultatDao = resultatDao;
	}

}
