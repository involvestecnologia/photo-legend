package br.com.involves.photolegend.exception;

public class PhotoLegendException extends Exception {

	public PhotoLegendException() {
	}
	
	public PhotoLegendException(String msg) {
		super(msg);
	}

	public PhotoLegendException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	private static final long serialVersionUID = 5951104185441777388L;

}
