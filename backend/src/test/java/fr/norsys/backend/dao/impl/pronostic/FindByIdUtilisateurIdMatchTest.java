package fr.norsys.backend.dao.impl.pronostic;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Pronostic;

public class FindByIdUtilisateurIdMatchTest extends APronosticDaoImplTest {

	@Test
	public void should_find_pronostic_when_id_utilisateur_1_id_match_1() throws SQLException {

		List<Pronostic> pronostics = this.pronosticDao.findByIdUtilisateurIdMatch(1L, 1L);

		assertNotNull(pronostics);
		assertTrue(pronostics.size() > 0);
	}
}
