package fr.norsys.backend.service.impl.equipe;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Test;

import fr.norsys.backend.entity.Equipe;

public class UpdateTest extends AEquipeServiceImplTest {

	@Test
	public void should_update_equipe() throws SQLException {

		this.equipeService.update(any(Equipe.class));

		verify(this.equipeDao, times(1)).update(any(Equipe.class));

	}
}