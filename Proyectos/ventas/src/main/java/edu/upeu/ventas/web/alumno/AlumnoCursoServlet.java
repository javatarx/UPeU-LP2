package edu.upeu.ventas.web.alumno;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.upeu.ventas.service.AlumnoService;
import edu.upeu.ventas.service.impl.AlumnoServiceImpl;
import edu.upeu.ventas.web.form.AlumnoForm;

/**
 * Servlet implementation class AlumnoCursoServlet
 */
public class AlumnoCursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW_MAIN = "/pages/alumno/alumno_curso.jsp";
	
	private AlumnoService alumnoService = new AlumnoServiceImpl();
	
    public AlumnoCursoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		AlumnoForm a = alumnoService.getAlumnoCursosPorId(id);
		
		request.setAttribute("alumno", a);
		request.getRequestDispatcher(VIEW_MAIN).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
