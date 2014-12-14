package de.htwg.risiko.turn;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;

public class InvadeTurn implements TurnState{
	
	private PlayerI current;
	private CountryI invadingCountry = Turn.getInvader();
	private CountryI defendingCountry = Turn.getDefender();
	
	int maxDefDice = 0;
	int maxInvDice = 0;
	
	private static final int MAX_RECRUITMENT = 3;
	private Die dice = new Die();
	
	public InvadeTurn(PlayerI p) {
		current = p;
	}
	
	@Override
	public void pull (Turn turn) {
		
		turn.setState(new RecruitmentTurn(current));
	}

	void setMaxDice() {
		maxInvDice = MAX_RECRUITMENT;
		if(invadingCountry.getSoldiers() < MAX_RECRUITMENT) {
				maxInvDice = invadingCountry.getSoldiers();
			}			
		maxDefDice = 2;
		if(defendingCountry.getSoldiers() < 2) {
			maxDefDice = 1;
		}
	}

	private void invade() {
		setMaxDice();
		int[] invaderDice = new int[maxInvDice];
		int[] defenderDice = new int[maxDefDice];
		dice.roll(invaderDice);
		dice.roll(defenderDice);
		for (int i = 0; i < invaderDice.length; i++) {
			
			int a = max(invaderDice);
			int d = max(defenderDice);

			if (invaderDice[a] > defenderDice[d]) {
				defendingCountry.setSoldiers(defendingCountry.getSoldiers() - 1);
				maxDefDice--;
			} else {
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
		if (!current.getCountries().contains(c)) {
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
