package fr.norsys.backend.service;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.backend.entity.Pronostic;

public interface IPronosticService {

	List<Pronostic> findByIdUtilisateurIdMatch(Long idUtilisateur, Long idMatch) throws SQLException;

	List<Pronostic> findByIdMatch(Long idMatch) throws SQLException;

	int update(Pronostic pronostic) throws SQLException;

	int add(Pronostic pronostic) throws SQLException;

}
