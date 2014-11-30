package test_source;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ CountryTest.class, PlayerTest.class, TurnTest.class, WorldTest.class })
public class AllTests {

}
