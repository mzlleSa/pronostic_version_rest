package fr.norsys.backend.service.impl.match;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.norsys.backend.entity.Match;

public class FindAllTest extends AMatchServiceImplTest {

	@Test
	public void should_find_all_matchs() throws SQLException {

		when(this.matchDao.findAll()).thenReturn(new ArrayList<Match>());
		List<Match> matchs = this.matchService.findAll();

		assertNotNull(matchs);
		verify(this.matchDao, times(1)).findAll();
	}

}
