package fr.norsys.backend.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.backend.entity.Match;
import fr.norsys.backend.service.IMatchService;

@RestController
public class HomeController {

	@Autowired
	private IMatchService matchService;

	@GetMapping("/")
	private Match showAcceuil() throws SQLException {
		this.matchService.setTrueForPlayedMatch();
		return this.matchService.getNextMatchWithEquipes();
	}
}
