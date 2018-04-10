package fr.norsys.backend.service.impl.competition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Competition;

public class FindAllTest extends ACompetitionServiceImplTest {

	@Test
	public void should_find_all_competitions() throws SQLException {

		when(this.competitionDao.findAll()).thenReturn(this.getCompetitions());
		List<Competition> competitions = this.competitionService.findAll();

		assertNotNull(competitions);
		assertTrue(competitions.size() > 0);
		assertEquals("coupe du monde", competitions.get(0).getIdentifiant());
		assertEquals("ligue des champions", competitions.get(1).getIdentifiant());
		verify(this.competitionDao, times(1)).findAll();
	}

	private List<Competition> getCompetitions() {
		List<Competition> competitions = new ArrayList<>();
		competitions.add(new Competition("coupe du monde"));
		competitions.add(new Competition("ligue des champions"));
		return competitions;
	}
}
