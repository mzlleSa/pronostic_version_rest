package fr.norsys.backend.dao.impl.pronostic;

import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

import fr.norsys.backend.config.AppConfig;
import fr.norsys.backend.dao.impl.PronosticDaoImpl;

public abstract class APronosticDaoImplTest {

	protected PronosticDaoImpl pronosticDao;
	protected AppConfig appConfig;
	protected JdbcTemplate jdbcTemplate;

	@Before
	public void setUp() {
		this.appConfig = new AppConfig();
		this.pronosticDao = new PronosticDaoImpl();
		this.pronosticDao.setJdbcTemplate(new JdbcTemplate(this.appConfig.getDataSource()));
	}
}
