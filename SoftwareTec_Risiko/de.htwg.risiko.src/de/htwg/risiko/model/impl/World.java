package de.htwg.risiko.model.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.WorldI;

public class World implements WorldI {
	private Map<Country, LinkedList<Country>> world;

	public World() {
		world = new HashMap<Country, LinkedList<Country>>();
	}

	@Override
	public void addCountry(CountryI v) {
		getWorld().put((Country) v, new LinkedList<Country>());
	}

	@Override
	public void addEdge(CountryI v, CountryI w) {
		getWorld().get(v).add((Country) w);
		getWorld().get(w).add((Country) v);
	}

	@Override
	public List<CountryI> getNeighbouringCountryList(CountryI v) {
		List<CountryI> res = new LinkedList<CountryI>();
		
		return res;
	}

	@Override
	public boolean isNeighbour(CountryI v, CountryI w) {
		return getNeighbouringCountryList(v).contains(w);
	}

	public Map<Country, LinkedList<Country>> getWorld() {
		return world;
	}

	public void setWorld(Map<Country, LinkedList<Country>> world) {
		this.world = world;
	}
}