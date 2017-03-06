package org.cvtc.servelets;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

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
public class IntializationServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_id = request.getParameter("user_id");
		String opponent_id = request.getParameter("opponent_id");
		int game_size = Integer.parseInt(request.getParameter("size"));
		String game_id = "";
		
		String [][] blankGameBoard = new String[game_size][game_size];
		
		BattleshipDoa battleshipDoa = new BattleshipDoa();
		
		if(opponent_id == null){
			
			opponent_id = "Computer";
			
		}
			try {
				
				game_id = battleshipDoa.startGame(user_id, opponent_id, user_id, blankGameBoard);				
				
			} catch (Exception e) {
				
				game_id = "Game was not Setup: " + e.getMessage();
				
				e.printStackTrace();
				
			}
			
			URL url = new URL("/index.jsp");
	        Map<String,Object> params = new LinkedHashMap<>();
	        params.put("game_id", game_id);
	        params.put("user_id", user_id);
	        params.put("opponent_id", opponent_id);

	        StringBuilder postData = new StringBuilder();
	        for (Map.Entry<String,Object> param : params.entrySet()) {
	            if (postData.length() != 0) postData.append('&');
	            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
	            postData.append('=');
	            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
	        }
	        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	        conn.setDoOutput(true);
	        conn.getOutputStream().write(postDataBytes);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
