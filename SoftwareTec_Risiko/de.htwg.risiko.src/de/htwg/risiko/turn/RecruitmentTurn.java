package de.htwg.risiko.turn;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.impl.Country;

public class RecruitmentTurn implements TurnState{
	
	public RecruitmentTurn(PlayerI p) {
		current = p;
	}
	
	private PlayerI current;
	private int recruitment = current.getCountries().size() / 3;

	@Override
	public void pull(Turn turn) {
		turn.setState(new InvadeTurn(current));
	}
	
	public void addRecruitment(CountryI c, int rec) {
		if(0 < recruitment - rec || !(current.getCountries().contains(c))) {
			return;
		}
		c.setSoldiers(c.getSoldiers() + rec);
	}

}
