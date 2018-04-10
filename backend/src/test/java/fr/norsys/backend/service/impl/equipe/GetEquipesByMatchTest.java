package fr.norsys.backend.service.impl.equipe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Equipe;

public class GetEquipesByMatchTest extends AEquipeServiceImplTest {

	@Test
	public void should_get_teams_when_match_1() throws SQLException {

		when(this.equipeDao.getEquipesByMatch(1L)).thenReturn(this.getEquipesMatch1());
		List<Equipe> equipes = this.equipeService.getEquipesByMatch(1L);

		assertNotNull(equipes);
		assertTrue(equipes.size() == 2);
		assertEquals("Bresil", equipes.get(0).getIdentifiant());
		assertEquals("Croatie", equipes.get(1).getIdentifiant());
		verify(this.equipeDao, times(1)).getEquipesByMatch(1L);
	}

	private List<Equipe> getEquipesMatch1() {
		List<Equipe> equipes = new ArrayList<>();
		equipes.add(new Equipe(1L, "Bresil"));
		equipes.add(new Equipe(3L, "Croatie"));
		return equipes;
	}
}
