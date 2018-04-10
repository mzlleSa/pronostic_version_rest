package fr.norsys.backend.service.impl.competition;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Test;

public class DeleteTest extends ACompetitionServiceImplTest {

	@Test
	public void should_delete_competition() throws SQLException {

		this.competitionService.delete(any(Long.class));

		verify(this.competitionDao, times(1)).delete(any(Long.class));

	}
}