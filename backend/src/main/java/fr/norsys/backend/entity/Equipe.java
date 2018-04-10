package fr.norsys.backend.entity;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Equipe {

	private Long id;
	private String identifiant;
	private int poule;
	private List<Match> matches;

	public Equipe(long id, String identifiant) {
		this.id = id;
		this.identifiant = identifiant;
	}

	public Equipe(long id, String identifiant, int poule) {
		this.id = id;
		this.identifiant = identifiant;
		this.poule = poule;
	}

	public Equipe(String identifiant) {
		this.identifiant = identifiant;
	}

}
