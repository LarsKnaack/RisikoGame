package de.htwg.risiko.controller;

import java.awt.Point;
import java.util.List;

import de.htwg.risiko.model.ICountry;
import de.htwg.risiko.model.IPlayer;
import de.htwg.risiko.model.IWorld;
import de.htwg.risiko.util.observer.IObservable;

/**
 * The interface IGameEngine is implemented by GameEngine and contains the business logic of the game
 * @author Lars Knaack, Heiko Ettwein
 *
 */
public interface IGameEngine extends IObservable {

	/**
	 * Creates a new Graph, which contains all countries and their connections of the gamefield
	 */
	void createMap();

	/**
	 * set all private variables and create a new Turn
	 */
	void startGame();

	/**
	 * changes the players (current player and opponent)
	 */
	void changePlayer();

	/**
	 * calls the "pull" method in InvadeTurn in order to invade a country
	 */
	void invade();

	/**
	 * calls the "pull" method in RecruitmentTurn in order to add soldiers to a country
	 */
	void recruit();

	/**
	 * checks if the private List of countries of player1 contains the country 
	 * @param c country to check
	 * @return player1, if List contains c, else player2
	 */
	IPlayer getOwner(ICountry c);
	
	/**
	 * calls the getCountries method in PlayerI
	 * @param p player, whose countries to return
	 * @return a List of country Interfaces
	 * @see IPlayer
	 */
	List<ICountry> getCountries(IPlayer p);

	/**
	 * checks for a country, if its neighbours' owner is the same and adds the neighbour, if not
	 * @param c country to check
	 * @return a list of countries, whose owner doesn't equal getOwner(c)
	 */
	List<ICountry> getCandidates(ICountry c);
	
	/**
	 * checks for a country, if it's neigbours' owner is the same and adds the neigbour, if it is
	 * @param c country to check
	 * @return a list of friendly countries
	 */
	List<ICountry> getNeighbours(ICountry c);

	/**
	 * ends the InvadeTurn and pulls to RecruitmentTurn
	 */
	void endTurn();

	/**
	 * sets the current Player, stored in a private Variable
	 */
	void setCurrentPlayer();

	/**
	 * calls the getSoldiers method in CountryI
	 * @param c country to check
	 * @return number of soldiers
	 */
	int getSoldiers(ICountry c);
	
	/**
	 * checks if country c is a country of the current player and if it contains more than one soldier
	 * @param c country to check
	 * @return true if conditions are fulfilled, private variable "attacker" is set to c
	 */
	boolean selectAttacker(ICountry c);

	
	/**
	 * checks if candidates of attacker contains c
	 * @param c country to check
	 * @return true if c is candidate of attacker
	 */
	boolean selectTarget(ICountry c);

	/**
	 * sets the recruitment and the country to recruit in Turn
	 * @param c country to check
	 * @param num number of soldiers to recruit (greater than 0, less than maxRecruitment)
	 * @return true if c's owner is current player
	 */
	boolean selectRecruitment(ICountry c, int num);

	/**
	 * @return Graph of all countries and their connections
	 */
	IWorld getWorld();

	/**
	 * get the current Player, stored in a private Variable
	 * @return current Player
	 */
	IPlayer getCurrentPlayer();

	/**
	 * get the opponent Player, stored in a private variable
	 * @return opponent Player
	 */
	IPlayer getOpponent();

	/**
	 * get the statusline of the game
	 * @return String of statusline
	 */
	String getStatus();
	
	/**
	 * calls getMaxRecruitment in Turn
	 * @return number of the maximal Recruitment available
	 */
	int getMaxRecruitment();
	
	
	/**
	 * moves soldiers from one country to another if they are connected and they both have the same owner
	 * @param i soldiers to move (less than soldiers of source)
	 * @param source country, which provides the soldiers
	 * @param target country, which gets the soldiers
	 */
	void moveSoldiers(int i, ICountry source, ICountry target);

	/**
	 * check if a Point on the gamefield is in a certain distance to the countries set on the gamefield
	 * @param p point to check
	 * @return CountryI, if p is in distance
	 */
	ICountry check(Point p);
}
