package de.htwg.risiko.turn;

import de.htwg.risiko.model.Country;

public class InvadeTurn implements TurnState{
	
	Country invader;
	Country defender;
	
	int maxDefDice = 0;
	int maxInvDice = 0;
	
	private static final int MAX_RECRUITMENT = 3;
	private Die dice = new Die();
	
	public InvadeTurn(Country inv, Country def) {
		invader = inv;
		defender = def;
	}
	
	@Override
	public void pull (Turn turn) {
		
		turn.setState(new RecruitmentTurn());	
		handle();
	}

	void setMaxDice() {
		maxInvDice = MAX_RECRUITMENT;
		if(invader.getSoldiers() < MAX_RECRUITMENT) {
				maxInvDice = invader.getSoldiers();
			}			
		maxDefDice = 2;
		if(defender.getSoldiers() < 2) {
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
				defender.setSoldiers(defender.getSoldiers() - 1);
				maxDefDice--;
			} else {
				invader.setSoldiers(invader.getSoldiers() - 1);
				maxInvDice--;
			}
			invaderDice[a] = 0;
			defenderDice[d] = 0;
		}
	}
	
	Country handle() {
		invade();
		if (maxDefDice <= 0) {
			return invader;
		} else {
			return defender;
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
}
