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
		String player_id_string = request.getParameter("player");
		
		String opponent_id_string = request.getParameter("opponent_id");
		
		int game_id = Integer.parseInt(request.getParameter("game"));
		
		String coord = request.getParameter("coord");
		
		int opponent_id = 0;
		
		int player_id = 0;
		
		if(!player_id_string.equals("Computer")){
			player_id = Integer.parseInt(player_id_string);
		}
		
		if(!opponent_id_string.equals("Computer")){
			opponent_id = Integer.parseInt(opponent_id_string);
		}
		
		int col_nbr = 0;
		
		char tblCoord = coord.charAt(0);
		
		for(char tblLetter = 'A'; tblLetter <= 'J'; tblLetter++) {
			if((int)tblLetter  == (int)tblCoord){
				break;
			}
			col_nbr += 1;
		}
		
		char row_nbr_char = coord.charAt(1);
		
		String row_nbr_string = Character.toString(row_nbr_char);
		
		int row_nbr = Integer.parseInt(row_nbr_string) - 1;
		
		//set up the database calls
		BattleshipDoa battleshipDoa = new BattleshipDoa();
		
		if(player_id == 0){
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
			String value = battleshipDoa.getValue(game_id, opponent_id, col_nbr, row_nbr);
			
			response.getWriter().append("<div id='response'>" + value + "</div>");
		} catch (Exception e) {
			response.getWriter().append("<div id='response'>Shot value: Error" + e.getMessage() + "</div>");
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
