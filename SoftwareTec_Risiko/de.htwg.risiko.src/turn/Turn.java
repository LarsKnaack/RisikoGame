package turn;

public class Turn {
	
	private TurnState current;
	
	public Turn() {
		current = new StartTurn();
	}
	
	public void setState (TurnState s) {
		current = s;
	}
	
	public void pull () {
		current.pull(this);
	}

}
