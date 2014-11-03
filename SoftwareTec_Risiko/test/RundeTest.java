import static org.junit.Assert.*;

import java.awt.Color;

import junit.framework.TestCase;

import org.junit.Test;

import source.Spieler;
import source.Land;


public class RundeTest extends TestCase {

	public void testStarteVerstaerkung(){
		int phase = 0;
		Runde r1 = new Runde(0);
		Spieler s1 = new Spieler("s1", Color.BLACK);
		Land l = new Land("l");
		s1.setVerstaerkung();
		s1.addLand(l);
		s1.addEinheit(l, 3);
		assertEquals(r1.getPhase(), 1);
	}
	
	

}
