package de.htwg.risiko.turn;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.impl.Country;

public class StartTurn implements TurnState{

	@Override
	public void pull(Turn turn) {
		CountryI invader = new Country("Invader");
		CountryI defender = new Country("Defender");
		turn.setState(new InvadeTurn(invader, defender) );
	}
	
	

}
