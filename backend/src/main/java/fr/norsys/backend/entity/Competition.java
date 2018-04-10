package fr.norsys.backend.entity;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Competition {

	private Long id;
	private String identifiant;
	private Date dateCompetition;
	private List<Match> matches;

	public Competition(long id, String identifiant, Date dateCompetition) {
		this.id = id;
		this.identifiant = identifiant;
		this.dateCompetition = dateCompetition;
	}

	public Competition(String identifiant) {
		this.identifiant = identifiant;
	}

}
