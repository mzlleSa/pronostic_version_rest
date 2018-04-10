package fr.norsys.backend.service.impl.resultat;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import fr.norsys.backend.entity.Resultat;

public class FindByIdMatchTest extends AResultatServiceImplTest {

	@Test
	public void should_find_by_id_match() throws SQLException {

		when(this.resultatDao.findByIdMatch(anyLong())).thenReturn(this.getResultats());
		List<Resultat> resultats = this.resultatService.findByIdMatch(anyLong());

		assertNotNull(resultats);
		assertTrue(resultats.size() == 2);
		verify(this.resultatDao, times(1)).findByIdMatch(anyLong());
	}

	private List<Resultat> getResultats() {
		List<Resultat> resultats = new ArrayList<Resultat>();
		resultats.add(new Resultat());
		resultats.add(new Resultat());
		return resultats;
	}
}
