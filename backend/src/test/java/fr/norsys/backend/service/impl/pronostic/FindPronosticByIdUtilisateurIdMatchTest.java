package fr.norsys.backend.service.impl.pronostic;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Pronostic;

public class FindPronosticByIdUtilisateurIdMatchTest extends APronosticServiceImplTest {

	@Test
	public void should_find_pronostic_when_user_1_match_1() throws SQLException {

		when(this.pronosticDao.findByIdUtilisateurIdMatch(1L, 1L)).thenReturn(this.getPronostics());
		List<Pronostic> pronostics = this.pronosticService.findByIdUtilisateurIdMatch(1L, 1L);

		assertNotNull(pronostics);
		assertTrue(pronostics.size() == 2);
		verify(this.pronosticDao, timeout(1)).findByIdUtilisateurIdMatch(1L, 1L);
	}

	private List<Pronostic> getPronostics() {
		List<Pronostic> pronostics = new ArrayList<Pronostic>();
		pronostics.add(new Pronostic(1L, 1L, 1L, 2));
		pronostics.add(new Pronostic(1L, 2L, 1L, 3));
		return pronostics;
	}
}
