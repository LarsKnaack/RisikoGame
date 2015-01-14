package de.htwg.risiko.controller;

import java.awt.Point;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import de.htwg.risiko.controller.logwrapper.GameEngine;
import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.impl.Country;
import de.htwg.risiko.util.observer.IObserver;
import junit.framework.TestCase;

public class GameEngineTest extends TestCase {

	static
	{
	    Logger rootLogger = Logger.getRootLogger();
	    rootLogger.setLevel(Level.INFO);
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
		CountryI c = new Country("test");
		CountryI c1 = new Country("test");
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
		CountryI c = new Country("test");
		CountryI c1 = new Country("test");
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
		CountryI c = new Country("test");
		CountryI c1 = new Country("test");
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
}
