package fr.norsys.backend.dao.impl.match;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Match;

public class FindAllTest extends AMatchDaoImplTest {

	@Test
	public void should_find_all_matchs() throws SQLException {

		List<Match> matchs = this.matchDao.findAll();

		assertNotNull(matchs);
		assertTrue(matchs.size() > 0);
	}

	@Test
	public void should_not_find_any_matchs() throws SQLException {

		List<Match> matchs = this.matchDao.findAll();

		assertNotNull(matchs);
		assertFalse(matchs.size() == 0);
	}

}
