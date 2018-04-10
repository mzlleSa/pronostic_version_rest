package fr.norsys.backend.entity;

import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Match {

	private Long id;
	private String identifiant;
	private String type;
	private Timestamp dateMatch;
	private boolean estJouer;
	private long idCompetition;
	private List<Equipe> equipes;
	private boolean estTraite;

	public Match(long id, String identifiant, Timestamp dateMatch) {
		this.id = id;
		this.identifiant = identifiant;
		this.dateMatch = dateMatch;
	}

	public Match(Long id, String identifiant, String type, Timestamp dateMatch, boolean estJouer, long idCompetition) {
		this.id = id;
		this.identifiant = identifiant;
		this.type = type;
		this.dateMatch = dateMatch;
		this.estJouer = estJouer;
		this.idCompetition = idCompetition;
	}

	public Match(Long id, String identifiant, String type, Timestamp dateMatch, boolean estJouer, long idCompetition,
			boolean estTraite) {
		this.id = id;
		this.identifiant = identifiant;
		this.type = type;
		this.dateMatch = dateMatch;
		this.estJouer = estJouer;
		this.idCompetition = idCompetition;
		this.estTraite = estTraite;
	}

	public Match(long id, String identifiant) {
		this.id = id;
		this.identifiant = identifiant;
	}

}
