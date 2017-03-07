/**
 * 
 */
package org.cvtc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.cvtc.dao.DBUtility;

/**
 * @author weslar
 *
 */
public class BattleshipDoa {
	
	static final String DROP_TABLES = "drop table if exists players;drop table if exists game_settings;drop table if exists game_grid;drop table if exists game_shot_grid;drop table if exists ships_hit;";
	
	static final String CREATE_TABLE_PLAYER = "create table players(id integer primary key autoincrement, firstName text, lastName text, avatar_name text, wins integer, lose integer);";
	static final String CREATE_TABLE_GAME_SETTINGS = "create table game_settings(id integer primary key autoincrement, first_player integer, second_player integer, turn integer, won text);";
	static final String CREATE_TABLE_GAME_GRID = "create table game_grid(id integer primary key autoincrement, game_id integer, player integer, col_nbr integer, row_nbr integer, value text);";
	static final String CREATE_TABLE_GAME_SHOT_GRID = "create table game_shot_grid(id integer primary key autoincrement, game_id integer, player integer, col_nbr integer, row_nbr integer, value text);";
	static final String CREATE_TABLE__SHIPS_HIT = "create table ships_hit(id integer primary key autoincrement, game_id integer, player integer, carrierHits integer, battleshipHits integer, destroyerHits integer, subHits integer, pbHits integer);";
	
	static final String SELECT_PLAYER = "select * from player where id =";
	static final String SELECT_GAME = "select * from game_settings where id =";
	static final String SELECT_PLAYER_BOARD = "select * from game_grid where game_id =";
	static final String SELECT_PLAYER_SHOT_BOARD = "select * from game_shot_grid where game_id =";
	static final String SELECT_SHIPS_HIT = "select * from ships_hit where game_id =";

	public void createTables() throws Exception
	{
		
		final Connection connection = DBUtility.createConnection();
		final Statement statement = connection.createStatement();
		
		try{
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			//if tables exists resets them other wise just creates new tables.
			statement.executeUpdate(DROP_TABLES);
			statement.executeUpdate(CREATE_TABLE_PLAYER);
			statement.executeUpdate(CREATE_TABLE_GAME_SETTINGS);
			statement.executeUpdate(CREATE_TABLE_GAME_GRID);
			statement.executeUpdate(CREATE_TABLE_GAME_SHOT_GRID);
			statement.executeUpdate(CREATE_TABLE__SHIPS_HIT);
			
		}finally{
			
			//close database connection
			DBUtility.closeConnections(connection, statement);
		}

	}

	public String retrievePlayer(String player_id) throws Exception
	{
		
		String player = "";
		final Connection connection = DBUtility.createConnection();
		final Statement statement = connection.createStatement();
		
		player_id = SELECT_PLAYER.concat("'").concat(player_id).concat("'");
		
		try{
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet = statement.executeQuery(player_id);
			
			final String firstName = resultSet.getString("firstName");
			final String avatar_name = resultSet.getString("avatar_name");
			
			//check to see if avatar name is set and if it is set it to player name otherwise use first name
			if(avatar_name == ""){
				
				player = firstName;
				
			}else{
				
				player = avatar_name;
				
			}
			
			//close result set
			resultSet.close();
			
		}finally{
			
			//close databse connection
			DBUtility.closeConnections(connection, statement);
			
		}
		
		//return player name
		return player;
		
	}
	
