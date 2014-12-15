package de.htwg.risiko.turn;

import java.util.LinkedList;
import java.util.List;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.WorldI;

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
		List<CountryI> res = new LinkedList<CountryI>();
		for(CountryI c :  world.getWorld().keySet()){
			c.setSoldiers(1);
			if (i % 2 == 0) {
				res = player1.getCountries();
				res.add(c);
				player1.setCountries(res);
				i++;
			} else {
				res = player2.getCountries();
				res.add(c);
				player2.setCountries(res);
				i++;
			}
		}	
	}
}
