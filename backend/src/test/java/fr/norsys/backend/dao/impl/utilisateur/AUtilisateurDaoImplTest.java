package fr.norsys.backend.dao.impl.utilisateur;

import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

import fr.norsys.backend.config.AppConfig;
import fr.norsys.backend.dao.impl.UtilisateurDaoImpl;

public abstract class AUtilisateurDaoImplTest {

	protected UtilisateurDaoImpl utilisateurDao;
	protected AppConfig appConfig;
	protected JdbcTemplate jdbcTemplate;

	@Before
	public void setUp() {
		this.appConfig = new AppConfig();
		this.utilisateurDao = new UtilisateurDaoImpl();
		this.utilisateurDao.setJdbcTemplate(new JdbcTemplate(this.appConfig.getDataSource()));
	}
}
