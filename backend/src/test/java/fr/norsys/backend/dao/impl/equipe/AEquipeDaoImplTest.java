package fr.norsys.backend.dao.impl.equipe;

import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

import fr.norsys.backend.config.AppConfig;
import fr.norsys.backend.dao.impl.EquipeDaoImpl;

public abstract class AEquipeDaoImplTest {

	protected EquipeDaoImpl equipeDao;
	protected AppConfig appConfig;
	protected JdbcTemplate jdbcTemplate;

	@Before
	public void setUp() {
		this.appConfig = new AppConfig();
		this.equipeDao = new EquipeDaoImpl();
		this.equipeDao.setJdbcTemplate(new JdbcTemplate(this.appConfig.getDataSource()));
	}
}
