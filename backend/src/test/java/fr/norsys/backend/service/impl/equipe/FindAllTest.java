package fr.norsys.backend.service.impl.equipe;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Equipe;

public class FindAllTest extends AEquipeServiceImplTest {

	@Test
	public void should_find_all_equipes() throws SQLException {

		when(this.equipeDao.findAll()).thenReturn(new ArrayList<Equipe>());
		List<Equipe> equipes = this.equipeService.findAll();

		assertNotNull(equipes);
		verify(this.equipeDao, times(1)).findAll();
	}
}
