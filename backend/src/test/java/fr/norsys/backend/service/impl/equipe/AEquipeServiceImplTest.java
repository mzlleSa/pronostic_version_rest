package fr.norsys.backend.service.impl.equipe;

import static org.mockito.Mockito.mock;

import org.junit.Before;

import fr.norsys.backend.dao.IEquipeDao;
import fr.norsys.backend.service.impl.EquipeServiceImpl;

public abstract class AEquipeServiceImplTest {

	protected EquipeServiceImpl equipeService;
	protected IEquipeDao equipeDao;

	@Before
	public void setUp() {
		this.equipeDao = mock(IEquipeDao.class);
		this.equipeService = new EquipeServiceImpl();
		this.equipeService.setDaoEquipe(this.equipeDao);
	}
}