	public String savePlayer(String player_id, String firstName, String lastName, String avatarName, int wins, int lose) throws Exception
	{
		
		String player_save = "";
		final Connection connection = DBUtility.createConnection();
		PreparedStatement ps = null;
		
		try{
			
			if(player_id == ""){
				
				 ps = connection.prepareStatement("INSERT INTO player  (id, firstName, lastName, avatar_name , wins , lose) VALUES(null,?,?,?,?,?);");
				 
				// set the preparedstatement parameters
				    ps.setString(1,firstName);
				    ps.setString(2,lastName);
				    ps.setString(3,avatarName);
				    ps.setInt(4,wins);
				    ps.setInt(5,lose);
				    
			}else{
				
				 ps = connection.prepareStatement("UPDATE player set firstName = ?, lastName = ?, avatar_name = ?, wins = ?, lose = ? WHERE id = ?;");
				 
				// set the preparedstatement parameters
				    ps.setString(1,firstName);
				    ps.setString(2,lastName);
				    ps.setString(3,avatarName);
				    ps.setInt(4,wins);
				    ps.setInt(5,lose);
				    ps.setString(6,player_id);
				    
			}
			
			ps.setQueryTimeout(DBUtility.TIMEOUT);
			
			ps.executeUpdate();
			
			//close result set
			ps.close();
			
		}catch(Exception e){
			
			player_save = "Player Save error: " + e.getMessage();
			
		}finally{
			
			//close databse connection
			DBUtility.closeConnections(connection, ps);
		}
		
		//return player name
		return player_save;
		
	}
	
	
	public List<String> retrieveGame(String game_id) throws Exception
	{
		
		List<String> game = new ArrayList<String>();
		final Connection connection = DBUtility.createConnection();
		final Statement statement = connection.createStatement();
		
		game_id = SELECT_GAME.concat("'").concat(game_id).concat("'");
		
		try{
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet = statement.executeQuery(game_id);
			
			final String firstPlayerID = resultSet.getString("firstPlayer");
			final String secondPlayerID = resultSet.getString("secondPlayer");
			final String playerTurn = resultSet.getString("turn");
			final String playerWon = resultSet.getString("won");
			
			//add game info to list
			game.add(firstPlayerID);
			game.add(secondPlayerID);
			game.add(playerTurn);					
			game.add(playerWon);
			
			//close result sets
			resultSet.close();
			
		}finally{
			
			//close connection ot database
			DBUtility.closeConnections(connection, statement);
		}
		
		//return game info
		return game;
		
	}
	
	public String saveGame(String game_id, String turn, String won) throws Exception
	{
		
		String game_save = "";
		final Connection connection = DBUtility.createConnection();
		PreparedStatement ps = null;
		
		try{
			
			ps = connection.prepareStatement("UPDATE game_settings set turn = ?, won = ? WHERE id = ?;");
				 
			// set the preparedstatement parameters
			ps.setString(1,turn);
			ps.setString(2,won);
			ps.setString(9,game_id);
			
			ps.setQueryTimeout(DBUtility.TIMEOUT);
			
			ps.executeUpdate();

			game_save = game_id;
			
			//close result set
			ps.close();
			
		}catch(Exception e){
			
			game_save = "Game Save error: " + e.getMessage();
			
		}finally{
			
			//close databse connection
			DBUtility.closeConnections(connection, ps);
			
		}
		
		//return player name
		return game_save;
		
	}
	
	
	
	@SuppressWarnings("resource")
	public String startGame(String firstPlayer, String secondPlayer, String turn, String[][] blankGameBoard) throws Exception
	{
		
		String game_save = "";
		final Connection connection = DBUtility.createConnection();
		PreparedStatement ps = null;
		final Statement statement = connection.createStatement();
		
		try{
			 ps = connection.prepareStatement("INSERT INTO game_settings  (id , first_player, second_player, turn, won) VALUES(null,?,?,?,'');");
				 
			// set the preparedstatement parameters
			ps.setString(1,firstPlayer);
			ps.setString(2,secondPlayer);
			ps.setString(3,turn);
				    		
			ps.setQueryTimeout(DBUtility.TIMEOUT);
			
			ps.executeUpdate();
			
			//get the game id
			String sql_statement = "SELECT id FROM game_settings WHERE first_player = '" + firstPlayer + "' AND second_player = '" + secondPlayer + "' ORDER BY id DESC LIMIT 1;";
		    
		    final ResultSet resultSet = statement.executeQuery(sql_statement);
		    
		    int gameID = 0;
		    
		    if(!resultSet.next()){
		    	gameID = resultSet.getInt("id");
		    }
		    
		    resultSet.close();
		    statement.close();
		    
//			//loop through blankGameBoard to intailize database for first player
//			for(int i=0;i<blankGameBoard.length-1;i++){
//				
//				for(int ii=0;ii<blankGameBoard[0].length -1;ii++){
//					
//					ps = connection.prepareStatement("INSERT INTO game_grid  (id, game_id, player_id, col_nbr , row_nbr, value) VALUES(null,?,?,?,?,'');");
//					// set the preparedstatement parameters
//				 	ps.setInt(1,gameID);
//				    ps.setString(2,firstPlayer);
//				    ps.setInt(3,i);
//				    ps.setInt(4,ii);
//				    
//				    ps.executeUpdate();
//
//				    ps = connection.prepareStatement("INSERT INTO game_shot_grid  (id, game_id, player_id, col_nbr , row_nbr, value) VALUES(null,?,?,?,?,'');");
//					// set the preparedstatement parameters
//				 	ps.setInt(1,gameID);
//				    ps.setString(2,firstPlayer);
//				    ps.setInt(3,i);
//				    ps.setInt(4,ii);
//				    
//				    ps.executeUpdate();
//				    
//				}
//				
//			}
//			
//			//loop through blankGameBoard to intailize database for second player
//			for(int i=0;i<blankGameBoard.length-1;i++){
//				
//				for(int ii=0;ii<blankGameBoard[0].length -1;ii++){
//					
//					ps = connection.prepareStatement("INSERT INTO game_grid  (id, game_id, player_id, col_nbr , row_nbr, value) VALUES(null,?,?,?,?,'');");
//					// set the preparedstatement parameters
//				 	ps.setInt(1,gameID);
//				    ps.setString(2,secondPlayer);
//				    ps.setInt(3,i);
//				    ps.setInt(4,ii);
//				    
//				    ps.executeUpdate();
//				    
//				    ps = connection.prepareStatement("INSERT INTO game_shot_grid  (id, game_id, player_id, col_nbr , row_nbr, value) VALUES(null,?,?,?,?,'');");
//					// set the preparedstatement parameters
//				 	ps.setInt(1,gameID);
//				    ps.setString(2,secondPlayer);
//				    ps.setInt(3,i);
//				    ps.setInt(4,ii);
//				    
//				    ps.executeUpdate();
//				    
//				}
//				
//			}
//			
//			ps = connection.prepareStatement("INSERT INTO ships_hit (id, game_id, player_id, carrierHits,  battleshipHits, destroyerHits, subHits, pbHits) VALUES(null,?,?,'5','4','3','3','2');");
//			// set the preparedstatement parameters
//		 	ps.setInt(1,gameID);
//		    ps.setString(2,secondPlayer);
//		    
//		    ps.executeUpdate();
			
			game_save = Integer.toString(gameID);
			
			//close result set
			ps.close();
			
		}catch(Exception e){
			
			game_save = "Game Start error: " + e.getMessage();
			
		}finally{
			
			//close databse connection
			DBUtility.closeConnections(connection, ps);
			DBUtility.closeConnections(connection, statement);
			
		}
		
		//return player name
		return game_save;
		
	}
	
