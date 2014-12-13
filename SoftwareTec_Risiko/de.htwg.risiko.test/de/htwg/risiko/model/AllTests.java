package de.htwg.risiko.model;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.htwg.risiko.turn.DieTest;
import de.htwg.risiko.turn.StartTurnTest;
import de.htwg.risiko.turn.TurnTest;
import de.htwg.risiko.turn.InvadeTurnTest;


@RunWith(Suite.class)

@SuiteClasses({ CountryTest.class, PlayerTest.class, WorldTest.class, TurnTest.class, InvadeTurnTest.class, StartTurnTest.class, DieTest.class})

public class AllTests {

}
