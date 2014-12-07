package de.htwg.risiko.turn;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.impl.Country;

public class RecruitmentTurn implements TurnState{

	@Override
	public void pull(Turn turn) {
		CountryI invader = new Country("Invader");
		CountryI defender = new Country("Defender");
		handle();
		turn.setState(new InvadeTurn(invader, defender) );
	}
	
	CountryI handle() {
		return new Country("h");
	}

}
