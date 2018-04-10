package fr.norsys.backend.service.impl.equipe;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Test;

public class DeleteTest extends AEquipeServiceImplTest {

	@Test
	public void should_delete_equipe() throws SQLException {

		this.equipeService.delete(any(Long.class));

		verify(this.equipeDao, times(1)).delete(any(Long.class));

	}
}
