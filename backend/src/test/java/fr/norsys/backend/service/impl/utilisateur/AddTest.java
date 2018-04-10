package fr.norsys.backend.service.impl.utilisateur;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;
import org.junit.Test;

import fr.norsys.backend.entity.Utilisateur;

public class AddTest extends AUtilisateurServiceImplTest {

	@Test
	public void should_add_utilisateur() throws SQLException {

		this.utilisateurService.add(any(Utilisateur.class));

		verify(this.utilisateurDao, times(1)).add(any(Utilisateur.class));

	}
}
