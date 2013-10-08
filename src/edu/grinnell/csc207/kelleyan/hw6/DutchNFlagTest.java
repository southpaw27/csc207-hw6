package edu.grinnell.csc207.kelleyan.hw6;

import static org.junit.Assert.*;
import org.junit.Test;

public class DutchNFlagTest {

	@Test
	public void testDutchFlag() {
		String[] bestCase = {"red", "red", "red", "red", "white", "white", "blue", "blue", "blue", "blue", "blue"};
		String[] worstCase = {"blue", "blue", "blue", "blue", "blue", "red", "red", "red", "red", "white", "white"};
		assertArrayEquals("test best case", bestCase, DutchNFlag.dutchFlag(bestCase));
		assertArrayEquals("test worst case", bestCase, DutchNFlag.dutchFlag(worstCase));
		
		
	}

}
