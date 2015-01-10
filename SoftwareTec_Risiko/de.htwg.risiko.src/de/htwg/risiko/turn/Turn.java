package de.htwg.risiko.turn;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.WorldI;

public class Turn {
	
	private TurnState currentState;
	private String status;
	private PlayerI player;
	private PlayerI opponent;
	private WorldI world;
	private CountryI invader;
	private CountryI defender;
	private CountryI recCountry;
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
	
	public void setPlayer (PlayerI p, PlayerI o) {
		opponent = o;
		player = p;
	}

	public void switchPlayer(PlayerI p) {
		opponent = player;
		player = p;
	}

	public WorldI getWorld () {
		return world;
	}

	public void setWorld(WorldI w) {
		world = w;
	}
	
	public PlayerI getPlayer () {
		return player;
	}

	public PlayerI getOpponent() {
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

	public CountryI getDefender() {
		return defender;
	}

	public void setDefender(CountryI defender) {
		this.defender = defender;
	}

	public CountryI getInvader() {
		return invader;
	}

	public void setInvader(CountryI invader) {
		this.invader = invader;
	}

	public CountryI getRecCountry() {
		return recCountry;
	}

	public void setRecCountry(CountryI recCountry) {
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
