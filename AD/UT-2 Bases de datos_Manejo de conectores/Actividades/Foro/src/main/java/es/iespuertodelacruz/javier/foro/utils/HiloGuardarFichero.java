package es.iespuertodelacruz.javier.foro.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.stream.Collectors;

import es.iespuertodelacruz.javier.foro.model.Mensaje;

public class HiloGuardarFichero implements Runnable {

	ManejarFichero mf;
	Vector<Mensaje> mensajes;
	Long ultimoHashCode;
	
	public HiloGuardarFichero(ManejarFichero mf, Vector<Mensaje> mensajes, Long ultimoHashCode) {
		this.mf = mf;
		this.mensajes = mensajes;
		this.ultimoHashCode = ultimoHashCode;
	}
	
	@Override
	public void run() {
		boolean finalizar = true;
		int minutos = 30;
		int tiempoEspera = minutos * 60000;
		while (finalizar) {
			
			if (mensajes != null && mf != null) {
				if (ultimoHashCode != mensajes.hashCode()) {
					synchronized (mf) {
						try {
							mf.agregarTexto(mensajes);
							ultimoHashCode = (long) mensajes.hashCode();
						} catch (IOException e) { }
					}
				}
			}
			
			try {
				Thread.sleep(tiempoEspera);
			} catch (Exception e) {
				finalizar = false;
			}
		}
	}
	
}
