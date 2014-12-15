package de.htwg.risiko.turn;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;

public class RecruitmentTurn implements TurnState{
	
	private PlayerI player;
	private CountryI recCountry;
	private int maxRecruitment;
	private int recruitment;

	@Override
	public void pull(Turn turn) {
		maxRecruitment = turn.getMaxRecruitment();
		if (maxRecruitment == 0) {
			turn.setState(new InvadeTurn());
			return;
		}
		player = turn.getPlayer();
		recCountry = turn.getRecCountry();
		recruitment = turn.getRecruitment();
		addRecruitment(recCountry, recruitment);
		turn.setMaxRecruitment(turn.getMaxRecruitment() - recruitment);
	}
	
	public void addRecruitment(CountryI c, int rec) {
		if(maxRecruitment - rec < 0 || !(player.getCountries().contains(c))) {
			return;
		}
		c.setSoldiers(c.getSoldiers() + rec);
	}
}
