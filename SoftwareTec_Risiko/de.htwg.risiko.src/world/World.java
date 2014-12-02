package world;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import source.Country;

public class World implements WorldGraph{

	private Map<Country, LinkedList<Country>> world;

	public World() {
		world = new HashMap<Country, LinkedList<Country>>();
	}

	@Override
	public void addCountry(Country v) {
		getWorld().put(v, new LinkedList<Country>());	
	}

	@Override
	public void addEdge(Country v, Country w) {
		getWorld().get(v).add(w);
		getWorld().get(w).add(v);
	}

	@Override
	public List<Country> getNeighbouringCountryList(Country v) {
		return getWorld().get(v);
	}

	@Override
	public boolean isNeighbour(Country v, Country w) {
		return getNeighbouringCountryList(v).contains(w);
	}

	public Map<Country, LinkedList<Country>> getWorld() {
		return world;
	}

	public void setWorld(Map<Country, LinkedList<Country>> world) {
		this.world = world;
	}

}
