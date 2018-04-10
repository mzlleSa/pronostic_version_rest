package fr.norsys.backend.service.impl.match;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Match;

public class GetNotPlayedMatchTest extends AMatchServiceImplTest {

	@Test
	public void should_get_not_played_match() throws SQLException {

		when(this.matchDao.getNotPlayedMatch()).thenReturn(this.notPlayedMatchs());
		List<Match> matchs = this.matchService.getNotPlayedMatch();

		assertNotNull(matchs);
		assertTrue(matchs.size() == 2);
		verify(this.matchDao, times(1)).getNotPlayedMatch();
	}

	private List<Match> notPlayedMatchs() {
		List<Match> matchs = new ArrayList<Match>();
		matchs.add(new Match());
		matchs.add(new Match());
		return matchs;
	}
}
