package fr.norsys.backend.service.impl.pronostic;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Test;

public class FindByIdMatchTest extends APronosticServiceImplTest {

	@Test
	public void should_find_pronostic_by_id() throws SQLException {

		this.pronosticService.findByIdMatch(anyLong());

		verify(this.pronosticDao, times(1)).findByIdMatch(anyLong());
	}
}
