package fr.norsys.backend.dao.impl.resultat;

import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

import fr.norsys.backend.config.AppConfig;
import fr.norsys.backend.dao.impl.ResultatDaoImpl;

public abstract class AResultatDaoImpltest {

	protected ResultatDaoImpl resultatDao;
	protected AppConfig appConfig;
	protected JdbcTemplate jdbcTemplate;

	@Before
	public void setUp() {
		this.appConfig = new AppConfig();
		this.resultatDao = new ResultatDaoImpl();
		this.resultatDao.setJdbcTemplate(new JdbcTemplate(this.appConfig.getDataSource()));
	}
}
