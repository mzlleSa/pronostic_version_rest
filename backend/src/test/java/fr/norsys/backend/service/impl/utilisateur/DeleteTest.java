package fr.norsys.backend.service.impl.utilisateur;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Test;

public class DeleteTest extends AUtilisateurServiceImplTest {

	@Test
	public void should_delete_utilisateur() throws SQLException {

		this.utilisateurService.delete(anyLong());

		verify(this.utilisateurDao, times(1)).delete(anyLong());

	}
}
