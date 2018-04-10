package fr.norsys.backend.service.impl.utilisateur;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Test;

public class SetRankForUser extends AUtilisateurServiceImplTest {

	@Test
	public void should_set_rank_for_user() throws SQLException {

		this.utilisateurService.setRankForUser();

		verify(this.utilisateurDao, times(1)).findAll();
	}

}
