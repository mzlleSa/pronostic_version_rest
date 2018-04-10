package fr.norsys.backend.service.impl.competition;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Test;

import fr.norsys.backend.entity.Competition;

public class UpdateTest extends ACompetitionServiceImplTest {

	@Test
	public void should_update_competition() throws SQLException {

		this.competitionService.update(any(Competition.class));

		verify(this.competitionDao, times(1)).update(any(Competition.class));

	}
}