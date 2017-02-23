/**
 * 
 */
package org.cvtc.battleship.ships.test;

import static org.junit.Assert.*;

import org.cvtc.ships.PBShip;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)

/**
 * @author weslar
 *
 */
public class PBShipLengthTest {

	@Test
	@Parameters({
		"UP, 5, 9",
		"DOWN, 2, 4",
		"LEFT, 0, 6",	
	})
	public void BattleShipTestLength(String direction, int positionX, int positionY) {
		//1.Arrange
		final double DELTA = 1e-15;
				
		PBShip pbShip = new PBShip(direction, positionX, positionY);
			
		float expected = 2;
				
		//2.Act
		float actual = pbShip.getLength();
						
		//3.Assert
		assertEquals(expected, actual, DELTA);
	}

}
