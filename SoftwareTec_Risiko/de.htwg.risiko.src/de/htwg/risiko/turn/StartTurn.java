package de.htwg.risiko.turn;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import de.htwg.risiko.model.ICountry;
import de.htwg.risiko.model.IPlayer;
import de.htwg.risiko.model.IWorld;

public class StartTurn implements TurnState{
	
	private IPlayer player1;
	private IPlayer player2;
	private IWorld world;
	private static final int INIT_SOLDIERS = 3;
	
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
		List<ICountry> countries = new LinkedList<ICountry>();
		countries.addAll(world.getWorld().keySet());
		
		Collections.shuffle(countries);
		
		for(ICountry c :  countries){
			c.setSoldiers(INIT_SOLDIERS);
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
