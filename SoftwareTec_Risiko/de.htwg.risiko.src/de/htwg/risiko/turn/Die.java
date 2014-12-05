package de.htwg.risiko.turn;

import java.util.Random;


public class Die {
	
	private static final int UPPER = 6;
	private Random rand;
	
	public Die() {
		rand = new Random();
	}
	
	private int die (Random r) {
		return r.nextInt(UPPER) + 1;
	}
	
	public void roll(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = die(rand);
		}
	}
	
	public Random getRandom() {
		return rand;
	}
	
	public void setRandom(Random r) {
		rand = r;
	}

}
