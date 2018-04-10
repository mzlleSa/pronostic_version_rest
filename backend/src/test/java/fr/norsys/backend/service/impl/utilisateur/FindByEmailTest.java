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

public class FindByEmailTest extends AUtilisateurServiceImplTest {

	@Test
	public void should_find_user_by_email() throws SQLException {

		when(this.utilisateurDao.findByEmail("sez@gmail.com")).thenReturn(Optional.of(this.user));
		Optional<Utilisateur> utilisateur = this.utilisateurService.findByEmail("sez@gmail.com");

		assertNotNull(utilisateur);
		assertEquals("sez@gmail.com", utilisateur.get().getEmail());
		verify(this.utilisateurDao, times(1)).findByEmail("sez@gmail.com");
	}
}
