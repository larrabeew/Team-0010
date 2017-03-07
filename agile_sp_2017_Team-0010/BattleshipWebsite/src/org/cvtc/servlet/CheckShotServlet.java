package org.cvtc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cvtc.ai.ComputerAI;
import org.cvtc.dao.BattleshipDoa;

/**
 * Servlet implementation class CheckShotServelt
 */
@WebServlet("/CheckShot")
public class CheckShotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the game_id, player_id, and coordinates shot at to check to see if the shot is a hit.
		String player_id = request.getParameter("player");
		
		String game_id = request.getParameter("game");
		
		String coord = request.getParameter("coord");
		
		int col_nbr = 0;
		
		char tblCoord = coord.charAt(0);
		
		for(char tblLetter = 'A'; tblLetter <= 'J'; tblLetter++) {
			if((int)tblLetter  == (int)tblCoord){
				break;
			}
			col_nbr += 1;
		}
		
		int row_nbr = coord.charAt(0);
		
		//set up the database calls
		BattleshipDoa battleshipDoa = new BattleshipDoa();
		
		if(player_id == "Computer"){
			try {
				
				String[][] playerGrid = battleshipDoa.retrieveGameShotBoard(game_id, player_id);
				
				ComputerAI computerAI = new ComputerAI(playerGrid);
				
				col_nbr = computerAI.getPosition_x();
				
				row_nbr = computerAI.getPosition_y();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		try {
			String value = battleshipDoa.getValue(game_id, player_id, col_nbr, row_nbr);
			
			response.getWriter().append("Shot value: " + value);
		} catch (Exception e) {
			response.getWriter().append("Shot value: Error" + e.getMessage());
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
