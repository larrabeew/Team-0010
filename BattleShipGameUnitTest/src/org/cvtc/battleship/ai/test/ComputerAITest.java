package org.cvtc.battleship.ai.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.cvtc.ai.ComputerAI;

import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class ComputerAITest {
	
	String[][] shotsArray1 = new String[10][10];{
	shotsArray1[0][0] = "";
	shotsArray1[0][1] = "";
	shotsArray1[0][2] = "";
	shotsArray1[0][3] = "";
	shotsArray1[0][4] = "";
	shotsArray1[0][5] = "";
	shotsArray1[0][6] = "";
	shotsArray1[0][7] = "";
	shotsArray1[0][8] = "";
	shotsArray1[0][9] = "";

	shotsArray1[1][0] = "";
	shotsArray1[1][1] = "";
	shotsArray1[1][2] = "";
	shotsArray1[1][3] = "";
	shotsArray1[1][4] = "";
	shotsArray1[1][5] = "M";
	shotsArray1[1][6] = "";
	shotsArray1[1][7] = "";
	shotsArray1[1][8] = "";
	shotsArray1[1][9] = "";
	
	shotsArray1[2][0] = "";
	shotsArray1[2][1] = "";
	shotsArray1[2][2] = "";
	shotsArray1[2][3] = "";
	shotsArray1[2][4] = "";
	shotsArray1[2][5] = "";
	shotsArray1[2][6] = "M";
	shotsArray1[2][7] = "";
	shotsArray1[2][8] = "";
	shotsArray1[2][9] = "";
	
	shotsArray1[3][0] = "";
	shotsArray1[3][1] = "";
	shotsArray1[3][2] = "";
	shotsArray1[3][3] = "M";
	shotsArray1[3][4] = "";
	shotsArray1[3][5] = "";
	shotsArray1[3][6] = "";
	shotsArray1[3][7] = "M";
	shotsArray1[3][8] = "";
	shotsArray1[3][9] = "";

	shotsArray1[4][0] = "";
	shotsArray1[4][1] = "";
	shotsArray1[4][2] = "";
	shotsArray1[4][3] = "";
	shotsArray1[4][4] = "M";
	shotsArray1[4][5] = "";
	shotsArray1[4][6] = "";
	shotsArray1[4][7] = "";
	shotsArray1[4][8] = "M";
	shotsArray1[4][9] = "";

	shotsArray1[5][0] = "";
	shotsArray1[5][1] = "";
	shotsArray1[5][2] = "";
	shotsArray1[5][3] = "";
	shotsArray1[5][4] = "";
	shotsArray1[5][5] = "M";
	shotsArray1[5][6] = "";
	shotsArray1[5][7] = "";
	shotsArray1[5][8] = "";
	shotsArray1[5][9] = "";
	
	shotsArray1[6][0] = "";
	shotsArray1[6][1] = "";
	shotsArray1[6][2] = "M";
	shotsArray1[6][3] = "";
	shotsArray1[6][4] = "";
	shotsArray1[6][5] = "";
	shotsArray1[6][6] = "M";
	shotsArray1[6][7] = "";
	shotsArray1[6][8] = "";
	shotsArray1[6][9] = "";

	shotsArray1[7][0] = "";
	shotsArray1[7][1] = "";
	shotsArray1[7][2] = "";
	shotsArray1[7][3] = "M";
	shotsArray1[7][4] = "";
	shotsArray1[7][5] = "";
	shotsArray1[7][6] = "";
	shotsArray1[7][7] = "";
	shotsArray1[7][8] = "";
	shotsArray1[7][9] = "";

	shotsArray1[8][0] = "";
	shotsArray1[8][1] = "";
	shotsArray1[8][2] = "";
	shotsArray1[8][3] = "";
	shotsArray1[8][4] = "";
	shotsArray1[8][5] = "";
	shotsArray1[8][6] = "";
	shotsArray1[8][7] = "";
	shotsArray1[8][8] = "";
	shotsArray1[8][9] = "";

	shotsArray1[9][0] = "";
	shotsArray1[9][1] = "";
	shotsArray1[9][2] = "";
	shotsArray1[9][3] = "";
	shotsArray1[9][4] = "";
	shotsArray1[9][5] = "";
	shotsArray1[9][6] = "";
	shotsArray1[9][7] = "";
	shotsArray1[9][8] = "";
	shotsArray1[9][9] = "";}
	
	ComputerAI aiPoints = new ComputerAI(shotsArray1);
	
	@Test
	public void testComputerAIX() {
		
		int expected = 4;
		
		//2.Act
		int actual = aiPoints.getPosition_x();
		
		//3.Assert
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testComputerAIY() {
		
		int expected = 4;
		
		//2.Act
		int actual = aiPoints.getPosition_y();
		
		//3.Assert
		assertEquals(expected, actual);
		
	}

}
