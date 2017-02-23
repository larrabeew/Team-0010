package org.cvtc.battleship.ships.test;

import org.cvtc.ships.CarrierShip;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class ShipDirectionTest {

	@Test
	@Parameters({
		"UP, 5, 9",
		"DOWN, 2, 4",
		"LEFT, 0, 6",
		"RIGHT, 0, 6"
	})
	public void ShipTestHitShip(String direction, int positionX, int positionY) {
		//1.Arrange
		CarrierShip carrierShip = new CarrierShip(direction, positionX, positionY);
		
		String expected = direction;
		//2.Act
		String actual = carrierShip.getDirection();
				
		//3.Assert
		equals(expected.equals(actual));
	}

}
