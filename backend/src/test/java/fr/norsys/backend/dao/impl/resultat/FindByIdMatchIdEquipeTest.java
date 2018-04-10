package fr.norsys.backend.dao.impl.resultat;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Optional;

import org.junit.Test;

import fr.norsys.backend.entity.Resultat;

public class FindByIdMatchIdEquipeTest extends AResultatDaoImpltest {

	@Test
	public void should_find_resultat_when_match_1_equipe_1() throws SQLException {

		Optional<Resultat> resultat = this.resultatDao.findByIdMatchIdEquipe(1L, 1L);

		assertTrue(resultat.isPresent());
		assertNotNull(resultat.get().getScore());

	}

	@Test
	public void should_not_find_resultat_when_match_24_equipe_15() throws SQLException {

		Optional<Resultat> resultat = this.resultatDao.findByIdMatchIdEquipe(24L, 15L);

		assertTrue(resultat.isPresent());
		assertNull(resultat.get().getScore());

	}

}
