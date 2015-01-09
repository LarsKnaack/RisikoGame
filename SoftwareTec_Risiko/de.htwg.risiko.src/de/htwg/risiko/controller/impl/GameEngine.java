package de.htwg.risiko.controller.impl;

import java.util.LinkedList;
import java.util.List;

import de.htwg.risiko.RiskMap;
import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.WorldI;
import de.htwg.risiko.model.impl.Country;
import de.htwg.risiko.model.impl.Player;
import de.htwg.risiko.model.impl.World;
import de.htwg.risiko.turn.Turn;
import de.htwg.risiko.util.observer.Observable;

public class GameEngine extends Observable implements IGameEngine {
	public WorldI world;
	public PlayerI player1 = new Player("Hans");
	public PlayerI player2 = new Player("Herbert");
	private Turn turn;
	private PlayerI currentPlayer;
	private CountryI target;
	private CountryI attacker;
	private String statusline = "Welcome to RiskGame!";

	public GameEngine() {
		currentPlayer = player2;
		notifyObservers();
	}

	public void createMap(int i) {
		world = new World();
		if (i == 1) {
			CountryI ger = new Country("germany");
			CountryI fra = new Country("france");
			CountryI ch = new Country("switzerland");
			CountryI aus = new Country("austria");
			world.addCountry(ger);
			world.addCountry(fra);
			world.addCountry(ch);
			world.addCountry(aus);
			world.addEdge(ger, fra);
			world.addEdge(ger, ch);
			world.addEdge(ger, aus);
			world.addEdge(fra, ch);
			world.addEdge(aus, ch);
		} else if(i == 2) {
			RiskMap.create(world);
		}
	}
	
	public void exit() {
		statusline = "bye";
		notifyObservers();
		System.exit(0);
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
		if (getOwner(c).equals(currentPlayer) && turn.getMaxRecruitment() > 0) {
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
}
