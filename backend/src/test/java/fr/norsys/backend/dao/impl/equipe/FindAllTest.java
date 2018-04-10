package fr.norsys.backend.dao.impl.equipe;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

import fr.norsys.backend.entity.Equipe;

public class FindAllTest extends AEquipeDaoImplTest {

	@Test
	public void should_find_all_equipes() throws SQLException {

		List<Equipe> equipes = this.equipeDao.findAll();

		assertNotNull(equipes);
		assertTrue(equipes.size() > 0);
	}

	@Test
	public void should_not_find_any_competitions() throws SQLException {

		List<Equipe> equipes = this.equipeDao.findAll();

		assertNotNull(equipes);
		assertFalse(equipes.size() == 0);
	}

}
