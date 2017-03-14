package org.cvtc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cvtc.dao.BattleshipDoa;

/**
 * Servlet implementation class intializationServelt
 */
@WebServlet("/intialization")
public class InitializationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String opponent_id_string = request.getParameter("opponent_id");
		int game_size = Integer.parseInt(request.getParameter("size"));
		String game_id = "";
		
		String [][] blankGameBoard = new String[game_size][game_size];
		
		BattleshipDoa battleshipDoa = new BattleshipDoa();
		
		int opponent_id = 0;
		
		if(!opponent_id_string.equals("Computer")){
			
			opponent_id = Integer.parseInt(opponent_id_string);
			
		}
			try {
				
				game_id = battleshipDoa.startGame(user_id, opponent_id, user_id, blankGameBoard);	
				
				response.getWriter().append("<div id='response'>" + game_id + "<div>");
				
			} catch (Exception e) {
				
				game_id = "Game was not Setup: " + e.getMessage();
				
				e.printStackTrace();
				
			}
			
			String response_string = "<div id='response'>" + game_id + "<div>";
			
			response.getWriter().append(response_string);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
