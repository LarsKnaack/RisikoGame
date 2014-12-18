package de.htwg.risiko.turn;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.WorldI;
import de.htwg.risiko.view.Statistics;

public class StartTurn implements TurnState{
	
	private PlayerI player1;
	private PlayerI player2;
	private WorldI world;
	
	@Override
	public void pull(Turn turn) {
		player1 = turn.getPlayer();
		player2 = turn.getOpponent();
		world = turn.getWorld();
		init();
		turn.setState(new InvadeTurn());
	}
	
	private void init() {
		int i = 0;
		for(CountryI c :  world.getWorld().keySet()){
			c.setSoldiers(2);
			if (i % 2 == 0) {
				player1.addCountry(c);
				i++;
			} else {
				player2.addCountry(c);
				i++;
			}
		}	
	}
}
