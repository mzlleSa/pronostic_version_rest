package fr.norsys.backend.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.backend.dao.IPronosticDao;
import fr.norsys.backend.entity.Pronostic;
import fr.norsys.backend.service.IPronosticService;

@Service
public class PronosticServiceImpl implements IPronosticService {

	@Autowired
	private IPronosticDao pronosticDao;

	@Override
	public int add(Pronostic pronostic) throws SQLException {
		return pronosticDao.add(pronostic);
	}

	@Override
	public List<Pronostic> findByIdUtilisateurIdMatch(Long idUtilisateur, Long idMatch) throws SQLException {
		return this.pronosticDao.findByIdUtilisateurIdMatch(idUtilisateur, idMatch);
	}

	@Override
	public int update(Pronostic pronostic) throws SQLException {
		return this.pronosticDao.update(pronostic);
	}

	public void setPronosticDao(IPronosticDao pronosticDao) {
		this.pronosticDao = pronosticDao;
	}

	@Override
	public List<Pronostic> findByIdMatch(Long idMatch) throws SQLException {
		return pronosticDao.findByIdMatch(idMatch);
	}

}