	public String[][] retrieveGameShotBoard(String game_id, String player_id) throws Exception
	{
		
		String[][] player_grid = null;
		final Connection connection = DBUtility.createConnection();
		final Statement statement = connection.createStatement();
		
		game_id = SELECT_PLAYER_SHOT_BOARD.concat("'").concat(game_id).concat("' AND player = '").concat(player_id).concat("' ORDER BY col_nbr DESC, row_nbr DESC");
		
		try{
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet = statement.executeQuery(game_id);
			
			//loop through the results set to get each set of data points in grid
			while (resultSet.next()) {
				
				final int col_nbr = resultSet.getInt("col_nbr");
				final int row_nbr = resultSet.getInt("row_nbr");
				final String value = resultSet.getString("value");
				
				if(player_grid == null){
					player_grid = new String[col_nbr][row_nbr];	
				}				
				
				player_grid[col_nbr][row_nbr] = value;
				
			}
			
			//close results set
			resultSet.close();
			
		}finally{
			
			//close connection
			DBUtility.closeConnections(connection, statement);
			
		}
		
		//return grid
		return player_grid;
		
	}
	
	public void updateGameShotBoardSunkShip(String game_id, String player_id, String shipSunk) throws Exception
	{
		
		final Connection connection = DBUtility.createConnection();
		final Statement statement = connection.createStatement();
		
		game_id = SELECT_PLAYER_BOARD.concat("'").concat(game_id).concat("' AND player = '").concat(player_id).concat("' ORDER BY col_nbr DESC, row_nbr DESC");
		
		try{
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet = statement.executeQuery(game_id);
			
			//loop through the results set to get each set of data points in grid
			while (resultSet.next()) {
				
				final int col_nbr = resultSet.getInt("col_nbr");
				final int row_nbr = resultSet.getInt("row_nbr");
				final String value = resultSet.getString("value");
				
				BattleshipDoa battleshipDoa = new BattleshipDoa();
				
				if(value == shipSunk){
					
					battleshipDoa.updateGameShotGrid(game_id, player_id, col_nbr, row_nbr, "K");
					
				}
				
			}
			//close results set
			resultSet.close();
			
		}finally{
			
			//close connection
			DBUtility.closeConnections(connection, statement);
			
		}
	}
	
