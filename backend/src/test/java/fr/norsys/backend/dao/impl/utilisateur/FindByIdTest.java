package fr.norsys.backend.dao.impl.utilisateur;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.Optional;

import org.junit.Test;

import fr.norsys.backend.entity.Utilisateur;

public class FindByIdTest extends AUtilisateurDaoImplTest {

	@Test
	public void should_find_by_id() throws SQLException {

		Optional<Utilisateur> utilisateur = this.utilisateurDao.findById(1L);

		assertNotNull(utilisateur);
		assertTrue(utilisateur.isPresent());
		assertEquals("testEmail@gmail.com", utilisateur.get().getEmail());
		assertEquals("azerty", utilisateur.get().getMotDePasse());
		assertEquals("test", utilisateur.get().getIdentifiant());
	}

}
