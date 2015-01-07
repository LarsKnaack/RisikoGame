package de.htwg.risiko.turn;

import de.htwg.risiko.model.CountryI;

public class RecruitmentTurn implements TurnState {

	private CountryI recCountry;
	private int maxRecruitment;
	private int recruitment;

	@Override
	public void pull(Turn turn) {
		maxRecruitment = turn.getMaxRecruitment();
		recCountry = turn.getRecCountry();
		recruitment = turn.getRecruitment();
		addRecruitment(turn);
		if (turn.getMaxRecruitment() == 0) {
			turn.setState(new InvadeTurn());
			return;
		}
	}
	
	public void addRecruitment(Turn t) {
		if(maxRecruitment - recruitment < 0) {
			System.out.printf("you only have %d recruitments left!\n", maxRecruitment);
			return;
		}
		recCountry.setSoldiers(recCountry.getSoldiers() + recruitment);
		t.setMaxRecruitment(maxRecruitment - recruitment);
		System.out.printf("%d units added to %s! (%d recruitments left)\n", recruitment, recCountry.getName(), t.getMaxRecruitment());
	}
}
