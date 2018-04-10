package fr.norsys.backend.service.impl.match;

import static org.mockito.Mockito.mock;

import org.junit.Before;

import fr.norsys.backend.dao.IEquipeDao;
import fr.norsys.backend.dao.IMatchDao;
import fr.norsys.backend.service.impl.MatchServiceImpl;

public abstract class AMatchServiceImplTest {

	protected MatchServiceImpl matchService;
	protected IMatchDao matchDao;
	protected IEquipeDao equipeDao;

	@Before
	public void setUp() {
		this.matchDao = mock(IMatchDao.class);
		this.equipeDao = mock(IEquipeDao.class);
		this.matchService = new MatchServiceImpl();
		this.matchService.setMatchDao(matchDao);
		this.matchService.setEquipeDao(equipeDao);
	}
}
