package de.htwg.risiko.model;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.htwg.risiko.turn.DieTest;
import de.htwg.risiko.turn.InvadeTurnTest;
import de.htwg.risiko.turn.RecruitmentTurnTest;
import de.htwg.risiko.turn.StartTurnTest;
import de.htwg.risiko.turn.TurnTest;


@RunWith(Suite.class)

@SuiteClasses({CountryTest.class, PlayerTest.class, WorldTest.class, TurnTest.class,
	InvadeTurnTest.class, StartTurnTest.class, RecruitmentTurnTest.class, DieTest.class})

public class AllTests {

}
