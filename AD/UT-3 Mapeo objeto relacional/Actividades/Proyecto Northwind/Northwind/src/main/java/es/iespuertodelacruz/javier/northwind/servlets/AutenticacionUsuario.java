package es.iespuertodelacruz.javier.northwind.servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.javier.northwind.utils.Global;

/**
 * Servlet Filter implementation class AutenticacionUsuario
 */
@WebFilter("/employee/*")
public class AutenticacionUsuario implements Filter {

    /**
     * Default constructor. 
     */
    public AutenticacionUsuario() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		if (req.getSession().getAttribute(Global.SESSION_EMPLOYEE) != null) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		} else {
			res.sendRedirect(req.getServletContext().getContextPath() + "/login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
