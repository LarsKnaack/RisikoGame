package de.htwg.risiko.view;

import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.controller.impl.GameEngine;
import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.impl.Country;
import junit.framework.TestCase;

public class GUITest extends TestCase {

	IGameEngine ge = new GameEngine();

	@SuppressWarnings("unused")
	public void testAttackDialog() {
		GUI gui = new GUI(ge);
		ge.startGame();
		CountryI c = new Country("test");
		CountryI c1 = new Country("testi");
		ge.getWorld().addCountry(c);
		ge.getWorld().addCountry(c1);
		ge.getWorld().addEdge(c, c1);
		ge.getCurrentPlayer().addCountry(c);
		c.setSoldiers(3);
		ge.getOpponent().addCountry(c1);

		new AttackDialog(c);
	}

	@SuppressWarnings("unused")
	public void testMoveDialog() {
		GUI gui = new GUI(ge);
		ge.startGame();
		CountryI c = new Country("test");
		CountryI c1 = new Country("testi");
		ge.getWorld().addCountry(c);
		ge.getWorld().addCountry(c1);
		ge.getWorld().addEdge(c, c1);
		ge.getCurrentPlayer().addCountry(c);
		c.setSoldiers(3);
		ge.getCurrentPlayer().addCountry(c1);

		new MoveDialog(c);
	}

	@SuppressWarnings("unused")
	public void testRecruitmentDialog() {
		GUI gui = new GUI(ge);
		ge.startGame();
		CountryI c = new Country("test");
		ge.getWorld().addCountry(c);
		ge.getCurrentPlayer().addCountry(c);

		new RecruitmentDialog(c);
	}
}
