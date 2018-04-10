package fr.norsys.backend.dao.impl.competition;

import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

import fr.norsys.backend.config.AppConfig;
import fr.norsys.backend.dao.impl.CompetitionDaoImpl;

public abstract class ACompetitionDaoImplTest {

	protected CompetitionDaoImpl competitionDao;
	protected AppConfig appConfig;
	protected JdbcTemplate jdbcTemplate;

	@Before
	public void setUp() {
		this.appConfig = new AppConfig();
		this.competitionDao = new CompetitionDaoImpl();
		this.competitionDao.setJdbcTemplate(new JdbcTemplate(this.appConfig.getDataSource()));
	}

}
