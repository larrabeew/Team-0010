package org.cvtc.servelets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cvtc.dao.BattleshipDoa;

/**
 * Servlet implementation class createDatabaseServelt
 */
@WebServlet("/createDatabase")
public class CreateDatabaseServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BattleshipDoa battleshipDoa = new BattleshipDoa();
		
		try {
			
			battleshipDoa.createTables();
			
			response.getWriter().append("Database created");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			response.getWriter().append("Database creation failed: ").append(e.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
