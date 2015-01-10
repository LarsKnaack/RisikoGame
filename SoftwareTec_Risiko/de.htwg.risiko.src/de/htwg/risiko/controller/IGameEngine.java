package de.htwg.risiko.controller;

import java.util.List;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.WorldI;
import de.htwg.risiko.util.observer.IObservable;

public interface IGameEngine extends IObservable {

	public void createMap(int i);

	public void exit();

	public void startGame();

	public void changePlayer();

	public void invade();

	public void recruit();

	public PlayerI getOwner(CountryI c);
	
	public List<CountryI> getCountries(PlayerI p);

	public List<CountryI> getCandidates(CountryI c);
	
	public List<CountryI> getNeighbours(CountryI c);

	public void endTurn();

	public void setCurrentPlayer();

	public int getSoldiers(CountryI c);

	public boolean selectTarget(CountryI c);

	public boolean selectAttacker(CountryI c);

	public boolean selectRecruitment(CountryI c, int num);

	public WorldI getWorld();

	public PlayerI getCurrentPlayer();

	public PlayerI getOpponent();

	public String getStatus();
	
	public int getMaxRecruitment();
	
	public void moveSoldiers(int i, CountryI source, CountryI target);
}
