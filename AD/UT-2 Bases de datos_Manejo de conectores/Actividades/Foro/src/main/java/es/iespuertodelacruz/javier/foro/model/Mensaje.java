package es.iespuertodelacruz.javier.foro.model;

public class Mensaje {
	
	private String emisor;
	private String contenido;
	
	public Mensaje() { }
	
	public Mensaje(String emisor, String contenido) {
		this.emisor = emisor;
		this.contenido = contenido;
	}
	
	public String getEmisor() {
		return emisor;
	}
	
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	
	public String getContenido() {
		return contenido;
	}
	
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	@Override
	public String toString() {
		return emisor + ": " + contenido;
	}
	
}
