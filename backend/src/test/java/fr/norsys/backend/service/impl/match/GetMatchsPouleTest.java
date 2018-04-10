package fr.norsys.backend.service.impl.match;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Match;

public class GetMatchsPouleTest extends AMatchServiceImplTest {

	@Test
	public void should_get_matchs_when_poule_1_competition_1() throws SQLException {

		when(this.matchDao.getMatchsPoule(1L, 1)).thenReturn(this.getMatchs());
		List<Match> matchs = this.matchService.getMatchsPoule(1L, 1);

		assertNotNull(matchs);
		assertTrue(matchs.size() == 6);
		assertEquals("match 1", matchs.get(0).getIdentifiant());
		assertEquals("match 2", matchs.get(1).getIdentifiant());
		assertEquals("match 3", matchs.get(2).getIdentifiant());
		assertEquals("match 4", matchs.get(3).getIdentifiant());
		assertEquals("match 5", matchs.get(4).getIdentifiant());
		assertEquals("match 6", matchs.get(5).getIdentifiant());
	}

	private List<Match> getMatchs() {
		List<Match> matchs = new ArrayList<Match>();
		matchs.add(new Match(1L, "match 1"));
		matchs.add(new Match(2L, "match 2"));
		matchs.add(new Match(3L, "match 3"));
		matchs.add(new Match(4L, "match 4"));
		matchs.add(new Match(5L, "match 5"));
		matchs.add(new Match(6L, "match 6"));
		return matchs;
	}

}
