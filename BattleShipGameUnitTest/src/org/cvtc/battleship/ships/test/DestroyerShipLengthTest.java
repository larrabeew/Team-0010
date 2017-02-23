/**
 * 
 */
package org.cvtc.battleship.ships.test;

import static org.junit.Assert.*;

import org.cvtc.ships.DestroyerShip;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)

/**
 * @author weslar
 *
 */
public class DestroyerShipLengthTest {

	@Test
	@Parameters({
		"UP, 5, 9",
		"DOWN, 2, 4",
		"LEFT, 0, 6",	
	})
	public void BattleShipTestLength(String direction, int positionX, int positionY) {
		//1.Arrange
		final double DELTA = 1e-15;
				
		DestroyerShip destroyerShip = new DestroyerShip(direction, positionX, positionY);
				
		float expected = 3;
				
		//2.Act
		float actual = destroyerShip.getLength();
						
		//3.Assert
		assertEquals(expected, actual, DELTA);
	}

}
