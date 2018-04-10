package fr.norsys.backend.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.backend.entity.Equipe;
import fr.norsys.backend.entity.Match;
import fr.norsys.backend.entity.Pronostic;
import fr.norsys.backend.exception.MatchNotFoundException;
import fr.norsys.backend.service.IEquipeService;
import fr.norsys.backend.service.IMatchService;
import fr.norsys.backend.service.IPronosticService;

@RestController
public class PronosticController {

	@Autowired
	private IEquipeService equipeService;

	@Autowired
	private IMatchService matchService;

	@Autowired
	private IPronosticService pronosticService;

	@GetMapping("/match/{id}/estJouer")
	public boolean getEstJouerProperty(@PathVariable String id) throws SQLException, MatchNotFoundException {
		Optional<Match> match = this.matchService.getById(Long.parseLong(id));
		if (!match.isPresent())
			throw new MatchNotFoundException("id - " + id);
		return match.get().isEstJouer();
	}

	@GetMapping("/match/{id}/equipes")
	public List<Equipe> getEquipes(@PathVariable String id) throws SQLException {
		return this.equipeService.getEquipesByMatch(Long.parseLong(id));
	}

	@GetMapping("/utilisateur/{idUser}/match/{id}")
	public List<Pronostic> getPronostics(@PathVariable String idUser, @PathVariable String id) throws SQLException {
		return this.pronosticService.findByIdUtilisateurIdMatch(Long.parseLong(idUser), Long.parseLong(id));
	}

	@PostMapping("/add")
	public void addPronostic(@RequestBody List<Pronostic> pronostics) {
		pronostics.stream().forEach(this::wrapperLambdaAddPronostic);
	}

	@PostMapping("/update")
	public void updatePronostic(@RequestBody List<Pronostic> pronostics) {
		pronostics.stream().forEach(this::wrapperLambdaUpdatePronostic);
	}

	private void wrapperLambdaUpdatePronostic(Pronostic pronostic) {
		try {
			this.pronosticService.update(pronostic);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void wrapperLambdaAddPronostic(Pronostic pronostic) {
		try {
			this.pronosticService.add(pronostic);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
