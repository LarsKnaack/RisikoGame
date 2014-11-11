package test_source;
import static org.junit.Assert.*;

import java.awt.Color;

import junit.framework.TestCase;

import org.junit.Test;

import  source.Land;
import source.Spieler;

public class LandTest extends TestCase {
	
	public void testGetAnzahlEinheiten() {
		Land test = new Land("test");
		test.setEinheiten(5);
		assertTrue(test.getEinheiten() == 5);
	}
	
	public void testSetEinheiten() {
		Land test = new Land("test");
		test.setEinheiten(5);
		assertTrue(test.getEinheiten() == 5);
	}
	
	public void testGetBesatzer() {
		Land test = new Land("test");
		Spieler s3 = new Spieler("s3", Color.GREEN);
		test.setBesatzer(s3);
		assertTrue(test.getBesatzer() ==  s3);
	}
	
	public void testSetBesatzer() {
		Land test = new Land("test");
		Spieler s3 = new Spieler("s3", Color.GREEN);
		test.setBesatzer(s3);
		assertTrue(test.getBesatzer() == s3);
	}
	
	public void testSetAngreifer() {
		Land test = new Land("test");
		test.setAngreifer(true);
		assertTrue(test.istAngreifer());
		test.setAngreifer(false);
		assertFalse(test.istAngreifer());
	}
	
	public void testSetVerteidiger() {
		Land test = new Land("test");
		test.setVerteidiger(true);
		assertTrue(test.istVerteidiger());
		test.setVerteidiger(false);
		assertFalse(test.istVerteidiger());
	}
	
}
