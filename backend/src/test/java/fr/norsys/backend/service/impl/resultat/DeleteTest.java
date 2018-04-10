package fr.norsys.backend.service.impl.resultat;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Test;

public class DeleteTest extends AResultatServiceImplTest {

	@Test
	public void should_delete_resultat() throws SQLException {

		this.resultatService.delete(any(Long.class), anyLong());

		verify(this.resultatDao, times(1)).delete(anyLong(), anyLong());

	}
}
