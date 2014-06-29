package edu.upeu.ventas.web.alumno;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.upeu.ventas.service.AlumnoService;
import edu.upeu.ventas.service.CursoService;
import edu.upeu.ventas.service.impl.AlumnoServiceImpl;
import edu.upeu.ventas.service.impl.CursoServiceImpl;
import edu.upeu.ventas.web.form.AlumnoForm;
import edu.upeu.ventas.web.form.CursoForm;

/**
 * Servlet implementation class AlumnoCursoEditar
 */
public class AlumnoCursoEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_MAIN = "/pages/alumno/formulario_cursos.jsp";
	private static final String VIEW_MAIN_ALUMNO = "/pages/alumno/alumno_curso.jsp";
	private AlumnoService alumnoService = new AlumnoServiceImpl();
	private CursoService cursoService = new CursoServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlumnoCursoEditar() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		List<CursoForm> cursos = cursoService.listarCursosAlumno(id);

		request.setAttribute("cursos", cursos);
		request.setAttribute("id_alumno", id);

		request.getRequestDispatcher(VIEW_MAIN).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String[] ids = request.getParameterValues("id_curso");
		String idAlumno = request.getParameter("id_alumno");
		for (String id : ids) {
			System.out.println(id);
		}
		AlumnoForm a = alumnoService.getAlumnoCursosPorId(idAlumno);

		request.setAttribute("alumno", a);
		request.getRequestDispatcher(VIEW_MAIN_ALUMNO).forward(request, response);
	}

}
