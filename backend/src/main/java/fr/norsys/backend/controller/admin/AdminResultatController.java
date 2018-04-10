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

import fr.norsys.backend.entity.Resultat;
import fr.norsys.backend.service.IResultatService;

@RestController
@RequestMapping("/admin")
public class AdminResultatController {

	@Autowired
	private IResultatService resultatService;

	@GetMapping("/resultats")
	public List<Resultat> showAllResultats() throws SQLException {
		return this.resultatService.findAll();
	}

	@PostMapping("/resultats")
	public int addResultat(@RequestBody Resultat resultat) throws SQLException {
		return this.resultatService.add(resultat);
	}

	@PutMapping("/resultats")
	public int updateResultat(@RequestBody Resultat resultat) throws SQLException {
		return this.resultatService.update(resultat);
	}

	@DeleteMapping("/resultat/equipe/{idEquipe}/match/{idMatch}")
	public void deleteResultat(@PathVariable Long idEquipe, @PathVariable Long idMatch) throws SQLException {
		this.resultatService.delete(idEquipe, idMatch);
	}

}
