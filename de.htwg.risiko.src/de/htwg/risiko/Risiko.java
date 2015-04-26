package de.htwg.risiko;


import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.view.GUI;
import de.htwg.risiko.view.TextUI;

public final class Risiko {

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

		PropertyConfigurator.configure("log4j.properties");
		Injector injector = Guice.createInjector(new RisikoModule());
		controller = injector.getInstance(IGameEngine.class);
		@SuppressWarnings("unused")
		GUI gui = injector.getInstance(GUI.class);
		tui = injector.getInstance(TextUI.class);
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
			continu = tui.processInputLine(scanner.nextLine());
		}
	}
}
