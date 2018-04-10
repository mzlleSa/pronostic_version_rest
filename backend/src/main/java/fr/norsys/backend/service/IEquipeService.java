package fr.norsys.backend.service;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.backend.entity.Equipe;

public interface IEquipeService {

	List<Equipe> getEquipesOfPoule(Long idCompetition, int poule) throws SQLException;

	List<Equipe> getEquipesByMatch(Long idMatch) throws SQLException;

	List<Equipe> findAll() throws SQLException;

	int add(Equipe equipe) throws SQLException;

	int update(Equipe equipe) throws SQLException;

	void delete(Long id) throws SQLException;

}
