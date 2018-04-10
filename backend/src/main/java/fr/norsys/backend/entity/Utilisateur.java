package fr.norsys.backend.entity;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Utilisateur {

	private Long id;
	@NotNull
	@Size(min = 3, message = "le nom doit etre superieur à 3 caractères")
	private String nom;
	@NotNull
	@Size(min = 3, message = "le prenom doit etre superieur à 3 caractères")
	private String prenom;
	@NotNull
	@Pattern(regexp = "^[A-Za-z0-9._]*@[A-Za-z0-9.]*\\.[A-Za-z]{2,6}$", message = "email incorrect !")
	private String email;
	@NotNull
	@Size(min = 3, message = "l identifiant doit etre superieur à 3 caractères")
	private String identifiant;
	@NotNull
	@Size(min = 5, message = "le mot de passe doit etre superieur à 5 caractères !")

	private String motDePasse;
	private String role;
	private int score;
	private Integer classement;
	private List<Pronostic> pronostics;

	public Utilisateur(String identifiant, String email, String motDePasse, String role) {
		this.identifiant = identifiant;
		this.email = email;
		this.motDePasse = motDePasse;
		this.role = role;
	}

	public Utilisateur(Long id, String nom, String prenom, String email, String identifiant, int score,
			Integer classement, String motDePasse, String role) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.identifiant = identifiant;
		this.score = score;
		this.classement = classement;
		this.motDePasse = motDePasse;
		this.role = role;
	}

	public Utilisateur(String identifiant, String email, String motDePasse) {
		this.email = email;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
	}

}
