package de.htwg.risiko.controller;

import java.util.LinkedList;
import java.util.List;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.WorldI;
import de.htwg.risiko.model.impl.Country;
import de.htwg.risiko.model.impl.Player;
import de.htwg.risiko.model.impl.World;
import de.htwg.risiko.turn.Turn;

public class GameEngine {
	
	public static WorldI world = new World();
	public static PlayerI player1 = new Player("Hans");
	public static PlayerI player2 = new Player("Herbert");
	
	private Turn turn;
	private boolean finished;
	private PlayerI currentPlayer;
	private CountryI target;
	private CountryI attacker;
	
	public GameEngine() {
		finished = false;
		currentPlayer = player2;
	}

	public void exit() {
		System.exit(0);
	}

	public void startGame() {
		turn = new Turn();
		turn.setPlayer(player1, player2);
		turn.getState().pull(turn);
		
	}

	public void changePlayer() {
		setCurrentPlayer();
		turn.switchPlayer(currentPlayer);
	}

	public void invade() {
		turn.setInvader(attacker);
		turn.setDefender(target);
		turn.getState().pull(turn);
	}

	public void recruit() {
		turn.getState().pull(turn);
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
		for (CountryI d: world.getNeighbouringCountryList(c)) {
			if(!getOwner(c).equals(getOwner(d))) {
				res.add(d);
			}
		}
		return res;
	}

	public boolean isDone() {
		return finished;
	}

	public void setFinished() {
		finished = true;
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
		if (getCountries(currentPlayer).contains(c)) {
			attacker = c;
			return true;
		}
		return false;
	}

	public boolean selectRecruitment(CountryI c, int num) {
		if(getOwner(c).equals(currentPlayer)) {
			c.setSoldiers(c.getSoldiers() + num);
			return true;
		}
		return false;
	}
}
