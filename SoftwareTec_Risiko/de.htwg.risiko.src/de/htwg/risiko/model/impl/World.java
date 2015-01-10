package de.htwg.risiko.model.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.WorldI;

public class World implements WorldI {
	private Map<CountryI, LinkedList<CountryI>> world;

	public World() {
		world = new HashMap<CountryI, LinkedList<CountryI>>();
	}

	@Override
	public void addCountry(CountryI v) {
		world.put((CountryI) v, new LinkedList<CountryI>());
	}

	@Override
	public void addEdge(CountryI v, CountryI w) {
		world.get(v).add((Country) w);
		world.get(w).add((Country) v);
	}

	@Override
	public List<CountryI> getNeighbouringCountryList(CountryI v) {
		List<CountryI> res = new LinkedList<CountryI>();
		for (CountryI w : world.get(v)) {
			res.add(w);
		}
		return res;
	}

	@Override
	public boolean isNeighbour(CountryI v, CountryI w) {
		return getNeighbouringCountryList(v).contains(w);
	}

	public Map<CountryI, LinkedList<CountryI>> getWorld() {
		return world;
	}

	public void setWorld(Map<CountryI, LinkedList<CountryI>> world) {
		this.world = world;
	}
}