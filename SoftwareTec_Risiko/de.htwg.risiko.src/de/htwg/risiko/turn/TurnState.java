package de.htwg.risiko.turn;

import de.htwg.risiko.controller.GameEngine;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.WorldI;

public interface TurnState {
	WorldI world = GameEngine.world;
	PlayerI player1 = GameEngine.player1;
	PlayerI player2 = GameEngine.player2;
	void pull (Turn turn);

}
