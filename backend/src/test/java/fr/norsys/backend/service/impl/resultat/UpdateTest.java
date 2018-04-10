package fr.norsys.backend.service.impl.resultat;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;
import org.junit.Test;

import fr.norsys.backend.entity.Resultat;

public class UpdateTest extends AResultatServiceImplTest {

	@Test
	public void should_update_resultat() throws SQLException {

		this.resultatService.update(any(Resultat.class));

		verify(this.resultatDao, times(1)).update(any(Resultat.class));

	}
}