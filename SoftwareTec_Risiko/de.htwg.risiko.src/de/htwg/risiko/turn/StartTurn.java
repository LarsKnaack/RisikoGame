package de.htwg.risiko.turn;

import de.htwg.risiko.model.CountryI;

public class StartTurn implements TurnState{
	

	@Override
	public void pull(Turn turn) {
		init();
		turn.setState(new InvadeTurn(player1));
	}
	
	private void init() {
		for(CountryI c : world.getWorld().keySet()){
			c.setSoldiers(1);
		}
		
	}
	
	
	

}
