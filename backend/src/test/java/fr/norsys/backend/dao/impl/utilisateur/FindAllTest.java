package fr.norsys.backend.dao.impl.utilisateur;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Utilisateur;

public class FindAllTest extends AUtilisateurDaoImplTest {

	@Test
	public void should_find_all_utilisateurs() throws SQLException {

		List<Utilisateur> utilisateurs = this.utilisateurDao.findAll();

		assertNotNull(utilisateurs);
		assertTrue(utilisateurs.size() > 0);
	}

	@Test
	public void should_not_find_any_utilisateurs() throws SQLException {

		List<Utilisateur> utilisateurs = this.utilisateurDao.findAll();

		assertNotNull(utilisateurs);
		assertFalse(utilisateurs.size() == 0);
	}

}
