/**
 * 
 */
package org.cvtc.ships;

import java.util.Random;

/**
 * @author weslar
 *
 */
public class RandomizeShips {
	
	private String[][] player_grid = null;
	
	
	public RandomizeShips(){
		
		CarrierShip playerCarrierShip = null;
		
		BattleShip playerBattleShip = null;

		SubShip playerSubShip = null;

		DestroyerShip playerDestroyerShip = null;

		PBShip playerPbShip = null;
		
		Random random = new Random();
		
		for(int i = 0; i<5;i++){
			
			int randomDirection = random.nextInt(1 + 1 - 0) + 0;
			
			int randomY = 0;
			
			int randomX = 0;
			
			if(i == 0){
				
				if(randomDirection == 0){
					
					randomY = random.nextInt(5);
					randomX = random.nextInt(10);
					playerCarrierShip = new CarrierShip("DOWN", randomX, randomY);
					
				}else{
					
					randomY = random.nextInt(10);
					randomX = random.nextInt(5);
					playerCarrierShip = new CarrierShip("RIGHT", randomX, randomY);
					
				}
				
				
			}else if(i==1){
				
				if(randomDirection == 0){
					
					randomY = random.nextInt(6);
					randomX = random.nextInt(10);
					playerBattleShip = new BattleShip("DOWN", randomX, randomY);
					
				}else{
					
					randomY = random.nextInt(10);
					randomX = random.nextInt(6);
					playerBattleShip = new BattleShip("RIGHT", randomX, randomY);
					
				}
				
			}else if(i==2){
				
				if(randomDirection == 0){
					
					randomY = random.nextInt(7);
					randomX = random.nextInt(10);
					playerSubShip = new SubShip("DOWN", randomX, randomY);
					
				}else{
					
					randomY = random.nextInt(10);
					randomX = random.nextInt(7);
					playerSubShip = new SubShip("RIGHT", randomX, randomY);
					
				}
				
			}else if(i==3){
				
				if(randomDirection == 0){
					
					randomY = random.nextInt(7);
					randomX = random.nextInt(10);
					playerDestroyerShip = new DestroyerShip("DOWN", randomX, randomY);
					
				}else{
					
					randomY = random.nextInt(10);
					randomX = random.nextInt(7);
					playerDestroyerShip = new DestroyerShip("RIGHT", randomX, randomY);
					
				}
				
			}else if(i==4){
				
				if(randomDirection == 0){
					
					randomY = random.nextInt(7);
					randomX = random.nextInt(10);
					playerPbShip = new PBShip("DOWN", randomX, randomY);
					
				}else{
					
					randomY = random.nextInt(10);
					randomX = random.nextInt(7);
					playerPbShip = new PBShip("RIGHT", randomX, randomY);
					
				}
				
			}
			
		}	
		
		
		//Place ships on grid
		PlaceShips playerShips = new PlaceShips(playerCarrierShip, playerBattleShip, playerSubShip, playerDestroyerShip, playerPbShip);
		
		
		setPlayer_grid(playerShips.getPlayerGrid());
		
	}


	public String[][] getPlayer_grid() {
		return player_grid;
	}


	private void setPlayer_grid(String[][] player_grid) {
		this.player_grid = player_grid;
	}	

}
