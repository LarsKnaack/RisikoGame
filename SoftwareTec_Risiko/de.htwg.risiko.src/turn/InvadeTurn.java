package turn;

import entities.Country;
import entities.Player;

public class InvadeTurn implements TurnState{
	
	@Override
	public void pull (Turn turn) {
		turn.setState(new RecruitmentTurn());	
	}

	private int maxDefDice = 0;
	private int maxInvDice = 0;
	
	private static final int MAX_RECRUITMENT = 3;

	private Die dice = new Die();
	
	public int setMaxDice(Country l) {
		if (l.isInvader()) {
			maxInvDice = MAX_RECRUITMENT;
			if(l.getSoldiers() < MAX_RECRUITMENT) {
				maxInvDice = l.getSoldiers();
			}
			return maxInvDice;
		} else {
			maxDefDice = 2;
			if(l.getSoldiers() < 2) {
				maxDefDice = l.getSoldiers();
			}
			return maxDefDice;
		}
	}
	
	public Player invadeTurn(Country inv, Country def) {
		setMaxDice(inv);
		setMaxDice(def);
		

		invade(inv, def);
		
		Player winner;
		if (maxInvDice == 1) {
			winner = def.getOccupying();
		} else {
			winner = inv.getOccupying();
		}
		return winner;
	}

	private void invade(Country invader, Country defender) {
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
