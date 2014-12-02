package source;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import turn.DieTest;
import turn.TurnTest;
import world.WorldTest;


@RunWith(Suite.class)

@SuiteClasses({ CountryTest.class, PlayerTest.class, TurnTest.class, WorldTest.class , DieTest.class})

public class AllTests {

}
