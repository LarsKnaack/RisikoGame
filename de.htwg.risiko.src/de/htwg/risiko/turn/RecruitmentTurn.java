package de.htwg.risiko.turn;

import de.htwg.risiko.model.ICountry;

public class RecruitmentTurn implements TurnState {

	private ICountry recCountry;
	private int maxRecruitment;
	private int recruitment;
	private StringBuilder sb;

	@Override
	public void pull(Turn turn) {
		maxRecruitment = turn.getMaxRecruitment();
		recCountry = turn.getRecCountry();
		recruitment = turn.getRecruitment();
		sb = new StringBuilder();

		addRecruitment(turn);
		turn.setStatus(sb.toString());

		if (turn.getMaxRecruitment() == 0) {
			turn.setState(new InvadeTurn());
			return;
		}
	}
	
	public void addRecruitment(Turn t) {
		if(maxRecruitment - recruitment < 0) {
			sb.append(String.format("you only have %d recruitments left!\n", maxRecruitment));
			return;
		}
		recCountry.setSoldiers(recCountry.getSoldiers() + recruitment);
		t.setMaxRecruitment(maxRecruitment - recruitment);
		sb.append(String.format("%d units added to %s! (%d recruitments left)\n", recruitment, recCountry.getName(), t.getMaxRecruitment()));
	}
}
