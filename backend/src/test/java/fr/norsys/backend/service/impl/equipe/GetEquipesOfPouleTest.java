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

public class GetEquipesOfPouleTest extends AEquipeServiceImplTest {

	@Test
	public void should_get_teams_when_competition_1_poule_1() throws SQLException {

		when(this.equipeDao.getEquipesOfPoule(1L, 1)).thenReturn(this.getEquipes());
		List<Equipe> equipes = this.equipeService.getEquipesOfPoule(1L, 1);

		assertNotNull(equipes);
		assertTrue(equipes.size() == 4);
		assertEquals("Bresil", equipes.get(0).getIdentifiant());
		assertEquals("Mexique", equipes.get(1).getIdentifiant());
		assertEquals("Croatie", equipes.get(2).getIdentifiant());
		assertEquals("Cameroun", equipes.get(3).getIdentifiant());
		verify(this.equipeDao, times(1)).getEquipesOfPoule(1L, 1);
	}

	private List<Equipe> getEquipes() {
		List<Equipe> equipes = new ArrayList<>();
		equipes.add(new Equipe(1L, "Bresil"));
		equipes.add(new Equipe(2L, "Mexique"));
		equipes.add(new Equipe(3L, "Croatie"));
		equipes.add(new Equipe(4L, "Cameroun"));
		return equipes;
	}
}
