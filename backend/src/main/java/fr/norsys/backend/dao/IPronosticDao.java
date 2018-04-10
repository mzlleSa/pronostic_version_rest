package fr.norsys.backend.dao;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.backend.entity.Pronostic;

public interface IPronosticDao extends ICommunDao<Pronostic> {

	List<Pronostic> findByIdUtilisateurIdMatch(Long idUtilisateur, Long idMatch) throws SQLException;

	List<Pronostic> findByIdMatch(Long idMatch) throws SQLException;

}