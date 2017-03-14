/**
 * 
 */
package org.cvtc.ai;

/**
 * @author wlarrabee
 *
 */
public class ComputerAI {

	//define variables
	private int position_x;
	
	private int postion_y;
	
	public int getPosition_x() {
		return position_x;
	}

	private void setPosition_x(int position_x) {
		this.position_x = position_x;
	}

	public int getPosition_y() {
		return postion_y;
	}

	private void setPostion_y(int postion_y) {
		this.postion_y = postion_y;
	}

	public ComputerAI(String[][] shotsFiredGrid){
		//This constructor needs a multidimensional array as an input along with the 5 ships 
		
		//x,y variables for inside the function
		int x = 0;
		
		int y = 0;
		
		int[][] potentialShipsLargerThan3 = new int[shotsFiredGrid.length][shotsFiredGrid[0].length];

		//create a temporary multidimensional array to store potential location of a ship
		for(int row=0;row<shotsFiredGrid.length -1;row++){
			
			for(int col=0;col<shotsFiredGrid[0].length -1;col++){	
				
				potentialShipsLargerThan3[row][col] = 0;
				
			}
			
		}
		
		//loop through each row in each column to set the probability matrix.  Check for hits on the each ships if a 
		//hit location is detected.  If a hit is detected near the empty space then add 1000 to the probability if 
		//there is more than 1 empty space in a row around the hit.  only add 500 if there is just one empty space in 
		//that direction.
		
		
		for(int row=0;row<shotsFiredGrid.length;row++){
			
			for(int col=0;col<shotsFiredGrid[0].length;col++){	
				
				if(shotsFiredGrid[row][col] == "" || shotsFiredGrid[row][col] == "S"){
					
					if(row < shotsFiredGrid.length-1){
						
						if(shotsFiredGrid[row+1][col] == "" || shotsFiredGrid[row+1][col] == "S"){
							if(row<shotsFiredGrid.length-2){
								
								if(shotsFiredGrid[row+2][col] == "" || shotsFiredGrid[row+2][col] == "S"){
									
									if(row<shotsFiredGrid.length-3){
										
										if(shotsFiredGrid[row+3][col] == "" || shotsFiredGrid[row+3][col] == "S"){
											
											if(row<shotsFiredGrid.length-4){
												
												if(shotsFiredGrid[row+4][col] == "" || shotsFiredGrid[row+4][col] == "S"){
													
													potentialShipsLargerThan3[row][col] += 5;
										
													potentialShipsLargerThan3[row+1][col] += 4;
											
													potentialShipsLargerThan3[row+2][col] += 3;
											
													potentialShipsLargerThan3[row+3][col] += 2;
											
													potentialShipsLargerThan3[row+4][col] += 1;
											
												}else{
													
													potentialShipsLargerThan3[row][col] += 4;
										
													potentialShipsLargerThan3[row+1][col] += 3;
											
													potentialShipsLargerThan3[row+2][col] += 2;
											
													potentialShipsLargerThan3[row+3][col] += 1;
													
												}
											}else{
												
												potentialShipsLargerThan3[row][col] += 4;
										
												potentialShipsLargerThan3[row+1][col] += 3;
											
												potentialShipsLargerThan3[row+2][col] += 2;
											
												potentialShipsLargerThan3[row+3][col] += 1;
												
											}
										}else{
											
											potentialShipsLargerThan3[row][col] += 3;
										
											potentialShipsLargerThan3[row+1][col] += 2;
											
											potentialShipsLargerThan3[row+2][col] += 1;
											
										}
									}else{
										
										potentialShipsLargerThan3[row][col] += 1;
										
										potentialShipsLargerThan3[row+1][col] += 2;
										
									}
										
								}else{
								
									potentialShipsLargerThan3[row][col] += 1;
								
								}
								
							}else{
								
									potentialShipsLargerThan3[row][col] += 1;
								
							}
						}else if(shotsFiredGrid[row+1][col] == "H"){
							
							if(row<shotsFiredGrid.length-2){
									
								if(shotsFiredGrid[row+2][col] == "H"){
										
									potentialShipsLargerThan3[row][col] += 1000;
										
								}else{
										
									potentialShipsLargerThan3[row][col] += 500;
										
								}
									
							}else if(row>1){
									
								if(shotsFiredGrid[row-1][col] == "H"){
										
									potentialShipsLargerThan3[row][col] += 1000;
										
								}else{
										
									potentialShipsLargerThan3[row][col] += 500;
										
								}
									
							}else{
									
								potentialShipsLargerThan3[row][col] += 500;
									
							}
							
						}
						
					}
					
					if(row>0){
						if(shotsFiredGrid[row-1][col] == "" || shotsFiredGrid[row-1][col] == "S"){
							
							if(row>1){
								
								if(shotsFiredGrid[row-2][col] == "" || shotsFiredGrid[row-2][col] == "S"){
									
									if(row>2){
										
										if(shotsFiredGrid[row-3][col] == "" || shotsFiredGrid[row-3][col] == "S"){
											
											if(row>3){
												
												if(shotsFiredGrid[row-4][col] == "" || shotsFiredGrid[row-4][col] == "S"){
													
													potentialShipsLargerThan3[row][col] += 5;
										
													potentialShipsLargerThan3[row-1][col] += 4;
											
													potentialShipsLargerThan3[row-2][col] += 3;
											
													potentialShipsLargerThan3[row-3][col] += 2;
											
													potentialShipsLargerThan3[row-4][col] += 1;
											
												}else{
													
													potentialShipsLargerThan3[row][col] += 4;
										
													potentialShipsLargerThan3[row-1][col] += 3;
											
													potentialShipsLargerThan3[row-2][col] += 2;
											
													potentialShipsLargerThan3[row-3][col] += 1;
													
												}
											}else{
												
												potentialShipsLargerThan3[row][col] += 4;
										
												potentialShipsLargerThan3[row-1][col] += 3;
											
												potentialShipsLargerThan3[row-2][col] += 2;
											
												potentialShipsLargerThan3[row-3][col] += 1;
												
											}
										}else{
											
											potentialShipsLargerThan3[row][col] += 3;
										
											potentialShipsLargerThan3[row-1][col] += 2;
											
											potentialShipsLargerThan3[row-2][col] += 1;
											
										}
									}else{
										
										potentialShipsLargerThan3[row][col] += 1;
										
										potentialShipsLargerThan3[row-1][col] += 2;
										
									}
										
								}else{
								
									potentialShipsLargerThan3[row][col] += 1;
								
								}
								
							}else{
								
									potentialShipsLargerThan3[row][col] += 1;
								
							}
						
						}else if(shotsFiredGrid[row-1][col] == "H"){
							
							if(row>1){
									
								if(shotsFiredGrid[row-2][col] == "H"){
										
									potentialShipsLargerThan3[row][col] += 1000;
										
								}else{
										
									potentialShipsLargerThan3[row][col] += 500;
										
								}
									
							}else if(row<shotsFiredGrid.length+1){
									
								if(shotsFiredGrid[row+1][col] == "H"){
										
									potentialShipsLargerThan3[row][col] += 1000;
										
								}else{
										
									potentialShipsLargerThan3[row][col] += 500;
										
								}
									
							}else{
									
								potentialShipsLargerThan3[row][col] += 500;
									
							}
							
						}
						
					}
					
					if(col>0){
						if(shotsFiredGrid[row][col-1] == "" || shotsFiredGrid[row][col-1] == "S"){
							
							if(col>1){
								
								if(shotsFiredGrid[row][col-2] == "" || shotsFiredGrid[row][col-2] == "S"){
									
									if(col>2){
										
										if(shotsFiredGrid[row][col-3] == "" || shotsFiredGrid[row][col-3] == "S"){
											
											if(col>3){
												
												if(shotsFiredGrid[row][col-4] == "" || shotsFiredGrid[row][col-4] == "S"){
													
													potentialShipsLargerThan3[row][col] += 5;
										
													potentialShipsLargerThan3[row][col-1] += 4;
											
													potentialShipsLargerThan3[row][col-2] += 3;
											
													potentialShipsLargerThan3[row][col-3] += 2;
											
													potentialShipsLargerThan3[row][col-4] += 1;
											
												}else{
													
													potentialShipsLargerThan3[row][col] += 4;
										
													potentialShipsLargerThan3[row][col-1] += 3;
											
													potentialShipsLargerThan3[row][col-2] += 2;
											
													potentialShipsLargerThan3[row][col-3] += 1;
													
												}
											}else{
												
												potentialShipsLargerThan3[row][col] += 4;
										
												potentialShipsLargerThan3[row][col-1] += 3;
											
												potentialShipsLargerThan3[row][col-2] += 2;
											
												potentialShipsLargerThan3[row][col-3] += 1;
												
											}
										}else{
											
											potentialShipsLargerThan3[row][col] += 3;
										
											potentialShipsLargerThan3[row][col-1] += 2;
											
											potentialShipsLargerThan3[row][col -2] += 1;
											
										}
									}else{
										
										potentialShipsLargerThan3[row][col] += 1;
										
										potentialShipsLargerThan3[row][col-1] += 2;
										
									}
										
								}else{
								
									potentialShipsLargerThan3[row][col] += 1;
								
								}
								
							}else{
								
									potentialShipsLargerThan3[row][col] += 1;
								
							}
							
						}else if(shotsFiredGrid[row][col-1] == "H"){
							
							if(col>1){
									
								if(shotsFiredGrid[row][col-2] == "H"){
										
									potentialShipsLargerThan3[row][col] += 1000;
										
								}else{
										
									potentialShipsLargerThan3[row][col] += 500;
										
								}
									
							}else if(col<shotsFiredGrid[0].length-1){
									
								if(shotsFiredGrid[row][col+1] == "H"){
										
									potentialShipsLargerThan3[row][col] += 1000;
										
								}else{
										
									potentialShipsLargerThan3[row][col] += 500;
										
								}
									
							}else{
									
								potentialShipsLargerThan3[row][col] += 500;
									
							}
							
						}
						
					}
					
					if(col<shotsFiredGrid[0].length-1){
						
						if(shotsFiredGrid[row][col+1] == "" || shotsFiredGrid[row][col+1] == "S"){
							
							if(col<shotsFiredGrid.length-2){
								
								if(shotsFiredGrid[row][col+2] == "" || shotsFiredGrid[row][col+2] == "S"){
									
									if(col<shotsFiredGrid.length-3){
										
										if(shotsFiredGrid[row][col+3] == "" || shotsFiredGrid[row][col+3] == "S"){
											
											if(col<shotsFiredGrid.length-4){
												
												if(shotsFiredGrid[row][col+4] == "" || shotsFiredGrid[row][col+4] == "S"){
													
													potentialShipsLargerThan3[row][col] += 5;
										
													potentialShipsLargerThan3[row][col+1] += 4;
											
													potentialShipsLargerThan3[row][col+2] += 3;
											
													potentialShipsLargerThan3[row][col+3] += 2;
											
													potentialShipsLargerThan3[row][col+4] += 1;
											
												}else{
													
													potentialShipsLargerThan3[row][col] += 4;
										
													potentialShipsLargerThan3[row][col+1] += 3;
											
													potentialShipsLargerThan3[row][col+2] += 2;
											
													potentialShipsLargerThan3[row][col+3] += 1;
													
												}
											}else{
												
												potentialShipsLargerThan3[row][col] += 4;
										
												potentialShipsLargerThan3[row][col+1] += 3;
											
												potentialShipsLargerThan3[row][col+2] += 2;
											
												potentialShipsLargerThan3[row][col+3] += 1;
												
											}
										}else{
											
											potentialShipsLargerThan3[row][col] += 3;
										
											potentialShipsLargerThan3[row][col+1] += 2;
											
											potentialShipsLargerThan3[row][col+2] += 1;
											
										}
									}else{
										
										potentialShipsLargerThan3[row][col] += 1;
										
										potentialShipsLargerThan3[row][col+1] += 2;
										
									}
										
								}else{
								
									potentialShipsLargerThan3[row][col] += 1;
								
								}
								
							}else{
								
									potentialShipsLargerThan3[row][col] += 1;
								
							}
							
						}else if(shotsFiredGrid[row][col+1] == "H"){
							
							if(col<shotsFiredGrid[0].length-2){
									
								if(shotsFiredGrid[row][col+2] == "H"){
										
									potentialShipsLargerThan3[row][col] += 1000;
										
								}else{
										
									potentialShipsLargerThan3[row][col] += 500;
										
								}
									
							}else if(col>1){
									
								if(shotsFiredGrid[row][col-1] == "H"){
										
									potentialShipsLargerThan3[row][col] += 1000;
										
								}else{
										
									potentialShipsLargerThan3[row][col] += 500;
										
								}
									
							}else{
									
								potentialShipsLargerThan3[row][col] += 500;
									
							}
								
						}
						
					}
					
				}
				
				else{
					
					potentialShipsLargerThan3[row][col] = 0;
					
				}
				
			}
			
		}
		
		double largestPotentialPointpotential = -1.1;
		
		//loop through all the potential ship locations and determine which one has the highest number
		for(int row=0;row<shotsFiredGrid.length;row++){
			
			for(int col=0;col<shotsFiredGrid[0].length;col++){
				
				int potential = potentialShipsLargerThan3[row][col];
				
				if(potential > largestPotentialPointpotential){
					
					largestPotentialPointpotential = potential;
				}
				
			}
			
		}
		//redue the potential MA to place an S where the best place to shoot is. 
		for(int row=0;row<shotsFiredGrid.length;row++){
			
			for(int col=0;col<shotsFiredGrid[0].length;col++){
				
				int potential = potentialShipsLargerThan3[row][col];
				
				if(potential == largestPotentialPointpotential){
					shotsFiredGrid[row][col] = "S";
					
				}else{
					
					if(shotsFiredGrid[row][col] == "S" || shotsFiredGrid[row][col] == ""){
						
							shotsFiredGrid[row][col] = "";
							
					}
					
				}
				
			}
			
		}
		boolean test = true;
		//int countX = 0;
		//int countY = 0;
		while(test){
			
			//if there is more than one highest potential ship location randomly pick one.
			x = (int)Math.floor((Math.random()*shotsFiredGrid[0].length)+ 0);
			
			y = (int)Math.floor((Math.random()*shotsFiredGrid.length)+ 0);
			
			if(shotsFiredGrid[y][x] == "S"){
				
				test = false;
				
			}
			//For taking the randomness out for testing
			//if(shotsFiredGrid[countY][countX] == "S"){
			//	x = countX;
			//	y = countY;
			//	test = false;	
			//}
			//if(countX==9){
			//	countX = 0;
			//	countY ++;
			//}else{
			//	countX ++;
			//}
		}
		
       setPosition_x(x);
       
	   setPostion_y(y);
		
	}
	
}
