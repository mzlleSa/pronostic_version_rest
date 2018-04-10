package fr.norsys.backend.service.impl.pronostic;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;
import org.junit.Test;

import fr.norsys.backend.entity.Pronostic;

public class UpdatePronosticTest extends APronosticServiceImplTest {

	@Test
	public void should_update_pronostic() throws SQLException {

		this.pronosticService.update(any(Pronostic.class));

		verify(this.pronosticDao, times(1)).update(any(Pronostic.class));

	}
}
