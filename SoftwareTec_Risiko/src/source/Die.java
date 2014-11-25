package source;

import java.util.Random;


public class Die {
	
	public Die() {
		rand = new Random();
	}
	
	private static final int UPPER = 6;
	private Random rand;
	
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
