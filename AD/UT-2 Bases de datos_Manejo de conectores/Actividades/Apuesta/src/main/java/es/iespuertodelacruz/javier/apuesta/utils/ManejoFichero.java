package es.iespuertodelacruz.javier.apuesta.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class ManejoFichero {

	private File fichero;
	
	public ManejoFichero() { }
	
	public ManejoFichero(String fichero) {
		this.fichero = new File(fichero);
	}
	
	public void guardarTexto(String texto) throws IOException {
		try (BufferedWriter writer = Files.newBufferedWriter(fichero.toPath(), 
				StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
			writer.write(texto + "\n");
		}
	}
	
	public String leerTodo() throws IOException {
		String texto = "";
		if (fichero.exists()) {
			try (BufferedReader reader = Files.newBufferedReader(fichero.toPath())) {
				String line;
				while ((line = reader.readLine()) != null) {
					texto += line + "\n";
				}
			}
		} else {
			fichero.createNewFile();
		}
		return texto;
	}
	
}
