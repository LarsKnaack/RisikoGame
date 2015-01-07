package de.htwg.risiko.turn;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.WorldI;

public class InvadeTurn implements TurnState{
	
	private PlayerI player;
	private PlayerI opponent;
	private CountryI invadingCountry;
	private CountryI defendingCountry;
	private WorldI world;
	
	int maxDefDice = 0;
	int maxInvDice = 0;
	
	private static final int MAX_RECRUITMENT = 3;
	private Die dice = new Die();
	
	
	@Override
	public void pull (Turn turn) {
		if (turn.hasFinished()) {
			turn.startTurn();
			turn.setState(new RecruitmentTurn());
			turn.initRecruitment();
			return;
		}
		player = turn.getPlayer();
		opponent = turn.getOpponent();
		invadingCountry = turn.getInvader();
		defendingCountry = turn.getDefender();
		world = turn.getWorld();
		if (winner().equals(invadingCountry)) {
			defendingCountry.setSoldiers(0);
			player.addCountry(defendingCountry);
			opponent.removeCountry(defendingCountry);
			invadingCountry.setSoldiers(invadingCountry.getSoldiers() - 1);
			defendingCountry.setSoldiers(1);
		}
	}

	void setMaxDice() {
		maxInvDice = MAX_RECRUITMENT;
		if(invadingCountry.getSoldiers() < MAX_RECRUITMENT) {
				maxInvDice = invadingCountry.getSoldiers();
			}			
		maxDefDice = 2;
		if(defendingCountry.getSoldiers() < 2) {
			maxDefDice = defendingCountry.getSoldiers();
		}
	}

	private void invade() {
		setMaxDice();
		if (maxInvDice < 2) {
			throw new IllegalArgumentException("Not enough Soldiers in Invader");
		}
		int[] invaderDice = new int[maxInvDice];
		int[] defenderDice = new int[maxDefDice];
		dice.roll(invaderDice);
		dice.roll(defenderDice);
/*<<<<<<< HEAD
=======
		if (maxInvDice < 2 || maxDefDice == 0) {
			throw new IllegalArgumentException("Not enough Soldiers");
		}
>>>>>>> branch 'master' of git@github.com:Team2Softwaretec/Risiko.git*/
		for (int i = 0; i < invaderDice.length; i++) {
			
			int a = max(invaderDice);
			int d = max(defenderDice);

			if (invaderDice[a] > defenderDice[d]) {
				defendingCountry.setSoldiers(defendingCountry.getSoldiers() - 1);
				if (defendingCountry.getSoldiers() == 0) {
					maxDefDice = 0;
					return;
				}
				maxDefDice--;
			} else {
                if (invadingCountry.getSoldiers() == 1) {
                    maxInvDice = 0;
                    return;
                }
				invadingCountry.setSoldiers(invadingCountry.getSoldiers() - 1);
				maxInvDice--;
			}
			invaderDice[a] = 0;
			defenderDice[d] = 0;
		}
	}
	
	public CountryI winner() {
		invade();
		if (maxDefDice <= 0) {
			return invadingCountry;
		} else {
			return defendingCountry;
		}
	}
	
	private int max(int[] a) {
		int max = a[0];
		int res = 0;
		for (int i = 0; i < a.length; i++){
			if (a[i] > max) {
				max = a[i];
				res = i;
			}
		}
		return res;
	}
	
	public void setDie(Die d) {
		dice = d;
	}
	
	public void setInvadingCountry(CountryI c) {
		if (!player.getCountries().contains(c)) {
			return;
		}
		invadingCountry = c;
	}
	public void setDefendingCountry(CountryI c) {
		if(invadingCountry == null) {
			return;
		}
		if (world.isNeighbour(c, invadingCountry)) {
			defendingCountry = c;
		}
	}
	
	public CountryI getInvadingCountry() {
		return invadingCountry;
	}
	
	public CountryI getDefendingCountry() {
		return defendingCountry;
	}
}
