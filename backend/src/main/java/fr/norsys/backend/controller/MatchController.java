package fr.norsys.backend.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.backend.entity.Match;
import fr.norsys.backend.service.IMatchService;

@RestController
public class MatchController {

	@Autowired
	private IMatchService matchService;

	@GetMapping("/competitions/{idCompetition}/poule/{idPoule}/matchs")
	public List<Match> showMatchsForPoule(@PathVariable String idCompetition, @PathVariable String idPoule)
			throws SQLException {
		return this.matchService.getMatchsPouleWithEquipes(Long.parseLong(idCompetition), Integer.parseInt(idPoule));
	}

}
