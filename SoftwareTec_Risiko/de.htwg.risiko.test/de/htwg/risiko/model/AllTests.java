package de.htwg.risiko.model;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.htwg.risiko.gamefield.WorldTest;
import de.htwg.risiko.turn.DieTest;


@RunWith(Suite.class)

@SuiteClasses({ CountryTest.class, PlayerTest.class, WorldTest.class , DieTest.class})

public class AllTests {

}
