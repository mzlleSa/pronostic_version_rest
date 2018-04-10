package fr.norsys.backend.service.impl.match;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Equipe;
import fr.norsys.backend.entity.Match;

public class GetMatchsPouleWithEquipesTest extends AMatchServiceImplTest {

	@Test
	public void should_get_matchs_when_1_poule_1() throws SQLException {

		List<Match> matchsSansEquipes = getMatchsWithOutTeam();
		List<Equipe> listEquipesM1 = getEquipesM1();
		List<Equipe> listEquipesM2 = getEquipesM2();
		List<Equipe> listEquipesM3 = getEquipesM3();
		List<Equipe> listEquipesM4 = getEquipesM4();
		List<Equipe> listEquipesM5 = getEquipesM5();
		List<Equipe> listEquipesM6 = getEquipesM6();

		when(this.matchDao.getMatchsPoule(1L, 1)).thenReturn(matchsSansEquipes);
		when(this.equipeDao.getEquipesByMatch(1L)).thenReturn(listEquipesM1);
		when(this.equipeDao.getEquipesByMatch(2L)).thenReturn(listEquipesM2);
		when(this.equipeDao.getEquipesByMatch(3L)).thenReturn(listEquipesM3);
		when(this.equipeDao.getEquipesByMatch(4L)).thenReturn(listEquipesM4);
		when(this.equipeDao.getEquipesByMatch(5L)).thenReturn(listEquipesM5);
		when(this.equipeDao.getEquipesByMatch(6L)).thenReturn(listEquipesM6);
		List<Match> matchs = this.matchService.getMatchsPouleWithEquipes(1L, 1);

		assertNotNull(matchs);
		assertTrue(matchs.size() == 6);
		assertEquals("match 1", matchs.get(0).getIdentifiant());
		assertEquals("match 2", matchs.get(1).getIdentifiant());
		assertEquals("match 3", matchs.get(2).getIdentifiant());
		assertEquals("match 4", matchs.get(3).getIdentifiant());
		assertEquals("match 5", matchs.get(4).getIdentifiant());
		assertEquals("match 6", matchs.get(5).getIdentifiant());
		assertEquals("Bresil", matchs.get(0).getEquipes().get(0).getIdentifiant());
		assertEquals("Croatie", matchs.get(0).getEquipes().get(1).getIdentifiant());
		assertEquals("Mexique", matchs.get(1).getEquipes().get(0).getIdentifiant());
		assertEquals("Cameroun", matchs.get(1).getEquipes().get(1).getIdentifiant());
		assertEquals("Bresil", matchs.get(2).getEquipes().get(0).getIdentifiant());
		assertEquals("Mexique", matchs.get(2).getEquipes().get(1).getIdentifiant());
		assertEquals("Croatie", matchs.get(3).getEquipes().get(0).getIdentifiant());
		assertEquals("Cameroun", matchs.get(3).getEquipes().get(1).getIdentifiant());
		assertEquals("Mexique", matchs.get(4).getEquipes().get(0).getIdentifiant());
		assertEquals("Croatie", matchs.get(4).getEquipes().get(1).getIdentifiant());
		assertEquals("Bresil", matchs.get(5).getEquipes().get(0).getIdentifiant());
		assertEquals("Cameroun", matchs.get(5).getEquipes().get(1).getIdentifiant());
	}

	private List<Equipe> getEquipesM1() {
		List<Equipe> listEquipes = new ArrayList<Equipe>();
		listEquipes.add(new Equipe(1L, "Bresil"));
		listEquipes.add(new Equipe(2L, "Croatie"));
		return listEquipes;
	}

	private List<Equipe> getEquipesM2() {
		List<Equipe> listEquipes = new ArrayList<Equipe>();
		listEquipes.add(new Equipe(1L, "Mexique"));
		listEquipes.add(new Equipe(2L, "Cameroun"));
		return listEquipes;
	}

	private List<Equipe> getEquipesM3() {
		List<Equipe> listEquipes = new ArrayList<Equipe>();
		listEquipes.add(new Equipe(1L, "Bresil"));
		listEquipes.add(new Equipe(2L, "Mexique"));
		return listEquipes;
	}

	private List<Equipe> getEquipesM4() {
		List<Equipe> listEquipes = new ArrayList<Equipe>();
		listEquipes.add(new Equipe(1L, "Croatie"));
		listEquipes.add(new Equipe(2L, "Cameroun"));
		return listEquipes;
	}

	private List<Equipe> getEquipesM5() {
		List<Equipe> listEquipes = new ArrayList<Equipe>();
		listEquipes.add(new Equipe(1L, "Mexique"));
		listEquipes.add(new Equipe(2L, "Croatie"));
		return listEquipes;
	}

	private List<Equipe> getEquipesM6() {
		List<Equipe> listEquipes = new ArrayList<Equipe>();
		listEquipes.add(new Equipe(1L, "Bresil"));
		listEquipes.add(new Equipe(2L, "Cameroun"));
		return listEquipes;
	}

	private List<Match> getMatchsWithOutTeam() {
		List<Match> matchsSansEquipes = new ArrayList<Match>();
		matchsSansEquipes.add(new Match(1L, "match 1"));
		matchsSansEquipes.add(new Match(2L, "match 2"));
		matchsSansEquipes.add(new Match(3L, "match 3"));
		matchsSansEquipes.add(new Match(4L, "match 4"));
		matchsSansEquipes.add(new Match(5L, "match 5"));
		matchsSansEquipes.add(new Match(6L, "match 6"));
		return matchsSansEquipes;
	}
}
