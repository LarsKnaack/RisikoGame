package test_source;
import static org.junit.Assert.*;
import java.awt.Color;
import junit.framework.TestCase;
import org.junit.Test;
import source.Spieler;
import source.Land;
import source.Runde;


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
	
	public void testStarteAngriff() {
		int phase = 1;
		Runde r1 = new Runde(1);
		Land ang = new Land("Angreifer");
		Land dev = new Land("Verteidiger");
		Spieler s1 = new Spieler("s1", Color.BLACK);
		Spieler s2 = new Spieler("s2", Color.BLUE);
		r1.setAngreifer(s1, ang);
		r1.setVerteidiger(s2, dev);
	}
	

}
