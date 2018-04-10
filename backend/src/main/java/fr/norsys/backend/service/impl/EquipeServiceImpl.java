package fr.norsys.backend.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.backend.dao.IEquipeDao;
import fr.norsys.backend.entity.Equipe;
import fr.norsys.backend.service.IEquipeService;

@Service
public class EquipeServiceImpl implements IEquipeService {

	@Autowired
	private IEquipeDao equipeDao;

	@Override
	public List<Equipe> getEquipesOfPoule(Long idCompetition, int poule) throws SQLException {
		return equipeDao.getEquipesOfPoule(idCompetition, poule);
	}

	@Override
	public List<Equipe> getEquipesByMatch(Long idMatch) throws SQLException {
		return equipeDao.getEquipesByMatch(idMatch);
	}

	public void setDaoEquipe(IEquipeDao equipeDao) {
		this.equipeDao = equipeDao;
	}

	public void setEquipeDao(IEquipeDao equipeDao) {
		this.equipeDao = equipeDao;
	}

	@Override
	public int add(Equipe equipe) throws SQLException {
		return this.equipeDao.add(equipe);
	}

	@Override
	public int update(Equipe equipe) throws SQLException {
		return this.equipeDao.update(equipe);
	}

	@Override
	public void delete(Long idEquipe) throws SQLException {
		this.equipeDao.delete(idEquipe);
	}

	@Override
	public List<Equipe> findAll() throws SQLException {
		return this.equipeDao.findAll();
	}
}
