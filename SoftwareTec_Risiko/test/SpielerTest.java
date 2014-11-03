import static org.junit.Assert.*;
import java.awt.Color;
import java.util.LinkedList;
import junit.framework.TestCase;
import org.junit.Test;
import source.Land;
import source.Spieler;

public class SpielerTest extends TestCase {
	
	public void testAddLand() {
		Land l = new Land("test");
		LinkedList<Land> test = new LinkedList();
		test.add(l);
		Spieler s = new Spieler ("s", Color.BLACK);
		s.addLand(l);
		assertTrue(test.equals(s.getLaender()));
	}
	
	public void testRemoveLand() {
		Land l = new Land("test");
		LinkedList<Land> test = new LinkedList();
		test.add(l);
		test.remove(l);
		Spieler s = new Spieler("s", Color.BLACK);
		s.addLand(l);
		s.removeLand(l);
		assertTrue(test.equals(s.getLaender()));
	}
	
	public void testSetVerstaerkung() {
		Spieler s = new Spieler ("s", Color.BLACK);
		Land l1 = new Land("L1");
		s.addLand(l1);
		s.setVerstaerkung();
		assertTrue(s.getVerstaerkung() == 3);
		s.addLand(l1);
		s.addLand(l1);
		s.setVerstaerkung();
		assertTrue(s.getVerstaerkung() == 3);
	}
	
	public static void main(final String[] args) {
		junit.textui.TestRunner.run(SpielerTest.class);
	}

}
