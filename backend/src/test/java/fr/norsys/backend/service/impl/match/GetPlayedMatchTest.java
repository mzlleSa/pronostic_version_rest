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

public class GetPlayedMatchTest extends AMatchServiceImplTest {

	@Test
	public void should_get_played_match() throws SQLException {

		when(this.matchDao.getPlayedMatch()).thenReturn(this.PlayedMatchs());
		List<Match> matchs = this.matchService.getPlayedMatch();

		assertNotNull(matchs);
		assertTrue(matchs.size() == 2);
		verify(this.matchDao, times(1)).getPlayedMatch();
	}

	private List<Match> PlayedMatchs() {
		List<Match> matchs = new ArrayList<Match>();
		matchs.add(new Match());
		matchs.add(new Match());
		return matchs;
	}

}
