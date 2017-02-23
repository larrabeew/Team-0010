package org.cvtc.battleship.ships.test;

import static org.junit.Assert.*;

import org.cvtc.ships.BattleShip;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class ShipHitShipTest {

	@Test
	@Parameters({
		"UP, 5, 9",
		"DOWN, 2, 4",
		"LEFT, 0, 6",
		"RIGHT, 0, 6"
	})
	public void ShipTestHitShip(String direction, int positionX, int positionY) {
		//1.Arrange
		final double DELTA = 1e-15;
		
		BattleShip battleShip = new BattleShip(direction, positionX, positionY);
		
		float expected = 1;
		battleShip.hitShip();
		//2.Act
		float actual = battleShip.getHits();
				
		//3.Assert
		assertEquals(expected, actual, DELTA);
	}

}
