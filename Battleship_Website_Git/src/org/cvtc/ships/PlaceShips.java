/**
 * 
 */
package org.cvtc.ships;

/**
 * @author weslar
 *
 */
public class PlaceShips {
	
	private String[][] playerGrid = new String[10][10];
	
	public String[][] getPlayerGrid() {
		return playerGrid;
	}
	
	public PlaceShips(CarrierShip carrierShip, BattleShip battleShip, SubShip subShip, DestroyerShip destroyerShip, PBShip pbShip){
		
		for(int i=0;i<playerGrid.length;i++){
			for(int ii=0;ii<playerGrid[0].length;ii++){
				playerGrid[i][ii] = "";
			}
		}
		
		for(int i=0;i<carrierShip.getLength();i++){
			
			if(carrierShip.getDirection().equals("UP")){
				
				playerGrid[carrierShip.getStartX()][carrierShip.getStartY() - i] = "Air Craft Carrier";
				
			}else if(carrierShip.getDirection().equals("DOWN")){
				
				playerGrid[carrierShip.getStartX()][carrierShip.getStartY() + i] = "Air Craft Carrier";
				
			}else if(carrierShip.getDirection().equals("LEFT")){
				
				playerGrid[carrierShip.getStartX() - i][carrierShip.getStartY()] = "Air Craft Carrier";
				
			}else if(carrierShip.getDirection().equals("RIGHT")){
				
				playerGrid[carrierShip.getStartX() + i][carrierShip.getStartY()] = "Air Craft Carrier";
				
			}
			
		}
		
		for(int i=0;i<battleShip.getLength();i++){
			
			if(battleShip.getDirection().equals("UP")){
				
				playerGrid[battleShip.getStartX()][battleShip.getStartY() -i] = "Battleship";
				
			}else if(battleShip.getDirection().equals("DOWN")){
				
				playerGrid[battleShip.getStartX()][battleShip.getStartY() + i] = "Battleship";
				
			}else if(battleShip.getDirection().equals("LEFT")){
				
				playerGrid[battleShip.getStartX() - i][battleShip.getStartY()] = "Battleship";
				
			}else if(battleShip.getDirection().equals("RIGHT")){
				
				playerGrid[battleShip.getStartX() + i][battleShip.getStartY()] = "Battleship";
				
			}
			
		}
		
		for(int i=0;i<subShip.getLength();i++){
			
			if(subShip.getDirection().equals("UP")){
				
				playerGrid[subShip.getStartX()][subShip.getStartY() -i] = "Submarine";
				
			}else if(subShip.getDirection().equals("DOWN")){
				
				playerGrid[subShip.getStartX()][subShip.getStartY() + i] = "Submarine";
				
			}else if(subShip.getDirection().equals("LEFT")){
				
				playerGrid[subShip.getStartX() - i][subShip.getStartY()] = "Submarine";
				
			}else if(subShip.getDirection().equals("RIGHT")){
				
				playerGrid[subShip.getStartX() + i][subShip.getStartY()] = "Submarine";
				
			}
			
		}
		
		for(int i=0;i<destroyerShip.getLength();i++){
			
			if(destroyerShip.getDirection().equals("UP")){
				
				playerGrid[destroyerShip.getStartX()][destroyerShip.getStartY() -i] = "Destroyer";
				
			}else if(destroyerShip.getDirection().equals("DOWN")){
				
				playerGrid[destroyerShip.getStartX()][destroyerShip.getStartY() + i] = "Destroyer";
				
			}else if(destroyerShip.getDirection().equals("LEFT")){
				
				playerGrid[destroyerShip.getStartX() - i][destroyerShip.getStartY()] = "Destroyer";
				
			}else if(destroyerShip.getDirection().equals("RIGHT")){
				
				playerGrid[destroyerShip.getStartX() + i][destroyerShip.getStartY()] = "Destroyer";
				
			}
			
		}
		
		for(int i=0;i<pbShip.getLength();i++){
			
			if(pbShip.getDirection().equals("UP")){
				
				playerGrid[pbShip.getStartX()][pbShip.getStartY() -i] = "Patrol Boat";
				
			}else if(pbShip.getDirection().equals("DOWN")){
				
				playerGrid[pbShip.getStartX()][pbShip.getStartY() + i] = "Patrol Boat";
				
			}else if(pbShip.getDirection().equals("LEFT")){
				
				playerGrid[pbShip.getStartX() - i][pbShip.getStartY()] = "Patrol Boat";
				
			}else if(pbShip.getDirection().equals("RIGHT")){
				
				playerGrid[pbShip.getStartX() + i][pbShip.getStartY()] = "Patrol Boat";
				
			}
			
		}
		
	}

}
