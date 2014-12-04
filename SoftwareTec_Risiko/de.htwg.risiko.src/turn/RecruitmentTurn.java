package turn;

import entities.Country;

public class RecruitmentTurn implements TurnState{

	@Override
	public void pull(Turn turn) {
		Country invader = new Country("Invader");
		Country defender = new Country("Defender");
		turn.setState(new InvadeTurn(invader, defender) );
	}

}
