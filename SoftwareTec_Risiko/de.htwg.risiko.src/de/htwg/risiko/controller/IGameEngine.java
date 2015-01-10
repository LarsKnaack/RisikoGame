package de.htwg.risiko.controller;

import java.util.List;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.WorldI;
import de.htwg.risiko.util.observer.IObservable;

public interface IGameEngine extends IObservable {

	void createMap(int i);

	void exit();

	void startGame();

	void changePlayer();

	void invade();

	void recruit();

	PlayerI getOwner(CountryI c);
	
	List<CountryI> getCountries(PlayerI p);

	List<CountryI> getCandidates(CountryI c);
	
	List<CountryI> getNeighbours(CountryI c);

	void endTurn();

	void setCurrentPlayer();

	int getSoldiers(CountryI c);

	boolean selectTarget(CountryI c);

	boolean selectAttacker(CountryI c);

	boolean selectRecruitment(CountryI c, int num);

	WorldI getWorld();

	PlayerI getCurrentPlayer();

	PlayerI getOpponent();

	String getStatus();
	
	int getMaxRecruitment();
	
	void moveSoldiers(int i, CountryI source, CountryI target);
}
