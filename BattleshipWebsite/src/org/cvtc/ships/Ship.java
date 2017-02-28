/**
 * 
 */
package org.cvtc.ships;

/**
 * @author wlarrabee
 *
 */
public abstract class Ship {
	
	int length = 0;
	
	String direction = "";
	
	int startX = 0;
	
	int startY = 0;
	
	int hits = 0;
		
	boolean isDestroyed = false;
	
	public boolean getIsDestroyed(){
		return isDestroyed;
	}
	
	protected void setIsDestroyed(boolean isDestroyed){
		this.isDestroyed = isDestroyed;
	}
	
	public int getHits() {
		return hits;
	}

	private void setHits(int hits) {
		this.hits = hits;
	}
	
	//create a generic function for ship
	public Ship(int length, String direction, int startX, int startY) throws IllegalArgumentException {
		
		direction = direction.toUpperCase();
		
		if(direction.equals("UP") && direction.equals("DOWN") && direction.equals("RIGHT") && direction.equals("LEFT")){
			throw new IllegalArgumentException("Please enter the direction either UP, DOWN, LEFT, or RIGHT");
		}
		
		setLength(length);
		
		setDirection(direction);
		
		setStartX(startX);
		
		setStartY(startY);
		
	}

	public int getLength() {
		return length;
	}

	private void setLength(int length) {
		this.length = length;
	}

	public String getDirection() {
		return direction;
	}

	private void setDirection(String direction) {
		this.direction = direction;
	}

	public int getStartX() {
		return startX;
	}

	private void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	private void setStartY(int startY) {
		this.startY = startY;
	}
	
	//function for getting the hits left
	public int getHitsLeft(){
		return getLength() - getHits();
	}
			
	//function to add hits to a ship
	public void hitShip(){
		setHits(getHits() + 1);
		//If the number of hits is equal to the ships length sink the ship
		if(getHits() == getLength()){
			setIsDestroyed(true);
		}
	}
		
}
