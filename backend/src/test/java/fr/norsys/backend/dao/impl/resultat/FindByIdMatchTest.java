package fr.norsys.backend.dao.impl.resultat;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Resultat;

public class FindByIdMatchTest extends AResultatDaoImpltest {

	@Test
	public void should_all_resultats_when_match_1() throws SQLException {

		List<Resultat> resultats = this.resultatDao.findByIdMatch(1L);

		assertNotNull(resultats);
		assertTrue(resultats.size() > 0);
	}

}
