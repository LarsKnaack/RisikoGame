package de.htwg.risiko.turn;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.WorldI;

public class Turn {
	
	private TurnState currentState;
	private PlayerI player;
	private PlayerI opponent;
	private WorldI world;
	private CountryI invader;
	private CountryI defender;
	public boolean end;
	
	public Turn() {
		currentState = new StartTurn();
	}

	public void endTurn() {
		end = true;
	}

	public void startTurn() {
		end = false;
	}

	public boolean hasFinished() {
		return end;
	}
	
	public void setPlayer (PlayerI p, PlayerI o) {
		opponent = o;
		player = p;
	}

	public void switchPlayer(PlayerI p) {
		opponent = player;
		player = p;
	}

	public WorldI getWorld () {
		return world;
	}

	public void setWorld(WorldI w) {
		world = w;
	}
	
	public PlayerI getPlayer () {
		return player;
	}

	public PlayerI getOpponent() {
		return opponent;
	}

	public void setState(TurnState s) {
		currentState = s;
	}
	
	public TurnState getState() {
		return currentState;
	}
	
	public void pull () {
		currentState.pull(this);
	}

	public CountryI getDefender() {
		return defender;
	}

	public void setDefender(CountryI defender) {
		this.defender = defender;
	}

	public CountryI getInvader() {
		return invader;
	}

	public void setInvader(CountryI invader) {
		this.invader = invader;
	}
}
