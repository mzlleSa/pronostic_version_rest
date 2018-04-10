package fr.norsys.backend.dao.impl.match;

import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

import fr.norsys.backend.config.AppConfig;
import fr.norsys.backend.dao.impl.MatchDaoImpl;

public abstract class AMatchDaoImplTest {

	protected MatchDaoImpl matchDao;
	protected AppConfig appConfig;
	protected JdbcTemplate jdbcTemplate;

	@Before
	public void setUp() {
		this.appConfig = new AppConfig();
		this.matchDao = new MatchDaoImpl();
		this.matchDao.setJdbcTemplate(new JdbcTemplate(this.appConfig.getDataSource()));
	}
}
