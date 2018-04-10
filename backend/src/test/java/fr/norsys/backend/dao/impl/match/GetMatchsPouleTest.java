package fr.norsys.backend.dao.impl.match;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Match;

public class GetMatchsPouleTest extends AMatchDaoImplTest {

	@Test
	public void should_get_matchs_when_competition_1_poule_1() throws SQLException {

		List<Match> matchs = this.matchDao.getMatchsPoule(1L, 1);

		assertNotNull(matchs);
		assertTrue(matchs.size() == 6);
		assertEquals("match 1", matchs.get(0).getIdentifiant());
		assertEquals("match 2", matchs.get(1).getIdentifiant());
		assertEquals("match 3", matchs.get(2).getIdentifiant());
		assertEquals("match 4", matchs.get(3).getIdentifiant());
		assertEquals("match 5", matchs.get(4).getIdentifiant());
		assertEquals("match 6", matchs.get(5).getIdentifiant());
	}
}
