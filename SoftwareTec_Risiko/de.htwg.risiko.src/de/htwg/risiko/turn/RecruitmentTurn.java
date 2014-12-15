package de.htwg.risiko.turn;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;

public class RecruitmentTurn implements TurnState{
	
	private PlayerI player;
	private int recruitment;

	@Override
	public void pull(Turn turn) {
		if (turn.hasFinished()) {
			turn.startTurn();
			turn.setState(new InvadeTurn());
		}
		player = turn.getPlayer();
		recruitment = player.getCountries().size() / 3;
		if(recruitment < 3) {
			recruitment = 3;
		}
	}
	
	public void addRecruitment(CountryI c, int rec) {
		if(recruitment - rec < 0 || !(player.getCountries().contains(c))) {
			return;
		}
		c.setSoldiers(c.getSoldiers() + rec);
	}
}
