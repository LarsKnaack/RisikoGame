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
	
	public WorldI world;
	public PlayerI player1 = new Player("Hans");
	public PlayerI player2 = new Player("Herbert");
	
	private Turn turn;
	private PlayerI currentPlayer;
	private CountryI target;
	private CountryI attacker;
	
	public GameEngine() {
		currentPlayer = player2;
	}

	public void createMap() {
		world = new World();
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
	}

	public void exit() {
		System.exit(0);
	}

	public void startGame() {
		turn = new Turn();
		turn.setWorld(world);
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
		for (CountryI d : world.getNeighbouringCountryList(c)) {
			if(!getOwner(c).equals(getOwner(d))) {
				res.add(d);
			}
		}
		return res;
	}

	public void endTurn() {
		turn.endTurn();
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
			turn.setRecruitment(num);
			turn.setRecCountry(c);
			return true;
		}
		return false;
	}
}
