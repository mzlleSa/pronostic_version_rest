package fr.norsys.backend.service.impl.pronostic;

import static org.mockito.Mockito.mock;

import org.junit.Before;

import fr.norsys.backend.dao.IPronosticDao;
import fr.norsys.backend.service.impl.PronosticServiceImpl;

public class APronosticServiceImplTest {

	protected PronosticServiceImpl pronosticService;
	protected IPronosticDao pronosticDao;

	@Before
	public void setUp() {
		this.pronosticDao = mock(IPronosticDao.class);
		this.pronosticService = new PronosticServiceImpl();
		this.pronosticService.setPronosticDao(pronosticDao);
	}
}
