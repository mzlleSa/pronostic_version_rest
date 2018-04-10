package fr.norsys.backend.dao.impl.match;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.util.Optional;

import org.junit.Test;

import fr.norsys.backend.entity.Match;

public class GetByIdTest extends AMatchDaoImplTest {

	@Test
	public void should_get_match_when_id_1() throws SQLException {

		Optional<Match> match = this.matchDao.getById(1L);

		assertNotNull(match);
		assertEquals("match 1", match.get().getIdentifiant());
	}
}
