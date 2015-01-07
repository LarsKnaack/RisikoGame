package de.htwg.risiko.turn;

import de.htwg.risiko.model.CountryI;

public class RecruitmentTurn implements TurnState {

	private CountryI recCountry;
	private int maxRecruitment;
	private int recruitment;

	@Override
	public void pull(Turn turn) {
		maxRecruitment = turn.getMaxRecruitment();
		if (maxRecruitment <= 0) {
			turn.setState(new InvadeTurn());
			return;
		}
		recCountry = turn.getRecCountry();
		recruitment = turn.getRecruitment();
		addRecruitment();
		turn.setMaxRecruitment(turn.getMaxRecruitment() - recruitment);
	}
	
	public void addRecruitment() {
		if(maxRecruitment - recruitment < 0) {
			return;
		}
		recCountry.setSoldiers(recCountry.getSoldiers() + recruitment);
	}
}
