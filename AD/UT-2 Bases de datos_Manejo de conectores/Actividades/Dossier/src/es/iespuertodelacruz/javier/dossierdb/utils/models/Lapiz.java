package es.iespuertodelacruz.javier.dossierdb.utils.models;

public class Lapiz {

	private int idLapiz;
	private String marca;
	private int numero;
	
	public Lapiz() { }
	
	public Lapiz(String marca, int numero) {
		this(0, marca, numero);
	}
	
	public Lapiz(int idLapiz, String marca, int numero) {
		this.idLapiz = idLapiz;
		this.marca = marca;
		this.numero = numero;
	}

	public int getIdLapiz() {
		return idLapiz;
	}

	public void setIdLapiz(int idLapiz) {
		this.idLapiz = idLapiz;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Lapiz [idLapiz=" + idLapiz + ", marca=" + marca + ", numero=" + numero + "]";
	}
	
}
