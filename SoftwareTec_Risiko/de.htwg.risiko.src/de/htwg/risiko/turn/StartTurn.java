package de.htwg.risiko.turn;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.WorldI;
import de.htwg.risiko.model.impl.Country;

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
		List<CountryI> countries = new LinkedList<CountryI>();
		countries.addAll(world.getWorld().keySet());
		
		Collections.shuffle(countries);
		
		for(CountryI c :  countries){
			c.setSoldiers(3);
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
