package fr.norsys.backend.dao.impl.pronostic;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Pronostic;

public class FindByIdMatchTest extends APronosticDaoImplTest {

	@Test
	public void should_find_match_when_id_1() throws SQLException {

		List<Pronostic> pronostic = this.pronosticDao.findByIdMatch(1L);

		assertNotNull(pronostic);
		assertTrue(pronostic.size() > 0);

	}

}
