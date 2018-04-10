package fr.norsys.backend.service.impl.resultat;

import static org.mockito.Mockito.mock;

import org.junit.Before;

import fr.norsys.backend.dao.IResultatDao;
import fr.norsys.backend.service.impl.ResultatServiceImpl;

public abstract class AResultatServiceImplTest {

	protected ResultatServiceImpl resultatService;
	protected IResultatDao resultatDao;

	@Before
	public void setUp() {
		this.resultatDao = mock(IResultatDao.class);
		this.resultatService = new ResultatServiceImpl();
		this.resultatService.setResultatDao(this.resultatDao);
	}

}
