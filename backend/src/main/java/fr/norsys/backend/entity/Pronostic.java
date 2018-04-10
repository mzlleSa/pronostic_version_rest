package fr.norsys.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pronostic {

	private Long idUtilisateur;
	private Long idEquipe;
	private Long idMatch;
	private Integer prediction;

	public Pronostic(long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

}
