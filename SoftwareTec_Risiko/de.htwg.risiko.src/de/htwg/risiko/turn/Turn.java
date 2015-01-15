package de.htwg.risiko.turn;

import de.htwg.risiko.model.ICountry;
import de.htwg.risiko.model.IPlayer;
import de.htwg.risiko.model.IWorld;

public class Turn {
	
	private TurnState currentState;
	private String status;
	private IPlayer player;
	private IPlayer opponent;
	private IWorld world;
	private ICountry invader;
	private ICountry defender;
	private ICountry recCountry;
	private int recruitment;
	private int maxRecruitment;
	private boolean end;
	private static final int MAX = 3;
	
	public Turn() {
		currentState = new StartTurn();
	}

	public void endTurn() {
		end = true;
	}

	public void startTurn() {
		end = false;
	}

	public boolean hasFinished() {
		return end;
	}
	
	public void setPlayer (IPlayer p, IPlayer o) {
		opponent = o;
		player = p;
	}

	public void switchPlayer(IPlayer p) {
		opponent = player;
		player = p;
	}

	public IWorld getWorld () {
		return world;
	}

	public void setWorld(IWorld w) {
		world = w;
	}
	
	public IPlayer getPlayer () {
		return player;
	}

	public IPlayer getOpponent() {
		return opponent;
	}

	public void setState(TurnState s) {
		currentState = s;
	}
	
	public TurnState getState() {
		return currentState;
	}
	
	public void pull () {
		currentState.pull(this);
	}

	public ICountry getDefender() {
		return defender;
	}

	public void setDefender(ICountry defender) {
		this.defender = defender;
	}

	public ICountry getInvader() {
		return invader;
	}

	public void setInvader(ICountry invader) {
		this.invader = invader;
	}

	public ICountry getRecCountry() {
		return recCountry;
	}

	public void setRecCountry(ICountry recCountry) {
		this.recCountry = recCountry;
	}

	public int getRecruitment() {
		return recruitment;
	}

	public void setRecruitment(int recruitment) {
		this.recruitment = recruitment;
	}

	public void initRecruitment() {
		maxRecruitment = player.getCountries().size() / MAX;
		if(maxRecruitment < MAX) {
			maxRecruitment = MAX;
		}
	}

	public int getMaxRecruitment() {
		return maxRecruitment;
	}

	public void setMaxRecruitment(int maxRecruitment) {
		this.maxRecruitment = maxRecruitment;
	}

	public void setStatus(String s) {
		status = "\n" + s;
	}

	public String getStatus() {
		return status;
	}
}
