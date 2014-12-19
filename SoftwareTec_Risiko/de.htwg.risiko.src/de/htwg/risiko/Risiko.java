package de.htwg.risiko;

import java.util.Scanner;

import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.controller.impl.GameEngine;
import de.htwg.risiko.view.TextUI;

public class Risiko {

	private static Scanner scanner;
	private static TextUI tui;
	private IGameEngine controller;
	private static Risiko instance = null;

	public static Risiko getInstance() {
	if (instance == null) {
		instance = new Risiko();
	}
		return instance;
	}

	private Risiko() {
		controller = new GameEngine();
		tui = new TextUI(controller);
		controller.createMap();
		tui.printTUI();
	}

	public IGameEngine getController() {
		return controller;
	}

	public TextUI getTUI() {
		 return tui;
	}

	public static void main(String[] args) {
		Risiko.getInstance();
		boolean continu = true;
		scanner = new Scanner(System.in);
		while (continu) {
			continu = tui.processInputLine(scanner.next());
		}
	}
}