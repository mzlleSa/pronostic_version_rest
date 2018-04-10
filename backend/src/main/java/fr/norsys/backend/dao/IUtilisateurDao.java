package fr.norsys.backend.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import fr.norsys.backend.entity.Utilisateur;

public interface IUtilisateurDao extends ICommunDao<Utilisateur> {

	Optional<Utilisateur> findByIdentifiant(String identifiant) throws SQLException;

	Optional<Utilisateur> findByEmail(String email) throws SQLException;

	Optional<Utilisateur> findByIdentifiantMotDePasse(String identifiant, String motDePasse) throws SQLException;

	Optional<Utilisateur> findById(Long idUtilisateur) throws SQLException;

	List<Utilisateur> findAll() throws SQLException;

	void delete(Long idUtilisateur) throws SQLException;

}
