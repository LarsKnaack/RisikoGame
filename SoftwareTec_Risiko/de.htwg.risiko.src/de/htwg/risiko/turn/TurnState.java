package de.htwg.risiko.turn;

import de.htwg.risiko.controller.GameEngine;
import de.htwg.risiko.model.WorldI;

public interface TurnState {
	WorldI world = GameEngine.world;
	void pull (Turn turn);

}
