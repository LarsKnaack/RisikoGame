package de.htwg.risiko.model;
import static org.junit.Assert.*;

import java.awt.Color;
import java.util.LinkedList;

import junit.framework.TestCase;

import org.junit.Test;

import de.htwg.risiko.model.Country;
import de.htwg.risiko.model.Player;

public class PlayerTest extends TestCase {
	
	public void testGetName() {
		Player p = new Player("Player");
		assertEquals(p.getName(), "Player");
	}
	}
