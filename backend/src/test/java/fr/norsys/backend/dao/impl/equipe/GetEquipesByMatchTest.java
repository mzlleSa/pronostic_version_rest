package fr.norsys.backend.dao.impl.equipe;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Equipe;

public class GetEquipesByMatchTest extends AEquipeDaoImplTest {

	@Test
	public void should_get_equipes_when_match_1() throws SQLException {

		List<Equipe> equipes = this.equipeDao.getEquipesByMatch(1L);

		assertNotNull(equipes);
		assertTrue(equipes.size() == 2);
		assertEquals("Croatie", equipes.get(0).getIdentifiant());
		assertEquals("Bresil", equipes.get(1).getIdentifiant());
	}

	@Test
	public void should_not_get_any_equipe_when_match_1() throws SQLException {

		List<Equipe> equipes = this.equipeDao.getEquipesByMatch(1L);

		assertNotNull(equipes);
		assertFalse(equipes.size() == 0);
	}
}
