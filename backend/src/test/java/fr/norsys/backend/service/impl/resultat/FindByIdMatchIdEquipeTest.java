package fr.norsys.backend.service.impl.resultat;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Test;

public class FindByIdMatchIdEquipeTest extends AResultatServiceImplTest {

	@Test
	public void should_find_by_id_match_id_equipe() throws SQLException {

		this.resultatService.findByIdMatchIdEquipe(anyLong(), any());

		verify(this.resultatDao, times(1)).findByIdMatchIdEquipe(anyLong(), any());

	}
}