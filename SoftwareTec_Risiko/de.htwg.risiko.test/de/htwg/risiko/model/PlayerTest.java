package de.htwg.risiko.model;
import static org.junit.Assert.*;

import java.awt.Color;
import java.util.LinkedList;

import junit.framework.TestCase;

import org.junit.Test;

import de.htwg.risiko.model.impl.Country;
import de.htwg.risiko.model.impl.Player;

public class PlayerTest extends TestCase {
	
	public void testGetName() {
		PlayerI p = new Player("Player");
		assertEquals(p.getName(), "Player");
	}
	}
