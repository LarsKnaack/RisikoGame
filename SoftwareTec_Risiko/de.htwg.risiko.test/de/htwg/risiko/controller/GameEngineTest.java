package de.htwg.risiko.controller;

import java.awt.Point;
import java.util.List;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import de.htwg.risiko.controller.logwrapper.GameEngine;
import de.htwg.risiko.model.ICountry;
import de.htwg.risiko.model.IPlayer;
import de.htwg.risiko.model.IWorld;
import de.htwg.risiko.model.impl.Country;
import de.htwg.risiko.model.impl.Player;
import de.htwg.risiko.util.observer.IObserver;
import junit.framework.TestCase;

public class GameEngineTest extends TestCase {
	
	static
	{
	    Logger rootLogger = Logger.getRootLogger();
	    rootLogger.setLevel(Level.DEBUG);
	    rootLogger.addAppender(new ConsoleAppender(
	               new PatternLayout("%-6r [%p] %c - %m%n")));
	}

	IGameEngine ge = new GameEngine();

	public void testCreateMap() {
		assertTrue(ge.getWorld() != null);
	}

	public void testStartGame() {
		ge.startGame();
		assertEquals("Game initialised", ge.getStatus());
	}

	public void testChangePlayer() {
		ge.startGame();
		ge.changePlayer();
		assertEquals("It's your turn " + ge.getCurrentPlayer().getName(), ge.getStatus());
		ge.getOpponent();
	}

	public void testInvade() {
		ge.startGame();
		ICountry c = new Country("test");
		ICountry c1 = new Country("test");
		c.setSoldiers(3);
		c1.setSoldiers(3);
		ge.getWorld().addCountry(c);
		ge.getWorld().addCountry(c1);
		ge.getWorld().addEdge(c, c1);
		ge.getCurrentPlayer().addCountry(c);
		ge.getOpponent().addCountry(c1);
		assertTrue(ge.selectAttacker(c));
		assertTrue(ge.selectTarget(c1));
		ge.invade();
		assertTrue(ge.getStatus() != null);
		assertTrue(!ge.selectTarget(c));
		assertTrue(!ge.selectAttacker(c1));
		ge.getCurrentPlayer().addCountry(c1);
		assertTrue(ge.getNeighbours(c1).contains(c));
		c.setSoldiers(3);
		ge.moveSoldiers(1, c, c1);
	}

	public void testRecruit() {
		ge.startGame();
		ge.endTurn();
		assertEquals("now select recruitment", ge.getStatus());
		ICountry c = new Country("test");
		ICountry c1 = new Country("test");
		ge.getWorld().addCountry(c);
		ge.getWorld().addCountry(c1);
		ge.getCurrentPlayer().addCountry(c);
		ge.getOpponent().addCountry(c1);
		assertTrue(ge.selectRecruitment(c, 1));
		ge.recruit();
		assertTrue(!ge.selectRecruitment(c1, 1));
	}

	public void testCheck() {
		assertTrue(ge.check(new Point(51, 112)) != null);
		assertTrue(ge.check(new Point(0, 0)) == null);
	}

	public void testRest() {
		IObserver o = null;
		ge.createMap();
		ICountry c = new Country("test");
		ICountry c1 = new Country("test");
		ge.getWorld().addCountry(c);
		ge.getWorld().addCountry(c1);
		ge.startGame();
		ge.notifyObservers();
		ge.addObserver(o);
		ge.removeObserver(o);
		ge.removeAllObservers();
		ge.setCurrentPlayer();
		ge.getSoldiers(c);
		ge.getOwner(c);
		ge.getMaxRecruitment();
		ge.getCandidates(c);
		ge.getCountries(ge.getCurrentPlayer());
	}
	
	public void testGetCandidates() {
		IWorld test = ge.getWorld();
		IPlayer player1 = new Player("player1");
		IPlayer player2 = new Player("player2");
		ICountry country1 = new Country("country1");
		ICountry country2 = new Country("country2");
		test.addCountry(country1);
		test.addCountry(country2);
		test.addEdge(country1, country2);
		player1.addCountry(country1);
		player2.addCountry(country2);
		List<ICountry> res = ge.getCandidates(country1);
		assertFalse(res.contains(country1));
	}
	
	public void testGetNeighbours() {
		ge.startGame();
		IPlayer test = ge.getCurrentPlayer();
		IPlayer opp = ge.getOpponent();
		ICountry countryTest = test.getCountries().get(1);
		ICountry countryOpp = opp.getCountries().get(1);
		assertFalse(ge.getNeighbours(countryTest).contains(countryOpp));
	}
	
	public void testSelectAttacker() {
		IPlayer test = ge.getCurrentPlayer();
		ICountry countryTest = new Country("countryTest");
		test.addCountry(countryTest);
		countryTest.setSoldiers(2);
		assertTrue(ge.selectAttacker(countryTest));
		countryTest.setSoldiers(1);
		assertFalse(ge.selectAttacker(countryTest));
		test.removeCountry(countryTest);
		assertFalse(ge.selectAttacker(countryTest));
	}
	
	public void testSelectRecruitmentFail() {
		ge.startGame();
		IPlayer test = ge.getCurrentPlayer();
		ICountry countryFail = new Country("countryFail");
		test.addCountry(countryFail);
		assertFalse(ge.selectRecruitment(countryFail, 1));
	}
	
	public void testSelectRecruitmentSuccess() {
		ge.startGame();
		ge.endTurn();
		IPlayer test = ge.getCurrentPlayer();
		ICountry countrySuccess = test.getCountries().get(1);
		assertTrue(ge.selectRecruitment(countrySuccess, 1));
	}
	
	public void testMoveSoldiers() {
		ICountry source = new Country("source");
		ICountry target = new Country("target");
		source.setSoldiers(2);
		ge.moveSoldiers(3, source, target);
	}
	
}
