package source;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class World implements WorldGraph{

	public HashMap<Country, LinkedList<Country>> world;

	public World() {
		world = new HashMap<Country, LinkedList<Country>>();
	}

	@Override
	public void addCountry(Country v) {
		world.put(v, new LinkedList<Country>());	
	}

	@Override
	public void addEdge(Country v, Country w) {
		world.get(v).add(w);
		world.get(w).add(v);
	}

	@Override
	public List<Country> getNeighbouringCountryList(Country v) {
		return world.get(v);
	}

	@Override
	public boolean isNeighbour(Country v, Country w) {
		return getNeighbouringCountryList(v).contains(w);
	}

}
