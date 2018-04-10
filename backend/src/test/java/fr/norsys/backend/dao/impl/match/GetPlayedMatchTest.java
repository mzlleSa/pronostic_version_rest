package fr.norsys.backend.dao.impl.match;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Match;

public class GetPlayedMatchTest extends AMatchDaoImplTest {

	@Test
	public void should_get_played_match() throws SQLException {

		List<Match> matchs = this.matchDao.getPlayedMatch();

		assertNotNull(matchs);
		assertFalse(matchs.size() > 0);
	}

}
