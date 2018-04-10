package fr.norsys.backend.service.impl.competition;

import static org.mockito.Mockito.mock;

import org.junit.Before;

import fr.norsys.backend.dao.ICompetitionDao;
import fr.norsys.backend.service.impl.CompetitionServiceImpl;

public abstract class ACompetitionServiceImplTest {

	protected CompetitionServiceImpl competitionService;
	protected ICompetitionDao competitionDao;

	@Before
	public void setUp() {
		this.competitionDao = mock(ICompetitionDao.class);
		this.competitionService = new CompetitionServiceImpl();
		this.competitionService.setDaoCompetition(this.competitionDao);
	}
}
