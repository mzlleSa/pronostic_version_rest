package fr.norsys.backend.dao.impl.resultat;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Resultat;

public class FindAllTest extends AResultatDaoImpltest {

	@Test
	public void should_find_all_resultats() throws SQLException {

		List<Resultat> resultats = this.resultatDao.findAll();

		assertNotNull(resultats);
		assertTrue(resultats.size() > 0);
	}

	@Test
	public void should_not_find_any_matchs() throws SQLException {

		List<Resultat> resultats = this.resultatDao.findAll();

		assertNotNull(resultats);
		assertFalse(resultats.size() == 0);
	}

}
