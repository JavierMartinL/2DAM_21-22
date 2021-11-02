package es.iespuertodelacruz.javier.apuesta.model;

public class Secreto {

	private int numero;
	private long horaCreacion;
	private String nickGanador;
	private long cantTiempoAcierto;
	
	public Secreto() { }
	
	public Secreto(int numero, long horaCreacion) {
		this.numero = numero;
		this.horaCreacion = horaCreacion;
	}
	
	public Secreto(String nickGanador, int numero, long cantTiempoAcierto) {
		this.nickGanador = nickGanador;
		this.numero = numero;
		this.cantTiempoAcierto = cantTiempoAcierto;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public long getHoraCreacion() {
		return horaCreacion;
	}

	public void setHoraCreacion(long horaCreacion) {
		this.horaCreacion = horaCreacion;
	}

	public String getNickGanador() {
		return nickGanador;
	}

	public void setNickGanador(String nickGanador) {
		this.nickGanador = nickGanador;
	}

	public long getCantTiempoAcierto() {
		return cantTiempoAcierto;
	}

	public void setCantTiempoAcierto(long cantTiempoAcierto) {
		this.cantTiempoAcierto = cantTiempoAcierto;
	}

	@Override
	public String toString() {
		return nickGanador + ";" + numero + ";" + cantTiempoAcierto;
	}
	
}
