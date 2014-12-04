package turn;

public class StartTurn implements TurnState{

	@Override
	public void pull(Turn turn) {
		turn.setState(new InvadeTurn() );
	}
	
	

}
