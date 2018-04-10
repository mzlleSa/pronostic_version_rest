package fr.norsys.backend.service.impl.competition;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Test;

import fr.norsys.backend.entity.Competition;

public class AddTest extends ACompetitionServiceImplTest {

	@Test
	public void should_add_competition() throws SQLException {

		this.competitionService.add(any(Competition.class));

		verify(this.competitionDao, times(1)).add(any(Competition.class));

	}
}
