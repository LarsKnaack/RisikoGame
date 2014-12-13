package de.htwg.risiko.turn;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.impl.Country;

public class RecruitmentTurn implements TurnState{
	
	private PlayerI current;
	private int recruitment;
	
	public RecruitmentTurn(PlayerI p) {
		current = p;
		recruitment = current.getCountries().size() / 3;
		if(recruitment < 3) {
			recruitment = 3;
		}
	}
	
	@Override
	public void pull(Turn turn) {
		turn.setState(new InvadeTurn(current));
	}
	
	public void addRecruitment(CountryI c, int rec) {
		if(recruitment - rec < 0 || !(current.getCountries().contains(c))) {
			return;
		}
		c.setSoldiers(c.getSoldiers() + rec);
	}

}
