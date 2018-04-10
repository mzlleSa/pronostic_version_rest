package fr.norsys.backend.service.impl.match;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Match;

public class SetTrueForPlayedMatchTest extends AMatchServiceImplTest {

	@Test
	public void should_set_true_for_played_match() throws SQLException {

		when(this.matchDao.update(any(Match.class))).thenReturn(1);
		when(this.matchDao.getNotPlayedMatch()).thenReturn(this.getMatchs());
		int compteur = this.matchService.setTrueForPlayedMatch();

		assertEquals(5, compteur);
		verify(this.matchDao, times(1)).getNotPlayedMatch();
		verify(this.matchDao, times(5)).update(any(Match.class));
	}

	private List<Match> getMatchs() {
		List<Match> matchs = new ArrayList<Match>();
		matchs.add(new Match());
		matchs.add(new Match());
		matchs.add(new Match());
		matchs.add(new Match());
		matchs.add(new Match());
		return matchs;
	}
}
