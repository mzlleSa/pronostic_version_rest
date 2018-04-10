package fr.norsys.frontend.constant;

public class Url {

	public static final String GET_COMPETITION = "http://localhost:8099/competitions/competition/{idCompetition}";
	public static final String GET_COMPETITIONS = "http://localhost:8099/competitions";
	public static final String GET_HOME = "http://localhost:8099/";
	public static final String GET_MATCHS = "http://localhost:8099/competitions/{idCompetition}/poule/{idPoule}/matchs";
	public static final String GET_PRONOSTICS = "http://localhost:8099/utilisateur/{idUser}/match/{id}";
	public static final String GET_EQUIPES = "http://localhost:8099/match/{id}/equipes";
	public static final String GET_EST_JOUER = "http://localhost:8099/match/{id}/estJouer";
	public static final String UPDATE_PRONOSTIC = "http://localhost:8099/update";
	public static final String ADD_PRONOSTIC = "http://localhost:8099/add";
	public static final String INSCRIPTION_PROCESS = "http://localhost:8099/inscriptionProcess";
	public static final String LOGIN_PROCESS = "http://localhost:8099/loginProcess";
	public static final String PROFILE = "http://localhost:8099/profile";

}
