package fr.norsys.backend.service.impl.match;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;
import org.junit.Test;

import fr.norsys.backend.entity.Match;

public class AddTest extends AMatchServiceImplTest {

	@Test
	public void should_add_match() throws SQLException {

		this.matchService.add(any(Match.class));

		verify(this.matchDao, times(1)).add(any(Match.class));

	}

}