	public List<Integer> retrieveShipsHit(String game_id, String player_id) throws Exception
	{
		
		List<Integer> shipsHit = new ArrayList<Integer>();
		final Connection connection = DBUtility.createConnection();
		final Statement statement = connection.createStatement();
		String sqlStatement = "";
		
		sqlStatement = SELECT_SHIPS_HIT.concat("'").concat(game_id).concat("' AND player = '").concat(player_id).concat("'");
		
		try{
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet = statement.executeQuery(sqlStatement);
			
			//loop through the results get the ships hit
			while (resultSet.next()) {
				
				final int carrierHits = resultSet.getInt("carrierHits");
				final int battleshipHits = resultSet.getInt("battleshipHits");
				final int destroyerHits = resultSet.getInt("destroyerHits");
				final int subHits = resultSet.getInt("subHits");
				final int pbHits = resultSet.getInt("pbHits");
				
				//add ship info to list
				shipsHit.add(carrierHits);
				shipsHit.add(battleshipHits);
				shipsHit.add(destroyerHits);
				shipsHit.add(subHits);
				shipsHit.add(pbHits);
				
			}
			
			//close results set
			resultSet.close();
			
		}finally{
			
			//close connection
			DBUtility.closeConnections(connection, statement);
			
		}
		
		//return grid
		return shipsHit;
		
	}
	
	public String updateShipsHit(String game_id, String player_id, int carrierHits, int battleshipHits, int destroyerHtis, int subHits, int pbHits) throws Exception
	{
		
		String shipsHit = "";
		final Connection connection = DBUtility.createConnection();
		PreparedStatement ps = null;
		
		try{			
					 
			ps = connection.prepareStatement("UPDATE ships_hit set carrierHits = ?, battleshipHits = ?, destroyerHits = ?, subHits = ?, pbHits= ? WHERE game_id = ? AND player_id = ?");
					 
			// set the preparedstatement parameters
			ps.setInt(1,carrierHits);
			ps.setInt(2,battleshipHits);
			ps.setInt(3, destroyerHtis);
			ps.setInt(4,subHits);
			ps.setInt(5,pbHits);
			ps.setString(6,game_id);
			ps.setString(7,player_id);
					
			ps.setQueryTimeout(DBUtility.TIMEOUT);
					
			ps.executeUpdate();
			
			//close result set
			ps.close();
			
		}catch(Exception e){
			
			shipsHit = "Game Save error: " + e.getMessage();
			
		}finally{
			
			//close databse connection
			DBUtility.closeConnections(connection, ps);
			
		}
		
		//return player name
		return shipsHit;
		
	}
	
	public String saveGameGrid(String game_id, String player_id, String[][] playerGrid) throws Exception
	{
		
		String game_save = "";
		final Connection connection = DBUtility.createConnection();
		PreparedStatement ps = null;
		
		try{			
			
			//loop through player grid that is displayed
			for(int i=0;i<playerGrid.length-1;i++){
				
				for(int ii=0;ii<playerGrid[0].length -1;ii++){
					
					 
					 ps = connection.prepareStatement("UPDATE game_shot_grid set value = ? WHERE game_id = ? AND player_id = ? AND col_nbr = ? AND row_nbr = ?");
					 
						// set the preparedstatement parameters
						    ps.setString(1,playerGrid[i][ii]);
						    ps.setString(2,game_id);
						    ps.setString(3,player_id);
						    ps.setInt(4,i);
						    ps.setInt(5,ii);
					
						    ps.setQueryTimeout(DBUtility.TIMEOUT);
					
					ps.executeUpdate();
					
				}
				
			}
			
			//close result set
			ps.close();
			
		}catch(Exception e){
			
			game_save = "Game Save error: " + e.getMessage();
			
		}finally{
			
			//close databse connection
			DBUtility.closeConnections(connection, ps);
			
		}
		
		//return player name
		return game_save;
		
	}
	
