package fr.norsys.backend.service.impl.utilisateur;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Utilisateur;

public class FindAllTest extends AUtilisateurServiceImplTest {

	@Test
	public void should_find_all_utilisateurs() throws SQLException {

		when(this.utilisateurDao.findAll()).thenReturn(new ArrayList<Utilisateur>());
		List<Utilisateur> utilisateurs = this.utilisateurService.findAll();

		assertNotNull(utilisateurs);
		verify(this.utilisateurDao, times(1)).findAll();
	}
}
