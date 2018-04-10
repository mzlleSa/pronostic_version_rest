package fr.norsys.backend.controller.admin;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.backend.entity.Match;
import fr.norsys.backend.service.IMatchService;

@RestController
@RequestMapping("/admin")
public class AdminMatchController {

	@Autowired
	private IMatchService matchService;

	@GetMapping("/matchs")
	public List<Match> showAllMatchs() throws SQLException {
		return this.matchService.findAll();
	}

	@PostMapping("/matchs")
	public void addMatch(@RequestBody Match match) throws SQLException {
		this.matchService.add(match);
	}

	@PutMapping("/matchs")
	public void updateMatch(@RequestBody Match match) throws SQLException {
		this.matchService.update(match);
	}

	@DeleteMapping("/matchs/{id}")
	public void deleteMatch(@PathVariable("id") Long id) throws SQLException {
		this.matchService.delete(id);
	}

}
