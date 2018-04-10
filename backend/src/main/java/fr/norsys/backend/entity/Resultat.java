package fr.norsys.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Resultat {

	private Long idMatch;
	private Long idEquipe;
	private Integer score;

}
