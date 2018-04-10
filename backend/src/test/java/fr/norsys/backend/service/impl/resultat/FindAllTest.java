package fr.norsys.backend.service.impl.resultat;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Resultat;

public class FindAllTest extends AResultatServiceImplTest {

	@Test
	public void should_find_all_equipes() throws SQLException {

		when(this.resultatDao.findAll()).thenReturn(new ArrayList<Resultat>());
		List<Resultat> resultats = this.resultatService.findAll();

		assertNotNull(resultats);
		verify(this.resultatDao, times(1)).findAll();
	}
}
