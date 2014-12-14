package de.htwg.risiko.turn;

import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.WorldI;

public interface TurnState {

	WorldI world = Turn.getWorld();
	PlayerI player = Turn.getPlayer();
	PlayerI opponent = Turn.getOpponent();
	void pull (Turn turn);
}
