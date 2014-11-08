package test_source;
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
		s.addLand(l1);
		s.addLand(l1);
		s.addLand(l1);
		s.addLand(l1);
		s.addLand(l1);
		s.addLand(l1);
		s.addLand(l1);
		s.addLand(l1);
		s.addLand(l1);
		s.setVerstaerkung();
		assertTrue(s.getVerstaerkung() == 4);
	}
	
	public void testGetName() {
		Spieler s = new Spieler("Hans", Color.BLACK);
		assertEquals("Hans", s.getName());
	}
	
	public void testAddEinheit() {
		Land l = new Land("l");
		Spieler s1 = new Spieler("s1", Color.BLACK);
		Spieler s2 = new Spieler("s2", Color.BLACK);
		s1.setVerstaerkung();
		assertEquals(s1.addEinheit(l, 4), -1);
		l.setBesatzer(s2);
		assertEquals(s1.addEinheit(l, 3), -1);
		l.setBesatzer(s1);
		assertEquals(s1.addEinheit(l, 3), 0);
		
		
	}
}
