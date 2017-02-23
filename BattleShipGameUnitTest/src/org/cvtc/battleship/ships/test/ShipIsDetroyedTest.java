package org.cvtc.battleship.ships.test;

import static org.junit.Assert.*;

import org.cvtc.ships.BattleShip;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class ShipIsDetroyedTest {

	@Test
	@Parameters({
		"UP, 5, 9",
		"DOWN, 2, 4",
		"LEFT, 0, 6",
		"RIGHT, 0, 6"
	})
	public void ShipTestHitShip(String direction, int positionX, int positionY) {
		//1.Arrange
		
		BattleShip battleShip = new BattleShip(direction, positionX, positionY);
		
		boolean expected = false;
		battleShip.hitShip();
		//2.Act
		boolean actual = battleShip.getIsDestroyed();
				
		//3.Assert
		assertEquals(expected, actual);
	}
}
