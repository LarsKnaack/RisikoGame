package de.htwg.risiko.controller.impl;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import com.google.inject.Inject;

import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.model.ICountry;
import de.htwg.risiko.model.IPlayer;
import de.htwg.risiko.model.IWorld;
import de.htwg.risiko.model.impl.Player;
import de.htwg.risiko.model.impl.World;
import de.htwg.risiko.turn.Turn;
import de.htwg.risiko.util.observer.Observable;

public class GameEngine extends Observable implements IGameEngine {
	private IWorld world;
	private IPlayer player1 = new Player("player1");
	private IPlayer player2 = new Player("player2");
	private Turn turn;
	private IPlayer currentPlayer;
	private ICountry target;
	private ICountry attacker;
	private String statusline = "Welcome to RiskGame!";
	
	private static final int DISTANCE = 20;

	@Inject
	public GameEngine() {
		currentPlayer = player2;
		createMap();
		notifyObservers();
	}

	public final void createMap() {
		world = new World();
		new RiskMap(world);
	}
	
	public void startGame() {
		turn = new Turn();
		turn.setWorld(world);
		turn.setPlayer(player1, player2);
		setCurrentPlayer();
		turn.getState().pull(turn);
		statusline = "Game initialised";
		notifyObservers();
	}

	public void changePlayer() {
		setCurrentPlayer();
		turn.switchPlayer(currentPlayer);
		statusline = "It's your turn " + currentPlayer.getName();
		notifyObservers();
	}

	public void invade() {
		turn.setInvader(attacker);
		turn.setDefender(target);
		turn.getState().pull(turn);
		statusline = attacker.getName() + " is attacking " + target.getName() + turn.getStatus();
		notifyObservers();
	}

	public void recruit() {
		turn.getState().pull(turn);
		statusline = "now select recruitment" + turn.getStatus();
		notifyObservers();
	}

	public IPlayer getOwner(ICountry c) {
		if (getCountries(player1).contains(c)) {
			return player1;
		}
		return player2;
	}

	public List<ICountry> getCountries(IPlayer p) {
		return p.getCountries();
	}

	public List<ICountry> getCandidates(ICountry c) {
		List<ICountry> res = new LinkedList<ICountry>();
		for (ICountry d : world.getNeighbouringCountryList(c)) {
			if (!getOwner(c).equals(getOwner(d))) {
				res.add(d);
			}
		}
		return res;
	}
	
	public List<ICountry> getNeighbours(ICountry c) {
		List<ICountry> res = new LinkedList<ICountry>();
		for (ICountry d : world.getNeighbouringCountryList(c)) {
			if(getOwner(c).equals(getOwner(d))) {
				res.add(d);
			}
		}
		return res;
	}

	public void endTurn() {
		turn.endTurn();
		turn.getState().pull(turn);
		statusline = "now select recruitment";
		notifyObservers();
	}

	public void setCurrentPlayer() {
		if (currentPlayer.equals(player1)) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}
	}

	public int getSoldiers(ICountry c) {
		return c.getSoldiers();
	}

	public boolean selectTarget(ICountry c) {
		if (getCandidates(attacker).contains(c)) {
			target = c;
			return true;
		}
		return false;
	}

	public boolean selectAttacker(ICountry c) {
		if (getCountries(currentPlayer).contains(c) && getSoldiers(c) > 1) {
			attacker = c;
			return true;
		}
		return false;
	}

	public boolean selectRecruitment(ICountry c, int num) {
		if (getOwner(c).equals(currentPlayer) && getMaxRecruitment() > 0) {
			turn.setRecruitment(num);
			turn.setRecCountry(c);
			return true;
		}
		return false;
	}

	@Override
	public IWorld getWorld() {
		return world;
	}

	@Override
	public IPlayer getCurrentPlayer() {
		return currentPlayer;
	}

	@Override
	public IPlayer getOpponent() {
		if (currentPlayer.equals(player1)) {
			return player2;
		}
		return player1;
	}

	@Override
	public String getStatus() {
		return statusline;
	}

	@Override
	public int getMaxRecruitment() {
		return turn.getMaxRecruitment();
	}
	
	public void moveSoldiers(int i, ICountry source, ICountry tar) {
		if (i < source.getSoldiers()) {
			source.setSoldiers(source.getSoldiers() - i);
			tar.setSoldiers(tar.getSoldiers() + i);
		}
		notifyObservers();
	}

	public ICountry check(Point p) {
		for(ICountry c : world.getWorld().keySet()) {
			if(c.getLocation().distance(p) <= DISTANCE) {
				return c;
			}
		}
		return null;
	}
}