	public String updateGameShotGrid(String game_id, String player_id, int col_nbr, int row_nbr, String value) throws Exception
	{
		
		String game_save = "";
		final Connection connection = DBUtility.createConnection();
		PreparedStatement ps = null;
		
		try{
			
			ps = connection.prepareStatement("UPDATE game_shot_grid set value = ? WHERE game_id = ? AND player_id = ? AND col_nbr = ? AND row_nbr = ?");
					 	
			// set the preparedstatement parameters
						  
			ps.setString(1,value);
						   
			ps.setString(2,game_id);
						   
			ps.setString(3,player_id);
						    
			ps.setInt(4,col_nbr);
						    
			ps.setInt(5,row_nbr);
					
			ps.setQueryTimeout(DBUtility.TIMEOUT);
					
			ps.executeUpdate();
			
			//close result set
			ps.close();
			
		}catch(Exception e){
			
			game_save = "Game Save error: " + e.getMessage();
			
		}finally{
			
			//close databse connection
			DBUtility.closeConnections(connection, ps);
			
		}
		
		//return player name
		return game_save;
		
	}
	
	
	public String getValue(String game_id, String opponent_id, int col_nbr, int row_nbr) throws Exception
	{
		
		String value = "";
		final Connection connection = DBUtility.createConnection();
		PreparedStatement ps = null;
		
		try{			
			
			ps = connection.prepareStatement("SELECT value FROM game_grid WHERE game_id = ? AND player_id = ? AND col_nbr = ? AND row_nbr = ?");
					 
			// set the preparedstatement parameters
			 ps.setString(1,game_id);
			 ps.setString(2,opponent_id);
			 ps.setInt(3,col_nbr);
			 ps.setInt(4,row_nbr);
			 
			 ps.setQueryTimeout(DBUtility.TIMEOUT);
						    
			 final ResultSet resultSet = ps.executeQuery(); 
						    
			 value = resultSet.getString("value");
			 
			 BattleshipDoa battleshipDoa = new BattleshipDoa();
			 
			 List<String> game =  battleshipDoa.retrieveGame(game_id);
			 
			 String turn = game.get(2);
				
			if(turn == game.get(0)){
				
				turn = game.get(1);
				
			}else{
				
				turn = game.get(1);
				
			}
			
			String player_id = "";
			
			if(opponent_id == game.get(0)){
				
				player_id = game.get(1);
				
			}else{
				
				player_id = game.get(0);
				
			}
			
			List<Integer> shipsHit = battleshipDoa.retrieveShipsHit(game_id, player_id);
			 
			 int pbHits = shipsHit.get(4);
			 int carrierHits = shipsHit.get(0);
			 int battleshipHits = shipsHit.get(1);
			 int destroyerHits = shipsHit.get(2);
			 int subHits = shipsHit.get(3);
			 
			 boolean shipSunk = false;
			 
			//if the value is a ship make the hits on the ship that was hit increase
			if(value == "Patrol Boat"){
				
				pbHits -= 1;
				
				if(pbHits == 0){
					
					value = "Ship Sunk";
					
					shipSunk = true;
					
					battleshipDoa.updateGameShotBoardSunkShip(game_id, player_id, "Patrol Boat");
					
				}else{
					
					value = "H";	
					
				}
				
			}else if(value == "Destroyer"){
				
				destroyerHits -= 1;
				
				if(destroyerHits == 0){
					
					value = "Ship Sunk";
					
					shipSunk = true;
					
					battleshipDoa.updateGameShotBoardSunkShip(game_id, player_id, "Destroyer");
					
				}else{
					
					value = "H";	
				}
				
			}else if(value == "Submarine"){
				
				subHits -= 1;
				
				if(subHits == 0){
					
					value = "Ship Sunk";
					
					shipSunk = true;
					
					battleshipDoa.updateGameShotBoardSunkShip(game_id, player_id, "Submarine");
					
				}else{
					
					value = "H";	
					
				}
				
			}else if(value == "Battleship"){
				
				battleshipHits -= 1;

				if(battleshipHits == 0){
					
					value = "Ship Sunk";
					
					shipSunk = true;
					
					battleshipDoa.updateGameShotBoardSunkShip(game_id, player_id, "Battleship");
					
				}else{
					
					value = "H";	
					
				}
				
				
			}else if(value == "Air Craft Carrier"){
				
				carrierHits -= 1;
				
				if(carrierHits == 0){
					
					value = "Ship Sunk";
					
					shipSunk = true;
					
					battleshipDoa.updateGameShotBoardSunkShip(game_id, player_id, "Air Craft Carrier");
					
				}else{
					
					value = "H";	
					
				}
				
			}
			
			int totalHitsLeft = carrierHits +battleshipHits +destroyerHits + subHits + pbHits;
			
			String winner = "";
			
			if( totalHitsLeft == 0){
				winner = player_id;
			}
			
			if(!shipSunk){
				battleshipDoa.updateGameShotGrid(game_id, player_id, col_nbr, row_nbr, value);
			}
			
			battleshipDoa.updateShipsHit(game_id, player_id, carrierHits, battleshipHits, destroyerHits, subHits, pbHits);
			
			battleshipDoa.saveGame(game_id, turn, winner);
			
			if(winner != ""){
				
				if(winner == game.get(0)){
					
					value = "Player One Wins";
					
				}else if(winner == game.get(1)){
					
					value = "Player Two Wins";
					
				}
				
			}
			
			//close result set
			ps.close();
			
		}catch(Exception e){
			
			value = "Game error when getting value: " + e.getMessage();
			
		}finally{
			
			//close databse connection
			DBUtility.closeConnections(connection, ps);
			
		}
		
		//return player name
		return value;
		
	}

}
