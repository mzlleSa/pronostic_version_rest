package fr.norsys.backend.service.impl.utilisateur;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Test;

public class SetScoreForUserTest extends AUtilisateurServiceImplTest {

	@Test
	public void should_set_score_for_user() throws SQLException {

		this.utilisateurService.setScoreForUser(anyLong(), anyLong());

		verify(this.pronosticDao, times(1)).findByIdUtilisateurIdMatch(anyLong(), anyLong());
	}

}
