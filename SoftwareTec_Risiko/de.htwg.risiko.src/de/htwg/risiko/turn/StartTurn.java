package de.htwg.risiko.turn;

import de.htwg.risiko.model.PlayerI;

public class StartTurn implements TurnState{
	
	private PlayerI current;
	
	public StartTurn(PlayerI p) {
		current = p;
	}

	@Override
	public void pull(Turn turn) {
		init();
		turn.setState(new InvadeTurn(current) );
	}
	
	private void init() {
		
	}
	
	
	

}
