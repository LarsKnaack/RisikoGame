package de.htwg.risiko.turn;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class TurnTest extends TestCase{

	public void testPull() {
		Turn t = new Turn();
		t.pull();
		assertTrue(t.getState() instanceof InvadeTurn);
	}

}
