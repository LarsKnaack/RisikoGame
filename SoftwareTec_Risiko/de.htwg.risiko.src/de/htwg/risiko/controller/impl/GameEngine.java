package de.htwg.risiko.controller.impl;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import com.google.inject.Inject;

import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.WorldI;
import de.htwg.risiko.model.impl.Player;
import de.htwg.risiko.model.impl.World;
import de.htwg.risiko.turn.Turn;
import de.htwg.risiko.util.observer.Observable;

public class GameEngine extends Observable implements IGameEngine {
	private WorldI world;
	private PlayerI player1 = new Player("player1");
	private PlayerI player2 = new Player("player2");
	private Turn turn;
	private PlayerI currentPlayer;
	private CountryI target;
	private CountryI attacker;
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

	public PlayerI getOwner(CountryI c) {
		if (getCountries(player1).contains(c)) {
			return player1;
		}
		return player2;
	}

	public List<CountryI> getCountries(PlayerI p) {
		return p.getCountries();
	}

	public List<CountryI> getCandidates(CountryI c) {
		List<CountryI> res = new LinkedList<CountryI>();
		for (CountryI d : world.getNeighbouringCountryList(c)) {
			if (!getOwner(c).equals(getOwner(d))) {
				res.add(d);
			}
		}
		return res;
	}
	
	public List<CountryI> getNeighbours(CountryI c) {
		List<CountryI> res = new LinkedList<CountryI>();
		for (CountryI d : world.getNeighbouringCountryList(c)) {
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

	public int getSoldiers(CountryI c) {
		return c.getSoldiers();
	}

	public boolean selectTarget(CountryI c) {
		if (getCandidates(attacker).contains(c)) {
			target = c;
			return true;
		}
		return false;
	}

	public boolean selectAttacker(CountryI c) {
		if (getCountries(currentPlayer).contains(c) && getSoldiers(c) > 1) {
			attacker = c;
			return true;
		}
		return false;
	}

	public boolean selectRecruitment(CountryI c, int num) {
		if (getOwner(c).equals(currentPlayer) && getMaxRecruitment() > 0) {
			turn.setRecruitment(num);
			turn.setRecCountry(c);
			return true;
		}
		return false;
	}

	@Override
	public WorldI getWorld() {
		return world;
	}

	@Override
	public PlayerI getCurrentPlayer() {
		return currentPlayer;
	}

	@Override
	public PlayerI getOpponent() {
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
	
	public void moveSoldiers(int i, CountryI source, CountryI tar) {
		if (i < source.getSoldiers()) {
			source.setSoldiers(source.getSoldiers() - i);
			tar.setSoldiers(tar.getSoldiers() + i);
		}
		notifyObservers();
	}

	public CountryI check(Point p) {
		for(CountryI c : world.getWorld().keySet()) {
			if(c.getLocation().distance(p) <= DISTANCE) {
				return c;
			}
		}
		return null;
	}
}
