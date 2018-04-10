package fr.norsys.backend.service.impl.match;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;
import org.junit.Test;

public class GetByIdTest extends AMatchServiceImplTest {

	@Test
	public void should_get_match() throws SQLException {

		this.matchService.getById(anyLong());

		verify(this.matchDao, times(1)).getById(anyLong());
	}
}