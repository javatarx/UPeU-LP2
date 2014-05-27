package edu.upeu.ventas.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.upeu.ventas.service.PersonaService;
import edu.upeu.ventas.service.impl.PersonaServiceImpl;
import edu.upeu.ventas.util.DBConexion;
import edu.upeu.ventas.web.form.PersonaForm;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_HOME = "/pages/home.jsp";
	private static final String VIEW_ERROR_LOGIN = "/pages/error_login.jsp";
	PersonaService personaService = new PersonaServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			Connection c = DBConexion.getConexion();

			PreparedStatement ps = c
					.prepareStatement("select * from usuario where username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				List<PersonaForm> lista = personaService.getListaPersonas();
				for (PersonaForm personaForm : lista) {
					System.out.println(personaForm.getNombre());
				}
				request.setAttribute("lp", lista);
				request.getRequestDispatcher(VIEW_HOME).forward(request,
						response);
			} else {
				request.getRequestDispatcher(VIEW_ERROR_LOGIN).forward(request,
						response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
