package es.iespuertodelacruz.javier.foro.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Vector;

import es.iespuertodelacruz.javier.foro.model.Mensaje;

public class ManejarFichero {
	
	private File fichero;

	public ManejarFichero() { }
	
	public ManejarFichero(String fichero) {
		this.fichero = new File(fichero);
	}
	
	public void agregarTexto(Vector<Mensaje> mensajes) throws IOException {
		try (BufferedWriter writer = Files.newBufferedWriter(fichero.toPath(), 
				StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE)){
			mensajes.forEach((mensaje) -> {
				try {
					writer.write(mensaje.toString() + "\n");
				} catch (IOException e) { }
			});
		}
		
	}
	
	public Vector<Mensaje> leerTodo() throws IOException {
		Vector<Mensaje> mensajes = new Vector<Mensaje>();
		try (BufferedReader reader = Files.newBufferedReader(fichero.toPath())) {
			String line;
			while ((line = reader.readLine()) != null) {
				String mensaje[] = line.split(":");
				mensajes.add(new Mensaje(mensaje[0], mensaje[1].trim()));
			}
		}
		return mensajes;
	}
	
}
