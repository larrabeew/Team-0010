package org.cvtc.battleship.ships.test;

import static org.junit.Assert.*;

import org.cvtc.ships.PBShip;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class ShipIsDetroyedTest2 {

	@Test
	@Parameters({
		"UP, 5, 9",
		"DOWN, 2, 4",
		"LEFT, 0, 6",
		"RIGHT, 0, 6"
	})
	public void ShipTestHitShip(String direction, int positionX, int positionY) {
		//1.Arrange
		
		PBShip pbShip = new PBShip(direction, positionX, positionY);
		
		boolean expected = true;
		pbShip.hitShip();
		pbShip.hitShip();
		//2.Act
		boolean actual = pbShip.getIsDestroyed();
				
		//3.Assert
		assertEquals(expected, actual);
	}
}
