package de.htwg.risiko.controller.logwrapper;

import java.awt.Point;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.inject.Inject;

import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.model.ICountry;
import de.htwg.risiko.model.IPlayer;
import de.htwg.risiko.model.IWorld;
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

	public IPlayer getOwner(ICountry c) {
		pre();
		IPlayer res = realController.getOwner(c);
		post();
		return res;
	}

	public List<ICountry> getCountries(IPlayer p) {
		pre();
		List<ICountry> res = realController.getCountries(p);
		post();
		return res;
	}

	public List<ICountry> getCandidates(ICountry c) {
		pre();
		List<ICountry> res = realController.getCandidates(c);
		post();
		return res;
	}
	
	public List<ICountry> getNeighbours(ICountry c) {
		pre();
		List<ICountry> res = realController.getNeighbours(c);
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

	public int getSoldiers(ICountry c) {
		pre();
		int res = realController.getSoldiers(c);
		post();
		return res;
	}

	public boolean selectTarget(ICountry c) {
		pre();
		boolean res = realController.selectTarget(c);
		post();
		return res;
	}

	public boolean selectAttacker(ICountry c) {
		pre();
		boolean res = realController.selectAttacker(c);
		post();
		return res;
	}

	public boolean selectRecruitment(ICountry c, int num) {
		pre();
		boolean res = realController.selectRecruitment(c, num);
		post();
		return res;
	}

	@Override
	public IWorld getWorld() {
		pre();
		IWorld res = realController.getWorld();
		post();
		return res;
	}

	@Override
	public IPlayer getCurrentPlayer() {
		pre();
		IPlayer res = realController.getCurrentPlayer();
		post();
		return res;
	}

	@Override
	public IPlayer getOpponent() {
		pre();
		IPlayer res = realController.getOpponent();
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
	
	public void moveSoldiers(int i, ICountry source, ICountry tar) {
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
	public ICountry check(Point p) {
		pre();
		ICountry res = realController.check(p);
		post();
		return res;
	}
}