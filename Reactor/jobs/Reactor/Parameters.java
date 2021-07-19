package jobs.Reactor;

import adventure.text.Config;
import adventure.text.TextAdventure;
import adventure.text.TextTools;

public class Parameters {

	public static void fuelRods() {
		
		boolean stay = true;
		while (stay) {
			showStates();
			
			System.out.println("Was möchtest du tun?");
			System.out.println("[1] Anzahl der Brennstäbe im Reaktor ändern");
			System.out.println("[2] Exit");
			System.out.println();
			
			int choice = getUserInput();
			
			switch (choice) {
			case 1:
				fuelRodControll();
				break;
			case 2:
				stay = false;
				break;
			default:
				System.out.println("Bitte gib eine gültige Zahl ein!");
			}
			Tick.tick();
		}
		
	}
	
	private static void fuelRodControll() {
		System.out.println("Aktuell befinden sich " + FuelRodReader.fuelRodAmount + " aktive Brennstäbe im Reaktor");
		System.out.println();
		System.out.println("Anzahl an aktiven Brennstäben im Reaktor...");
		System.out.println("[1] Erhöhen");
		System.out.println("[2] Verringern");
		System.out.println();
		
		int choice = getUserInput();
		
		switch (choice) {
		case 1:
			System.out.println();
			System.out.println("Wieviele Brennstäbe möchtest du hinzufügen?");
			System.out.println("Verfügbare anzahl: " + (10 - FuelRodReader.fuelRodAmount));
			System.out.println();
			
			choice = getUserInput();
				
			if (choice <= (10 - FuelRodReader.fuelRodAmount)) {
				FuelRodReader.fuelRodAmount = FuelRodReader.fuelRodAmount + choice;
			}
				
			if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			}
				
			if (choice > (10 - FuelRodReader.fuelRodAmount)) {
				System.out.println("Deine zahl ist zu groß");
			}
				
			break;
		case 2:
			System.out.println();
			System.out.println("Wieviele Brennstäbe möchtest du entfernen?");
			System.out.println("Verfügbare anzahl: " + (FuelRodReader.fuelRodAmount - 2));
			System.out.println();
			
			choice = getUserInput();
				
			if (choice <= (FuelRodReader.fuelRodAmount - 2)) {
				FuelRodReader.fuelRodAmount = FuelRodReader.fuelRodAmount - choice;
			}
				
			if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			}
				
