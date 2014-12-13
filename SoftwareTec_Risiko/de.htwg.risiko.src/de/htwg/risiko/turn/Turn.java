package de.htwg.risiko.turn;

import de.htwg.risiko.model.PlayerI;

public class Turn {
	
	private TurnState current;
	private PlayerI player;
	
	public Turn(PlayerI p) {
		player = p;
		current = new StartTurn();
	}
	
	public Turn() {
		current = new StartTurn();
	}
	
	public void setPlayer (PlayerI p) {
		player = p;
	}
	
	public PlayerI getPlayer () {
		return player;
	}
	public void setState (TurnState s) {
		current = s;
	}
	
	public void pull () {
		current.pull(this);
	}

	public TurnState getState() {
		return current;
	}
}
