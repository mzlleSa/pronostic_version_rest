package fr.norsys.backend.service.impl.utilisateur;

import static org.mockito.Mockito.mock;

import org.junit.Before;

import fr.norsys.backend.dao.IPronosticDao;
import fr.norsys.backend.dao.IResultatDao;
import fr.norsys.backend.dao.IUtilisateurDao;
import fr.norsys.backend.entity.Utilisateur;
import fr.norsys.backend.service.impl.UtilisateurServiceImpl;
import fr.norsys.backend.util.UtilisateurUtil;

public abstract class AUtilisateurServiceImplTest {

	protected UtilisateurServiceImpl utilisateurService;
	protected IUtilisateurDao utilisateurDao;
	protected IResultatDao resultatDao;
	protected IPronosticDao pronosticDao;
	protected Utilisateur user;
	protected UtilisateurUtil utilisateurUtil;

	@Before
	public void setUp() {
		this.utilisateurDao = mock(IUtilisateurDao.class);
		this.resultatDao = mock(IResultatDao.class);
		this.pronosticDao = mock(IPronosticDao.class);
		this.utilisateurUtil = mock(UtilisateurUtil.class);
		this.utilisateurService = new UtilisateurServiceImpl();
		this.utilisateurService.setUtilisateurDao(utilisateurDao);
		this.utilisateurService.setResultatDao(resultatDao);
		this.utilisateurService.setPronosticDao(pronosticDao);
		this.user = this.setUser();
	}

	private Utilisateur setUser() {
		Utilisateur utilisateur = new Utilisateur("sez", "sez@gmail.com", "azerty");
		return utilisateur;
	}
}
