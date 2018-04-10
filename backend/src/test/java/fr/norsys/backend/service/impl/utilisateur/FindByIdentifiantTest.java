package fr.norsys.backend.service.impl.utilisateur;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Optional;

import org.junit.Test;

import fr.norsys.backend.entity.Utilisateur;

public class FindByIdentifiantTest extends AUtilisateurServiceImplTest {

	@Test
	public void should_find_user_by_identifiant() throws SQLException {

		when(this.utilisateurDao.findByIdentifiant("sez")).thenReturn(Optional.of(this.user));
		Optional<Utilisateur> utilisateur = this.utilisateurService.findByIdentifiant("sez");

		assertNotNull(utilisateur);
		assertEquals("sez", utilisateur.get().getIdentifiant());
		verify(this.utilisateurDao, times(1)).findByIdentifiant("sez");
	}
}
