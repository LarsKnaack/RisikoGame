package de.htwg.risiko.controller.logwrapper;

import java.awt.Point;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.inject.Inject;

import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.WorldI;
import de.htwg.risiko.util.observer.IObservable;
import de.htwg.risiko.util.observer.IObserver;


public class GameEngine implements IGameEngine, IObservable {


	private Logger logger = Logger.getLogger("de.htwg.risiko.controller.wrappedimpl");
	private IGameEngine realController;
	private long startTime;

	@Inject
	public GameEngine() {
		realController = new de.htwg.risiko.controller.impl.GameEngine();
	}

	private void pre() {
		logger.debug("Controller method " + getMethodName(1) + " was called.");
		startTime = System.nanoTime();
	}

	private void post() {
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		logger.debug("Controller method " + getMethodName(1)
				+ " was finished in " + duration + " nanoSeconds.");
	}

	private static String getMethodName(final int depth) {
		final StackTraceElement[] stack = Thread.currentThread()
				.getStackTrace();
		return stack[2 + depth].getMethodName();
	}

	public void createMap() {
		pre();
		realController.createMap();
		post();
	}
	
	/*public void exit() {
		pre();
		realController.exit();
		post();
	}*/

	public void startGame() {
		pre();
		realController.startGame();
		post();
	}

	public void changePlayer() {
		pre();
		realController.changePlayer();
		post();
	}

	public void invade() {
		pre();
		realController.invade();
		post();
	}

	public void recruit() {
		pre();
		realController.recruit();
		post();
	}

	public PlayerI getOwner(CountryI c) {
		pre();
		PlayerI res = realController.getOwner(c);
		post();
		return res;
	}

	public List<CountryI> getCountries(PlayerI p) {
		pre();
		List<CountryI> res = realController.getCountries(p);
		post();
		return res;
	}

	public List<CountryI> getCandidates(CountryI c) {
		pre();
		List<CountryI> res = realController.getCandidates(c);
		post();
		return res;
	}
	
	public List<CountryI> getNeighbours(CountryI c) {
		pre();
		List<CountryI> res = realController.getNeighbours(c);
		post();
		return res;
	}

	public void endTurn() {
		pre();
		realController.endTurn();
		post();
	}

	public void setCurrentPlayer() {
		pre();
		realController.setCurrentPlayer();
		post();
	}

	public int getSoldiers(CountryI c) {
		pre();
		int res = realController.getSoldiers(c);
		post();
		return res;
	}

	public boolean selectTarget(CountryI c) {
		pre();
		boolean res = realController.selectTarget(c);
		post();
		return res;
	}

	public boolean selectAttacker(CountryI c) {
		pre();
		boolean res = realController.selectAttacker(c);
		post();
		return res;
	}

	public boolean selectRecruitment(CountryI c, int num) {
		pre();
		boolean res = realController.selectRecruitment(c, num);
		post();
		return res;
	}

	@Override
	public WorldI getWorld() {
		pre();
		WorldI res = realController.getWorld();
		post();
		return res;
	}

	@Override
	public PlayerI getCurrentPlayer() {
		pre();
		PlayerI res = realController.getCurrentPlayer();
		post();
		return res;
	}

	@Override
	public PlayerI getOpponent() {
		pre();
		PlayerI res = realController.getOpponent();
		post();
		return res;
	}

	@Override
	public String getStatus() {
		pre();
		String res = realController.getStatus();
		post();
		return res;
	}

	@Override
	public int getMaxRecruitment() {
		pre();
		int res = realController.getMaxRecruitment();
		post();
		return res;
	}
	
	public void moveSoldiers(int i, CountryI source, CountryI tar) {
		pre();
		realController.moveSoldiers(i, source, tar);
		post();
	}

	@Override
	public void addObserver(IObserver s) {
		pre();
		realController.addObserver(s);
		post();
	}

	@Override
	public void removeObserver(IObserver s) {
		pre();
		realController.removeObserver(s);
		post();
	}

	@Override
	public void removeAllObservers() {
		pre();
		realController.removeAllObservers();
		post();
	}

	@Override
	public void notifyObservers() {
		pre();
		realController.notifyObservers();
		post();
	}


	@Override
	public CountryI check(Point p) {
		pre();
		CountryI res = realController.check(p);
		post();
		return res;
	}
}