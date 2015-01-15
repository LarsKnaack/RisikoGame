package de.htwg.risiko.model.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.htwg.risiko.model.ICountry;
import de.htwg.risiko.model.IWorld;

public class World implements IWorld {
	private Map<ICountry, LinkedList<ICountry>> world;

	public World() {
		world = new HashMap<ICountry, LinkedList<ICountry>>();
	}

	@Override
	public void addCountry(ICountry v) {
		world.put((ICountry) v, new LinkedList<ICountry>());
	}

	@Override
	public void addEdge(ICountry v, ICountry w) {
		world.get(v).add((Country) w);
		world.get(w).add((Country) v);
	}

	@Override
	public List<ICountry> getNeighbouringCountryList(ICountry v) {
		List<ICountry> res = new LinkedList<ICountry>();
		for (ICountry w : world.get(v)) {
			res.add(w);
		}
		return res;
	}

	@Override
	public boolean isNeighbour(ICountry v, ICountry w) {
		return getNeighbouringCountryList(v).contains(w);
	}

	public Map<ICountry, LinkedList<ICountry>> getWorld() {
		return world;
	}

	public void setWorld(Map<ICountry, LinkedList<ICountry>> world) {
		this.world = world;
	}
}