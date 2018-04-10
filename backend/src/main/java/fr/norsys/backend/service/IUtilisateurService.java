package fr.norsys.backend.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import fr.norsys.backend.entity.Utilisateur;

public interface IUtilisateurService {

	Optional<Utilisateur> findByIdentifiant(String identifiant) throws SQLException;

	Optional<Utilisateur> findByEmail(String email) throws SQLException;

	Optional<Utilisateur> findByIdentifiantMotDePasse(String identifiant, String motDePasse) throws SQLException;

	Optional<Utilisateur> signOn(String identifiant, String motDePasse) throws SQLException;

	Optional<Utilisateur> findById(Long idUtilisateur) throws SQLException;

	List<Utilisateur> findAll() throws SQLException;

	void setScoreForUser(Long idUtilisateur, Long idMatch) throws SQLException;

	void setRankForUser() throws SQLException;

	int add(Utilisateur utilisateur) throws SQLException;

	int update(Utilisateur utilisateur) throws SQLException;

	void delete(Long idUtilisateur) throws SQLException;

}