			if (choice > (FuelRodReader.fuelRodAmount - 2)) {
				System.out.println("Deine zahl ist zu groß");
			}
			break;
		default:
			System.out.println("Bitte gib eine gültige Zahl ein!");
		}
	}

	public static void controllRods() {
		
		boolean stay = true;
		while (stay) {
			showStates();
			
			System.out.println("Was möchtest du tun?");
			System.out.println("[1] Tiefe der Kontrollstäbe im Reaktor ändern");
			System.out.println("[2] Exit");
			System.out.println();
			
			int choice = getUserInput();
			
			switch (choice) {
			case 1:
				controllRodControll();
				break;
			case 2:
				stay = false;
				break;
			default:
				System.out.println("Bitte gib eine gültige Zahl ein!");
			}
			Tick.tick();
		}
		
	}
	
	private static void controllRodControll() {
		System.out.println("Aktuell sind die Kontrollstäbe zu " + ControllRodDepthReader.controllRodDepth + "% in den Reaktor gefahren");
		System.out.println();
		System.out.println("Kontrollstäbe...");
		System.out.println("[1] Herausziehen");
		System.out.println("[2] Hereinfahren");
		System.out.println();
		
		int choice = getUserInput();
		
		switch (choice) {
		case 1:
			System.out.println();
			System.out.println("Um wieviel 1% Schritte möchtest du die Kontrollstäbe herausziehen?");
			System.out.println("Verfügbare anzahl: " + ControllRodDepthReader.controllRodDepth);
			System.out.println();
			
			choice = getUserInput();
				
			if (choice <= ControllRodDepthReader.controllRodDepth) {
				ControllRodDepthReader.controllRodDepth = ControllRodDepthReader.controllRodDepth - choice;
			}
				
			if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			}
				
			if (choice > ControllRodDepthReader.controllRodDepth) {
				System.out.println("Deine zahl ist zu groß");
			}
				
			break;
		case 2:
			System.out.println();
			System.out.println("Um wieviel 1% Schritte möchtest du die Kontrollstäbe hereinfahren?");
			System.out.println("Verfügbare anzahl: " + (100 - ControllRodDepthReader.controllRodDepth));
			System.out.println();
			
			choice = getUserInput();
				
			if (choice <= (100 - ControllRodDepthReader.controllRodDepth)) {
				ControllRodDepthReader.controllRodDepth = ControllRodDepthReader.controllRodDepth + choice;
			}
				
			if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			}
				
			if (choice > (100 - ControllRodDepthReader.controllRodDepth)) {
				System.out.println("Deine zahl ist zu groß");
			}
			break;
		default:
			System.out.println("Bitte gib eine gültige Zahl ein!");
		}
	}
	
	public static void temperature() {
		
		boolean stay = true;
		while (stay) {
			showStates();
			
			System.out.println("Was möchtest du tun?");
			System.out.println("[1] Reaktorkerntemperatur verändern");
			System.out.println("[2] Exit");
			System.out.println();
			
			int choice = getUserInput();
			
			switch (choice) {
			case 1:
				temperatureControll();
				break;
			case 2:
				stay = false;
				break;
			default:
				System.out.println("Bitte gib eine gültige Zahl ein!");
			}
			Tick.tick();
		}
		
	}
	
	private static void temperatureControll() {
		System.out.println("Aktuelle Reaktorkerntemperatur " + TemperatureReader.temperature + " °C");
		System.out.println();
		System.out.println("Reaktorkerntemperatur...");
		System.out.println("[1] Erhöhen");
		System.out.println("[2] Verringern");
		System.out.println();
		
		int choice = getUserInput();
		
		switch (choice) {
		case 1:
			System.out.println();
			System.out.println("Um wieviel °C möchtest du die Reaktorkerntemperatur erhöhen?");
			System.out.println("Verfügbare anzahl: " + (900 - TemperatureReader.temperature));
			System.out.println();
			
			choice = getUserInput();
				
			if (choice <= (900 - TemperatureReader.temperature)) {
				TemperatureReader.temperature = TemperatureReader.temperature + choice;
			}
				
			if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			}
				
			if (choice > (900 - TemperatureReader.temperature)) {
				System.out.println("Deine zahl ist zu groß");
			}
				
			break;
		case 2:
			System.out.println();
			System.out.println("Um wieviel °C möchtest du die Reaktorkerntemperatur verringern?");
			System.out.println("Verfügbare anzahl: " + (TemperatureReader.temperature - 200));
			System.out.println();
			
			choice = getUserInput();
				
			if (choice <= (TemperatureReader.temperature - 200)) {
				TemperatureReader.temperature = TemperatureReader.temperature - choice;
			}
				
			if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			}
				
			if (choice > (TemperatureReader.temperature - 200)) {
				System.out.println("Deine zahl ist zu groß");
			}
			break;
		default:
			System.out.println("Bitte gib eine gültige Zahl ein!");
		}
	}
	
	public static int getUserInput() {
		int number = -1;
		
			do {
			String input = Config.keyScan.nextLine();
			try {
				number = Integer.valueOf(input);
			} catch (NumberFormatException e) {
				System.out.println("\"" + input + "\" ist keine Zahl! Bitte gebe eine Zahl ein!");
			}
		} while (number == -1);
			
		return number;
	}
	
	private static void showStates() {
		System.out.println();
		System.out.print("Berechne");
		TextTools.dddln();
		System.out.println();
		System.out.print("Aktuelle Werte:");
		System.out.println();
		TextAdventure.wait(100);
		System.out.println("Brennstabsanzahl: " + FuelRodReader.fuelRodAmount);
		TextAdventure.wait(100);
		System.out.println("Kontrollstabstiefe: " + ControllRodDepthReader.controllRodDepth + "%");
		TextAdventure.wait(100);
		System.out.println("Reaktorkerntemperatur: " + TemperatureReader.temperature + " °C");
		TextAdventure.wait(100);
		System.out.println("Reaktorleistung: " + PowerReader.power + " TW");
		TextAdventure.wait(100);
		System.out.println();
	}
	
}
