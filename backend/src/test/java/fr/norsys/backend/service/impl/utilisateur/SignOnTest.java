package fr.norsys.backend.service.impl.utilisateur;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Optional;

import org.junit.Test;

import fr.norsys.backend.entity.Utilisateur;

public class SignOnTest extends AUtilisateurServiceImplTest {

	@Test
	public void should_sign_on_user() throws SQLException {

		when(this.utilisateurDao.findByIdentifiantMotDePasse("sez", "azerty")).thenReturn(Optional.of(this.user));
		Optional<Utilisateur> user = this.utilisateurService.signOn("sez", "azerty");

		assertEquals("sez", user.get().getIdentifiant());
		assertEquals("azerty", user.get().getMotDePasse());
		verify(this.utilisateurDao, times(1)).findByIdentifiantMotDePasse("sez", "azerty");
	}

	@Test
	public void should_not_sign_on_user_when_identifiant_invalid() throws SQLException {

		when(this.utilisateurDao.findByIdentifiantMotDePasse("sez", "azerty")).thenReturn(null);
		Optional<Utilisateur> user = this.utilisateurService.signOn("sez", "azerty");

		assertNull(user);
		verify(this.utilisateurDao, times(1)).findByIdentifiantMotDePasse("sez", "azerty");
	}

	@Test
	public void should_not_sign_on_user_when_mdp_invalid() throws SQLException {

		when(this.utilisateurDao.findByIdentifiantMotDePasse("sez", "azerty")).thenReturn(null);
		Optional<Utilisateur> user = this.utilisateurService.signOn("sez", "azerty");

		assertNull(user);
		verify(this.utilisateurDao, times(1)).findByIdentifiantMotDePasse("sez", "azerty");
	}

	@Test
	public void should_not_sign_on_user_when_identifiant_mdp_invalid() throws SQLException {

		when(this.utilisateurDao.findByIdentifiantMotDePasse("sez", "azerty")).thenReturn(null);
		Optional<Utilisateur> user = this.utilisateurService.signOn("sez", "azerty");

		assertNull(user);
		verify(this.utilisateurDao, times(1)).findByIdentifiantMotDePasse("sez", "azerty");
	}
}
