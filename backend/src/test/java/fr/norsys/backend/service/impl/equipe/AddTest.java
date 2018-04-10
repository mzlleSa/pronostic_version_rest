package fr.norsys.backend.service.impl.equipe;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Test;

import fr.norsys.backend.entity.Equipe;

public class AddTest extends AEquipeServiceImplTest {

	@Test
	public void should_add_equipe() throws SQLException {

		this.equipeService.add(any(Equipe.class));

		verify(this.equipeDao, times(1)).add(any(Equipe.class));

	}
}
