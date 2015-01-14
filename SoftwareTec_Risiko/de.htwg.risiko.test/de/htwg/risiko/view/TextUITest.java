package de.htwg.risiko.view;

import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.controller.impl.GameEngine;
import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.impl.Country;
import junit.framework.TestCase;

public class TextUITest extends TestCase {

	IGameEngine ge = new GameEngine();
	TextUI tui = new TextUI(ge);

	public void testUpdate() {
		tui.update();
	}

	public void testProcessInputLineRecruit() {
		ge.startGame();
		CountryI c = new Country("test");
		ge.getWorld().addCountry(c);
		ge.getCurrentPlayer().addCountry(c);
		tui.processInputLine("test, 1");
		tui.processInputLine("e");
		tui.processInputLine("tst, 1");
		tui.processInputLine("test, 1");
		ge.getCurrentPlayer().removeCountry(c);
		tui.processInputLine("test, 1");
		ge.getCurrentPlayer().addCountry(c);
		tui.processInputLine("test, 6");
	}

	public void testProcessInputLineMove() {
		ge.startGame();
		CountryI c = new Country("test");
		CountryI c1 = new Country("testi");
		ge.getWorld().addCountry(c);
		ge.getWorld().addCountry(c1);
		ge.getWorld().addEdge(c, c1);
		ge.getCurrentPlayer().addCountry(c);
		ge.getCurrentPlayer().addCountry(c1);

		tui.processInputLine("test");
		tui.processInputLine("tst");

		tui.processInputLine("test, test, 1");
		tui.processInputLine("test, testi, 1");
		tui.processInputLine("tst, testi, 1");

		tui.processInputLine("e");
		tui.processInputLine("test, testi, 1");
	}

	public void testProcessInputLineAttackerTarget() {
		ge.startGame();
		CountryI c = new Country("test");
		CountryI c1 = new Country("testi");
		ge.getWorld().addCountry(c);
		ge.getWorld().addCountry(c1);
		ge.getWorld().addEdge(c, c1);
		ge.getCurrentPlayer().addCountry(c);
		c.setSoldiers(3);
		ge.getOpponent().addCountry(c1);

		tui.processInputLine("test, tst");
		tui.processInputLine("test, testi");
		tui.processInputLine("tst, testi");
		tui.processInputLine("testi, testi");
		tui.processInputLine("test, test");

		tui.processInputLine("e");
		tui.processInputLine("test, testi");
	}
}
