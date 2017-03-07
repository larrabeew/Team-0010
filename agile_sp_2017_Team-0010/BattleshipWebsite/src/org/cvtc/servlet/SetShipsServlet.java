package org.cvtc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cvtc.dao.BattleshipDoa;
import org.cvtc.ships.BattleShip;
import org.cvtc.ships.CarrierShip;
import org.cvtc.ships.DestroyerShip;
import org.cvtc.ships.PBShip;
import org.cvtc.ships.PlaceShips;
import org.cvtc.ships.SubShip;

/**
 * Servlet implementation class setShipsServlet
 */
@WebServlet("/setShips")
public class SetShipsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String erorSpot = "";
		
		try {
			
		//Grab the ships strings and split them on ~ from direction, start X, start Y
		String[] battleShipStart = request.getParameter("battleship").split("~");
		
		String[] carrierShipStart = request.getParameter("carriership").split("~");
		
		String[] destroyerShipStart = request.getParameter("destroyership").split("~");
		
		String[] subShipStart = request.getParameter("subship").split("~");
		
		String[] pbShipStart = request.getParameter("pbship").split("~");
		
		String player_id = request.getParameter("player");
		
		String game_id = request.getParameter("game");
		
		erorSpot = "Setup";
		
		//Create ships to be places into grid
		
		CarrierShip playerCarrierShip = new CarrierShip(carrierShipStart[0], Integer.parseInt(carrierShipStart[1]) - 1, Integer.parseInt(carrierShipStart[2]) - 1);
		
		BattleShip playerBattleShip = new BattleShip(battleShipStart[0], Integer.parseInt(battleShipStart[1]) - 1, Integer.parseInt(battleShipStart[2]) - 1);
	
		SubShip playerSubShip = new SubShip(subShipStart[0], Integer.parseInt(subShipStart[1]) - 1, Integer.parseInt(subShipStart[2]) - 1);
	
		DestroyerShip playerDestroyerShip = new DestroyerShip(destroyerShipStart[0], Integer.parseInt(destroyerShipStart[1]) - 1, Integer.parseInt(destroyerShipStart[2]) - 1);
	
		PBShip playerPbShip = new PBShip(pbShipStart[0], Integer.parseInt(pbShipStart[1]) - 1, Integer.parseInt(pbShipStart[2]) - 1);		
		
		//Place ships on grid
		PlaceShips playerShips = new PlaceShips(playerCarrierShip, playerBattleShip, playerSubShip, playerDestroyerShip, playerPbShip);
		
		erorSpot = "Ship Setup";
		
		String[][] playerGrid = playerShips.getPlayerGrid();
		
		erorSpot = "Grid Setup";
		//Initialize database connect
		BattleshipDoa battleshipDoa = new BattleshipDoa();
		erorSpot = "DB Setup";
			//save the grid to the database.
			battleshipDoa.saveGameGrid(game_id, player_id, playerGrid);
			
			response.getWriter().append("<div id='response'>Ships Set</div>");
			
		} catch (Exception e) {
			
			response.getWriter().append("<div id='response'>Ships Set Error " + e.getMessage() + " " + erorSpot + "</div>");
			
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
