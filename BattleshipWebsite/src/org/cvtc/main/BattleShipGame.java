package org.cvtc.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.cvtc.ai.ComputerAI;
import org.cvtc.ships.BattleShip;
import org.cvtc.ships.CarrierShip;
import org.cvtc.ships.DestroyerShip;
import org.cvtc.ships.PBShip;
import org.cvtc.ships.PlaceShips;
import org.cvtc.ships.SubShip;

/**
 * @author wlarrabee
 *
 */
public class BattleShipGame {

	public static void main(String[] args) {
		
		CarrierShip playerOneCarrierShip = new CarrierShip("UP",2,9);
		
		BattleShip playerOneBattleShip = new BattleShip("DOWN", 4,3);
		
		SubShip playerOneSubShip = new SubShip("LEFT", 8,9);
		
		DestroyerShip playerOneDestroyerShip = new DestroyerShip("RIGHT", 5,5);
		
		PBShip playerOnePbShip = new PBShip("UP", 1,3);
		
		CarrierShip playerTwoCarrierShip = new CarrierShip("DOWN",9,2);
		
		BattleShip playerTwoBattleShip = new BattleShip("DOWN", 3,4);
		
		SubShip playerTwoSubShip = new SubShip("RIGHT", 1,9);
		
		DestroyerShip playerTwoDestroyerShip = new DestroyerShip("RIGHT", 6,5);
		
		PBShip playerTwoPbShip = new PBShip("UP", 1,3);
		
		PlaceShips playerOneShips = new PlaceShips(playerOneCarrierShip, playerOneBattleShip, playerOneSubShip, playerOneDestroyerShip, playerOnePbShip);
		
		PlaceShips playerTwoShips = new PlaceShips(playerTwoCarrierShip, playerTwoBattleShip, playerTwoSubShip, playerTwoDestroyerShip, playerTwoPbShip);
		
		String[][] playerOneGrid = playerOneShips.getPlayerGrid();
		
		String[][] playerTwoGrid = playerTwoShips.getPlayerGrid();
		
		String[][] playerOneShotGrid = new String[10][10];
		
		String[][] playerTwoShotGrid = new String[10][10];
		
		for(int i=0;i<playerTwoShotGrid.length;i++){
			for(int ii=0;ii<playerTwoShotGrid[0].length;ii++){
				playerOneShotGrid[i][ii] = "";
				playerTwoShotGrid[i][ii] = "";
			}
		}
		
		int countRounds = 0;
		
		int totalHitsLeftPlayerOne = playerOneCarrierShip.getHitsLeft() + playerOneBattleShip.getHitsLeft() + playerOneSubShip.getHitsLeft() + playerOneDestroyerShip.getHitsLeft() + playerOnePbShip.getHitsLeft();
		
		int totalHitsLeftPlayerTwo = playerTwoCarrierShip.getHitsLeft() + playerTwoBattleShip.getHitsLeft() + playerTwoSubShip.getHitsLeft() + playerTwoDestroyerShip.getHitsLeft() + playerTwoPbShip.getHitsLeft();
		
		while(totalHitsLeftPlayerOne > 0 && totalHitsLeftPlayerTwo > 0){
			
			if(countRounds % 2 == 0){
				
				//ComputerAI playerOneAI = new ComputerAI(playerOneShotGrid);
				
				int positionX = -1;
				
				int positionY = -1;
				
				//positionX = playerOneAI.getPosition_x();
				
				//positionY = playerOneAI.getPosition_y();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        try {
					while(positionX>9||positionX<0){
						System.out.print("Enter the X coordniate to shoot at (between 0 and 9):\n");
						positionX = Integer.parseInt(br.readLine());
					}
					while(positionY>9||positionY<0){
						System.out.print("Enter the Y coordniate to shoot at (between 0 and 9):\n");
						positionY = Integer.parseInt(br.readLine());
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(playerTwoGrid[positionY][positionX].equals("Air Craft Carrier")){
					
					playerOneShotGrid[positionY][positionX] = "H";
					
					System.out.println("Player one hit player two's carrier at: " + positionX + "x and " + positionY + "y");
					
					playerOneCarrierShip.hitShip();
					
					if(playerOneCarrierShip.getIsDestroyed()){
						
						for(int i=0;i<playerTwoGrid.length;i++){
							
							for(int ii=0;ii<playerTwoGrid[0].length;ii++){
								
								if(playerTwoGrid[i][ii].equals("Air Craft Carrier")){
									
									playerOneShotGrid[i][ii]= "K";
									
								}
								
							}
							
						}
						
					}
					
				}else if(playerTwoGrid[positionY][positionX].equals("Battleship")){
					
					playerOneShotGrid[positionY][positionX] = "H";
					System.out.println("Player one hit player two's battleship at: " + positionX + "x and " + positionY + "y");
					
					playerOneBattleShip.hitShip();
					
					if(playerOneBattleShip.getIsDestroyed()){
						
						for(int i=0;i<playerTwoGrid.length;i++){
							
							for(int ii=0;ii<playerTwoGrid[0].length;ii++){
								
								if(playerTwoGrid[i][ii].equals("Battleship")){
									
									playerOneShotGrid[i][ii]= "K";
									
								}
								
							}
							
						}
						
					}
					
				}else if(playerTwoGrid[positionY][positionX].equals("Submarine")){
					
					playerOneShotGrid[positionY][positionX] = "H";
					System.out.println("Player one hit player two's Sub at: " + positionX + "x and " + positionY + "y");
					
					playerOneSubShip.hitShip();
					
					if(playerOneSubShip.getIsDestroyed()){
						
						for(int i=0;i<playerTwoGrid.length;i++){
							
							for(int ii=0;ii<playerTwoGrid[0].length;ii++){
								
								if(playerTwoGrid[i][ii].equals("Submarine")){
									
									playerOneShotGrid[i][ii]= "K";
									
								}
								
							}
							
						}
						
					}
					
				}else if(playerTwoGrid[positionY][positionX].equals("Destroyer")){
					
					playerOneShotGrid[positionY][positionX] = "H";
					System.out.println("Player one hit player two's Destroyer at: " + positionX + "x and " + positionY + "y");
					
					playerOneDestroyerShip.hitShip();
					
					if(playerOneDestroyerShip.getIsDestroyed()){
						
						for(int i=0;i<playerTwoGrid.length;i++){
							
							for(int ii=0;ii<playerTwoGrid[0].length;ii++){
								
								if(playerTwoGrid[i][ii].equals("Destroyer")){
									
									playerOneShotGrid[i][ii]= "K";
									
								}
								
							}
							
						}
						
					}
					
				}else if(playerTwoGrid[positionY][positionX].equals("Patrol Boat")){
					
					playerOneShotGrid[positionY][positionX] = "H";
					System.out.println("Player one hit player two's Patrol Boat at: " + positionX + "x and " + positionY + "y");
					
					playerOnePbShip.hitShip();
					
					if(playerOnePbShip.getIsDestroyed()){
						
						for(int i=0;i<playerTwoGrid.length;i++){
							
							for(int ii=0;ii<playerTwoGrid[0].length;ii++){
								
								if(playerTwoGrid[i][ii].equals("Patrol Boat")){
									
									playerOneShotGrid[i][ii]= "K";
									
								}
								
							}
							
						}
						
					}
					
				}else{
					
					playerOneShotGrid[positionY][positionX] = "M";
					
					System.out.println("Player one missed player two at: " + positionX + "x and " + positionY + "y");
					
				}
					
			}else{
				
				ComputerAI playerTwoAI = new ComputerAI(playerTwoShotGrid);
				
				int positionX = playerTwoAI.getPosition_x();
				
				int positionY = playerTwoAI.getPosition_y();

				if(playerOneGrid[positionY][positionX].equals("Air Craft Carrier")){
					
					playerTwoShotGrid[positionY][positionX] = "H";
					
					System.out.println("Player two hit player one's carrier at: " + positionX + "x and " + positionY + "y");
					
					playerOneCarrierShip.hitShip();
					
					if(playerOneCarrierShip.getIsDestroyed()){
						
						for(int i=0;i<playerOneGrid.length;i++){
							
							for(int ii=0;ii<playerOneGrid[0].length;ii++){
								
								if(playerOneGrid[i][ii].equals("Air Craft Carrier")){
									
									playerTwoShotGrid[i][ii]= "K";
									
								}
								
							}
							
						}
						
					}
					
				}else if(playerOneGrid[positionY][positionX].equals("Battleship")){
					
					playerTwoShotGrid[positionY][positionX] = "H";
					System.out.println("Player two hit player one's battleship at: " + positionX + "x and " + positionY + "y");
					
					playerOneBattleShip.hitShip();
					
					if(playerOneBattleShip.getIsDestroyed()){
						
						for(int i=0;i<playerOneGrid.length;i++){
							
							for(int ii=0;ii<playerOneGrid[0].length;ii++){
								
								if(playerOneGrid[i][ii].equals("Battleship")){
									
									playerTwoShotGrid[i][ii]= "K";
									
								}
								
							}
							
						}
						
					}
					
				}else if(playerOneGrid[positionY][positionX].equals("Submarine")){
					
					playerTwoShotGrid[positionY][positionX] = "H";
					System.out.println("Player two hit player one's Sub at: " + positionX + "x and " + positionY + "y");
					
					playerOneSubShip.hitShip();
					
					if(playerOneSubShip.getIsDestroyed()){
						
						for(int i=0;i<playerOneGrid.length;i++){
							
							for(int ii=0;ii<playerOneGrid[0].length;ii++){
								
								if(playerOneGrid[i][ii].equals("Submarine")){
									
									playerTwoShotGrid[i][ii]= "K";
									
								}
								
							}
							
						}
						
					}
					
				}else if(playerOneGrid[positionY][positionX].equals("Destroyer")){
					
					playerTwoShotGrid[positionY][positionX] = "H";
					System.out.println("Player two hit player one's Destroyer at: " + positionX + "x and " + positionY + "y");
					
					playerOneDestroyerShip.hitShip();
					
					if(playerOneDestroyerShip.getIsDestroyed()){
						
						for(int i=0;i<playerOneGrid.length;i++){
							
							for(int ii=0;ii<playerOneGrid[0].length;ii++){
								
								if(playerOneGrid[i][ii].equals("Destroyer")){
									
									playerTwoShotGrid[i][ii]= "K";
									
								}
								
							}
							
						}
						
					}
					
				}else if(playerOneGrid[positionY][positionX].equals("Patrol Boat")){
					
					playerTwoShotGrid[positionY][positionX] = "H";
					System.out.println("Player two hit player one's Partol Boat at: " + positionX + "x and " + positionY + "y");
					
					playerOnePbShip.hitShip();
					
					if(playerOnePbShip.getIsDestroyed()){
						
						for(int i=0;i<playerOneGrid.length;i++){
							
							for(int ii=0;ii<playerOneGrid[0].length;ii++){
								
								if(playerOneGrid[i][ii].equals("Patrol Boat")){
									
									playerTwoShotGrid[i][ii]= "K";
									
								}
								
							}
							
						}
						
					}
					
				}else{
					
					playerTwoShotGrid[positionY][positionX] = "M";
					System.out.println("Player two missed player one at: " + positionX + "x and " + positionY + "y");
					
				}
				
				
				
				
				
			}
			
			countRounds ++;

			totalHitsLeftPlayerOne = playerOneCarrierShip.getHitsLeft() + playerOneBattleShip.getHitsLeft() + playerOneSubShip.getHitsLeft() + playerOneDestroyerShip.getHitsLeft() + playerOnePbShip.getHitsLeft();
			
			totalHitsLeftPlayerTwo = playerTwoCarrierShip.getHitsLeft() + playerTwoBattleShip.getHitsLeft() + playerTwoSubShip.getHitsLeft() + playerTwoDestroyerShip.getHitsLeft() + playerTwoPbShip.getHitsLeft();
		}
		
		if(totalHitsLeftPlayerOne == 0){
			System.out.println("Player Two Wins!!!");
		}else{
			System.out.println("Player One Wins!!!");
		}
		
		
	}

}
