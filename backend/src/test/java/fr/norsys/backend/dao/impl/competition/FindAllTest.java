package fr.norsys.backend.dao.impl.competition;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

import fr.norsys.backend.entity.Competition;

public class FindAllTest extends ACompetitionDaoImplTest {

	@Test
	public void should_find_all_competitions() throws SQLException {

		List<Competition> competitions = this.competitionDao.findAll();

		assertNotNull(competitions);
		assertTrue(competitions.size() > 0);
		assertEquals("coupe du monde", competitions.get(0).getIdentifiant());
	}

	@Test
	public void should_not_find_any_competitions() throws SQLException {

		List<Competition> competitions = this.competitionDao.findAll();

		assertNotNull(competitions);
		assertFalse(competitions.size() == 0);
	}

}
