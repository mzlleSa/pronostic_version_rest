package fr.norsys.backend.service.impl.match;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Test;

public class DeleteTest extends AMatchServiceImplTest {

	@Test
	public void should_delete_match() throws SQLException {

		this.matchService.delete(any(Long.class));

		verify(this.matchDao, times(1)).delete(any(Long.class));

	}

}
