package es.iespuertodelacruz.javier.apuesta.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import es.iespuertodelacruz.javier.apuesta.model.Secreto;
import es.iespuertodelacruz.javier.apuesta.utils.ManejoFichero;

/**
 * Application Lifecycle Listener implementation class InicializadorServlet
 *
 */
public class InicializadorServlet implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InicializadorServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        
    	// Crear un nuevo Secreto para poder jugar
    	Date horaCreacion = new Date();
    	Secreto nuevoSecreto = new Secreto((int)(Math.random() * 10000), horaCreacion.getTime());
    	
    	sce.getServletContext().setAttribute("secreto", nuevoSecreto);
    	sce.getServletContext().setAttribute("horaCreacion", horaCreacion);
    	
    	// Cargar los ganadores que estan guardados en el fichero
    	String pathToWeb = sce.getServletContext().getRealPath(File.separator);
    	String ruta = pathToWeb + File.separator + "WEB-INF" + File.separator + "ganadores.txt";
    	
    	ManejoFichero mf = new ManejoFichero(ruta);
    	sce.getServletContext().setAttribute("manejoFichero", mf);
    	
    	try {
			String texto = mf.leerTodo();
			ArrayList<Secreto> ganadores = new ArrayList<>();
			
			String[] lineasFichero = texto.split("\n");
			
			for (String linea : lineasFichero) {
				String[] datos = linea.split(";");
				if (datos.length == 3) {
					ganadores.add(new Secreto(datos[0], Integer.parseInt(datos[1]), Long.parseLong(datos[2])));
				}
			}
			
			// Recogo los 10 mejores tiempos
			ganadores = (ArrayList<Secreto>) ganadores.stream().sorted(Comparator.comparing(Secreto::getCantTiempoAcierto)).limit(10).collect(Collectors.toList());
			
			sce.getServletContext().setAttribute("ganadores", ganadores);
		} catch (IOException e) { }
    }
	
}
