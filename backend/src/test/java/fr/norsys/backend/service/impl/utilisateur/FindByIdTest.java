package fr.norsys.backend.service.impl.utilisateur;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Test;

public class FindByIdTest extends AUtilisateurServiceImplTest {

	@Test
	public void should_find_utilisateur_by_id() throws SQLException {

		this.utilisateurService.findById(anyLong());

		verify(this.utilisateurDao, times(1)).findById(anyLong());
	}
}
