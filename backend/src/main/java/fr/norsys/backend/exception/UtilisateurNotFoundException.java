package fr.norsys.backend.exception;

public class UtilisateurNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UtilisateurNotFoundException(String exception) {
		super(exception);
	}
}
