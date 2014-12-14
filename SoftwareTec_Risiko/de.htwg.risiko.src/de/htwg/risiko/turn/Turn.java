package de.htwg.risiko.turn;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.WorldI;

public class Turn {
	
	private TurnState current;
	private static PlayerI player;
	private static PlayerI opponent;
	private static WorldI world;
	private static CountryI invader;
	private static CountryI defender;
	
	public Turn(PlayerI p, WorldI w) {
		player = p;
		world = w;
		current = new StartTurn();
	}
	
	public Turn() {
		current = new StartTurn();
	}
	
	public void setPlayer (PlayerI p, PlayerI o) {
		opponent = o;
		player = p;
	}

	public void switchPlayer(PlayerI p) {
		opponent = player;
		player = p;
	}

	public static WorldI getWorld () {
		return world;
	}
	
	public static PlayerI getPlayer () {
		return player;
	}

	public static PlayerI getOpponent() {
		return opponent;
	}

	public void setState (TurnState s) {
		current = s;
	}
	
	public TurnState getState() {
		return current;
	}
	
	public void pull () {
		current.pull(this);
	}

	public static CountryI getDefender() {
		return defender;
	}

	public void setDefender(CountryI defender) {
		Turn.defender = defender;
	}

	public static CountryI getInvader() {
		return invader;
	}

	public void setInvader(CountryI invader) {
		Turn.invader = invader;
	}
}
