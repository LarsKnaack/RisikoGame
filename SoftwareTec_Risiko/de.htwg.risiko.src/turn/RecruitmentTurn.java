package turn;

public class RecruitmentTurn implements TurnState{

	@Override
	public void pull(Turn turn) {
		turn.setState(new InvadeTurn());
		
	}

}
