package fr.norsys.backend.service.impl.resultat;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;
import org.junit.Test;

import fr.norsys.backend.entity.Resultat;

public class AddTest extends AResultatServiceImplTest {

	@Test
	public void should_add_resultat() throws SQLException {

		this.resultatService.add(any(Resultat.class));

		verify(this.resultatDao, times(1)).add(any(Resultat.class));

	}
}
