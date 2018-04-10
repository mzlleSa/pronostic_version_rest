package fr.norsys.backend.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import fr.norsys.backend.entity.Resultat;

public interface IResultatService {

	Optional<Resultat> findByIdMatchIdEquipe(Long idMatch, Long idEquipe) throws SQLException;

	List<Resultat> findByIdMatch(Long idMatch) throws SQLException;

	List<Resultat> findAll() throws SQLException;

	int update(Resultat resultat) throws SQLException;

	int add(Resultat resultat) throws SQLException;

	void delete(Long idEquipe, Long idMatch) throws SQLException;
}
