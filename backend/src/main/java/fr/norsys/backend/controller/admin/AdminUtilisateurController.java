package fr.norsys.backend.controller.admin;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.backend.entity.Utilisateur;
import fr.norsys.backend.service.IUtilisateurService;

@RestController
@RequestMapping("/admin")
public class AdminUtilisateurController {

	@Autowired
	private IUtilisateurService utilisateurService;

	@GetMapping("/utlisateurs")
	public List<Utilisateur> showAllUtilisateurs() throws SQLException {
		return this.utilisateurService.findAll();
	}

	@DeleteMapping("/utlisateurs/{id}")
	public void deleteUtilisateur(@PathVariable Long id) throws SQLException {
		this.utilisateurService.delete(id);
	}

}
