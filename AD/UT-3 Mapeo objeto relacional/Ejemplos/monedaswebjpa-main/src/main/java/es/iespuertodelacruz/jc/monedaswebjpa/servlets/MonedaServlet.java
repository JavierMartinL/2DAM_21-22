package es.iespuertodelacruz.jc.monedaswebjpa.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.jc.monedaswebjpa.entities.Moneda;
import es.iespuertodelacruz.jc.monedaswebjpa.repositories.MonedaRepository;

/**
 * Servlet implementation class MonedaServlet
 */
@WebServlet({ "/users/Monedas", "/users/monedas" })
public class MonedaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonedaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManagerFactory emf =(EntityManagerFactory)request.getServletContext().getAttribute("emf");
		
		MonedaRepository monedaRepository = new MonedaRepository(emf);
		EntityManager em = emf.createEntityManager();
		
		Moneda moneda = new Moneda();
		moneda.setNombre("Lira32");
		moneda.setPais("Turquía");
		em.getTransaction().begin();
		em.persist(moneda); // moneda vigilada → está en contexto
		System.out.println(moneda.toString());
		em.getTransaction().commit(); //moneda guardada en DDBB
		System.out.println("1: en base de datos: ");
		mostrarMonedaEnDDBB(moneda.getIdmoneda(), emf);
		em.close(); //moneda separada→ detached Cambios no persisten en DDBB
		em = emf.createEntityManager(); // nueva conexión a la DDBB
		em.getTransaction().begin(); //transact abierta para grabar en DDBB
		moneda.setNombre("Lira34"); //la moneda detach... ¡¡ no se grabará !!
		em.getTransaction().commit(); // da igual el commit.. no hay efecto
		System.out.println("2: en base de datos: ");
		mostrarMonedaEnDDBB(moneda.getIdmoneda(), emf);
		Moneda monedaVigilada = em.merge(moneda); //monedaVigilada
		//debemos trabajar con monedaVigilada no con moneda para cambios
		//aunque en apariencia el system.out nos las muestra iguales
		System.out.println("monedavigilada: " + monedaVigilada.toString());
		System.out.println("moneda: " + moneda.toString());
		monedaVigilada.setNombre("lira35"); //entity managed
		moneda.setNombre("lira36"); //entity detached
		System.out.println("3: en base de datos antes de transact: ");
		mostrarMonedaEnDDBB(moneda.getIdmoneda(), emf);
		em.getTransaction().begin();
		em.getTransaction().commit(); //ahora sí cambia la DDBB
		System.out.println("4: en base de datos: después de transact");
		mostrarMonedaEnDDBB(moneda.getIdmoneda(), emf);
		em.close();
		System.out.println("Se intenta guardar una moneda");
		
		Integer idmoneda = null;
		
		try {
			idmoneda = Integer.parseInt(request.getParameter("idmoneda"));
		} catch (Exception e) {	}
		
		if (idmoneda != null) {
			//MonedaRepository monedaRepository = new MonedaRepository(emf);
			//Moneda moneda = monedaRepository.findById(idmoneda);
			//request.getSession().setAttribute("moneda", moneda);
			request.getRequestDispatcher("moneda.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("monedas.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static void mostrarMonedaEnDDBB(
			Integer idmoneda,
			EntityManagerFactory emf
			) {
			EntityManager em = emf.createEntityManager();
			Moneda moneda = em.find(Moneda.class, idmoneda);
			System.out.println(moneda.toString());
			em.close();
			}

}
