package world;

import junit.framework.TestCase;
import source.Country;
import world.World;

public class WorldTest extends TestCase {

	public void testAddCountry() {
		World world = new World();
		Country test = new Country("test");
		world.addCountry(test);
		assertTrue(world.getWorld().containsKey(test));
	}

	public void testAddEdge() {
		World world = new World();
		Country test1 = new Country("test1");
		Country test2 = new Country("test2");
		world.addCountry(test1);
		world.addCountry(test2);
		world.addEdge(test1, test2);
		assertTrue(world.getWorld().get(test1).contains(test2));
		assertTrue(world.getWorld().get(test2).contains(test1));
	}

	public void testGetNeighbouringCountryList() {
		World world = new World();
		Country test1 = new Country("test1");
		Country test2 = new Country("test2");
		world.addCountry(test1);
		world.addCountry(test2);
		world.addEdge(test1, test2);
		world.getNeighbouringCountryList(test1);
		assertTrue(world.getNeighbouringCountryList(test1).equals(world.getWorld().get(test1)));
	}

	public void testIsNeighbour() {
		World world = new World();
		Country test1 = new Country("test1");
		Country test2 = new Country("test2");
		world.addCountry(test1);
		world.addCountry(test2);
		world.addEdge(test1, test2);
		assertTrue(world.isNeighbour(test1, test2));
	}
}
