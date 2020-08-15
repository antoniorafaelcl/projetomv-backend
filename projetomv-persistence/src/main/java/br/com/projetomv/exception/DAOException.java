package br.com.projetomv.exception;

public class DAOException extends Exception {

	private static final long serialVersionUID = -1931185539010059626L;

	public DAOException() {
		super();
	}
	
	public DAOException(String mensagem) {
		super(mensagem);
	}
}
