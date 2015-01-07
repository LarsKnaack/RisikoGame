package de.htwg.risiko;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.controller.impl.GameEngine;
import de.htwg.risiko.model.WorldI;
import de.htwg.risiko.view.TextUI;
import de.htwg.risiko.view.GUI;

public class Risiko {

	private static Scanner scanner;
	private static TextUI tui;
	private static GUI gui;
	private IGameEngine controller;
	private static Risiko instance = null;

	public static Risiko getInstance(int i) {
	if (instance == null) {
		instance = new Risiko(i);
	}
		return instance;
	}

	private Risiko(int i) {
		controller = new GameEngine();
		if (i == 1) {
			tui = new TextUI(controller);
			//controller.createMap(i);
			//tui.printTUI();
		} else {
			gui = new GUI(controller);
			controller.createMap(i);
		}
		
	}

	public IGameEngine getController() {
		return controller;
	}

	public TextUI getTUI() {
		 return tui;
	}

	public static void main(String[] args) {
		System.out.println("For TUI press 1 for GUI press 2");
		scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		Risiko.getInstance(i);
		
		if (tui != null) {
			boolean continu = true;
			while (continu) {
				continu = tui.processInputLine(scanner.next());
			}
		}
	}
}