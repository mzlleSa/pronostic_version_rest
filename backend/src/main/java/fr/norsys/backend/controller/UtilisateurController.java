package fr.norsys.backend.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.backend.entity.Match;
import fr.norsys.backend.entity.Pronostic;
import fr.norsys.backend.entity.Utilisateur;
import fr.norsys.backend.service.IMatchService;
import fr.norsys.backend.service.IPronosticService;
import fr.norsys.backend.service.IUtilisateurService;

@RestController
public class UtilisateurController {

	@Autowired
	private IUtilisateurService utilisateurService;

	@Autowired
	private IMatchService matchService;

	@Autowired
	private IPronosticService pronosticService;

	@PostMapping(value = "/loginProcess")
	public Utilisateur processLoginForm(@RequestBody Utilisateur utilisateur) throws SQLException {
		Optional<Utilisateur> user = this.utilisateurService.signOn(utilisateur.getIdentifiant(),
				utilisateur.getMotDePasse());
		return user.isPresent() ? user.get() : null;
	}

	@PostMapping(value = "/inscriptionProcess")
	public void processInscription(@RequestBody Utilisateur utilisateur) throws SQLException {
		this.utilisateurService.add(utilisateur);
	}

	@PostMapping(value = "/profile")
	public Utilisateur showUserProfile(@RequestBody Utilisateur utilisateur) throws SQLException {
		List<Match> playedMatchs = matchService.getPlayedMatch();
		playedMatchs.forEach(this::processPlayedMatch);
		return utilisateurService.findById(utilisateur.getId()).get();
	}

	private void processPlayedMatch(Match match) {
		match.setEstTraite(true);
		try {
			matchService.update(match);
			List<Pronostic> pronostics = pronosticService.findByIdMatch(match.getId());
			pronostics.forEach(pronostic -> processUsers(match, pronostic));
			this.utilisateurService.setRankForUser();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void processUsers(Match match, Pronostic pronostic) {
		try {
			utilisateurService.setScoreForUser(pronostic.getIdUtilisateur(), match.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
