package es.iespuertodelacruz.javier.tcjavier.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class ManejoFichero {

	public ManejoFichero() { }
	
	public boolean guardar(String fichero, String texto) throws IOException {
		try (BufferedWriter writer = Files.newBufferedWriter((new File(fichero)).toPath(), 
				StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE)){
			writer.write(texto);
		} catch (IOException ex) {
			System.out.println(ex);
			return false;
		}
		return true;
	}
	
	public String leer(String fichero) throws IOException {
		String texto = "";
		File file = new File(fichero);
		if (file.exists()) {
			try (BufferedReader reader = Files.newBufferedReader((new File(fichero)).toPath())) {
				String line;
				while ((line = reader.readLine()) != null) {
					texto += line;
				}
			}
		} else {
			file.createNewFile();
		}
		return texto;
	}
	
}
