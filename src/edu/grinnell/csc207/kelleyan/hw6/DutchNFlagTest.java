package edu.grinnell.csc207.kelleyan.hw6;

import static org.junit.Assert.*;

import org.junit.Test;

public class DutchNFlagTest {

	@Test
	public void testDutchFlag() throws Exception{
		String[] bestCase = {"red", "red", "red", "red", "white", "white", "blue", "blue", "blue", "blue", "blue"};
		String[] worstCase = {"blue", "blue", "blue", "blue", "blue", "red", "red", "red", "red", "white", "white"};
		String[] onlyBlue = {"blue"};
		String[] onlyWhite = {"white"};
		String[] onlyRed = {"red"};
		String[] noBlue = {"white", "red"};
		String[] noRed = {"blue", "white"};
		String[] noWhite = {"blue","red"};
		String[] nonColor = {"pinneapple"};
		assertArrayEquals("test best case", bestCase, DutchNFlag.dutchFlag(bestCase));
		assertArrayEquals("test worst case", bestCase, DutchNFlag.dutchFlag(worstCase));
		assertArrayEquals("won't break with one", onlyBlue, DutchNFlag.dutchFlag(onlyBlue));
		assertArrayEquals("won't break with one", onlyRed, DutchNFlag.dutchFlag(onlyRed));
		assertArrayEquals("won't break with one", onlyWhite, DutchNFlag.dutchFlag(onlyWhite));
		assertArrayEquals("no blues", new String[] {"red", "white"}, DutchNFlag.dutchFlag(noBlue));
		assertArrayEquals("no reds", new String[] {"white", "blue"}, DutchNFlag.dutchFlag(noRed));
		assertArrayEquals("no whites", new String[] {"red", "blue"}, DutchNFlag.dutchFlag(noWhite));
		
		try{
			DutchNFlag.dutchFlag(nonColor);
			fail("nonColor");
		}catch (Exception e){
		}
		
		try{
		String[] unsortedFlag = null;
		DutchNFlag.dutchFlag(unsortedFlag);
		unsortedFlag = new String[] {};
		DutchNFlag.dutchFlag(unsortedFlag);
		fail("empty list");
		}catch (Exception e){
		}
		
	}

}
