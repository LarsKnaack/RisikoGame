package de.htwg.risiko.risiko;

import de.htwg.risiko.Risiko;
import junit.framework.TestCase;


public class RisikoTest extends TestCase {
/*
	public void testMain() {
		Risiko.main(null);
	}*/

	public void testGetController() {
		Risiko.getInstance().getController();
	}

	public void testGetTUI() {
		Risiko.getInstance().getTUI();
	}
}

