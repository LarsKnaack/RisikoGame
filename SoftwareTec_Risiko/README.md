# Risiko

## 1. Purpose of the project
* Develop a game for the lecture "Software Engineering" at HTWG Konstanz

## 2. The client, the customer and other stakeholders
* Free to use
* Prof. Dr. Marco Boger

## 3. Users of the product
* Free to use for everyone

## 4. Mandated Constraints
* Requires java
* Tested on Windows, but should run on every system

## 5. Naming Conventions and Definitions
* Interfaces begin with "I"
* implementation of Interfaces in subpackage "impl" 

## 6. Relevant Facts and Assumptions
* - 
## 7. The Scope of the Work
* Presentation and documentation of the product

## 8. The Scope of the Product
* Multiplayer
* Countries are assigned randomly to the players at the beginning of a game
* 

## 9. Functional and Data Requirements
* - 
## 10. Look and Feel Requirements
* - 
## 11. Usability and Humanity Requirements
* GUI to play the game

## 12. Performance Requirements
* -

## 13. Operational and Environmental Requirements
* -

## Structure of the game
* Risiko.java
	* Contains a method to call UI
* RisikoModule.java
	* Util class needed for guice
* package model
    * CountryI
        * Contains all attributes of a country (Name, number of Soldiers, Location)
        * Contains methods to get and set those attributes
    * PlayerI
        * Contains all attributes of a player (Name, owned countries)
        * Contains methods to get and set the name and countries owned
    * WorldI
        * Contains all attributes of the "game world"
        * Contains methods to edit the graph, which represents the "game world"
    * package impl
    	* Contains implementations of the interfaces
* package turn
	* Die
		* Represents a die
		* Contains methods to roll a die and to set the random
	* TurnState
		*
		*
	* Turn
		*
		*
	* StartTurn
		*
		*
	* InvadeTurn
		*
		*
	* RecruitmentTurn
		*
		*
* package util.observer
	* contains observer pattern
* package controller
	* IGameEngine
		* Contains various methods for UI to interact with "model" and "turn" package
	* package impl
		* GameEngine
			* Implementation of "IGameEngine"
		* RiskMap
			* Util class to create a new gamefield
	* package logwrapper
		* GameEngine
			* a fake implementation of IGameEngine needed for logging
* package view
	* GUI
		* Contains main Frame and the main Panel, which contains "ControlPanel", "Statistics" and "Status"
		* Contains a method to update "Statistics" and "Status"
		* Calls StartDialog
	* StartDialog
		* Dialog to set names of both Players
	* ControlPanel
		* Provides interaction of user and program
		* calls "AttackDialog", "MoveDialog" and "RecruitmentDialog"
	* AttackDialog
		* provides the possibility to select a country to attack
	* MoveDialog
		* provides the possibility to move soldiers from one country to another
	* RecruitmentDialog
		* provides the possibility to add soldiers to a country
	* Statistics
		* Contains a textArea, which shows both players with their countries
	* Status
		* shows the actual status of the game
	* TextUI
		*implementation of a logger