package jobs.Reactor;

import adventure.text.Config;
import adventure.text.TextAdventure;
import adventure.text.TextTools;

public class Parameters {

	public static void fuelRods() {
		
		boolean stay = true;
		while (stay) {
			showStates();
			
			System.out.println("Was m�chtest du tun?");
			System.out.println("[1] Anzahl der Brennst�be im Reaktor �ndern");
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
				System.out.println("Bitte gib eine g�ltige Zahl ein!");
			}
			Tick.tick();
		}
		
	}
	
	private static void fuelRodControll() {
		System.out.println("Aktuell befinden sich " + FuelRodReader.fuelRodAmount + " aktive Brennst�be im Reaktor");
		System.out.println();
		System.out.println("Anzahl an aktiven Brennst�ben im Reaktor...");
		System.out.println("[1] Erh�hen");
		System.out.println("[2] Verringern");
		System.out.println();
		
		int choice = getUserInput();
		
		switch (choice) {
		case 1:
			System.out.println();
			System.out.println("Wieviele Brennst�be m�chtest du hinzuf�gen?");
			System.out.println("Verf�gbare anzahl: " + (10 - FuelRodReader.fuelRodAmount));
			System.out.println();
			
			choice = getUserInput();
				
			if (choice <= (10 - FuelRodReader.fuelRodAmount)) {
				FuelRodReader.fuelRodAmount = FuelRodReader.fuelRodAmount + choice;
			}
				
			if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			}
				
			if (choice > (10 - FuelRodReader.fuelRodAmount)) {
				System.out.println("Deine zahl ist zu gro�");
			}
				
			break;
		case 2:
			System.out.println();
			System.out.println("Wieviele Brennst�be m�chtest du entfernen?");
			System.out.println("Verf�gbare anzahl: " + (FuelRodReader.fuelRodAmount - 2));
			System.out.println();
			
			choice = getUserInput();
				
			if (choice <= (FuelRodReader.fuelRodAmount - 2)) {
				FuelRodReader.fuelRodAmount = FuelRodReader.fuelRodAmount - choice;
			}
				
			if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			}
				
			if (choice > (FuelRodReader.fuelRodAmount - 2)) {
				System.out.println("Deine zahl ist zu gro�");
			}
			break;
		default:
			System.out.println("Bitte gib eine g�ltige Zahl ein!");
		}
	}

	public static void controllRods() {
		
		boolean stay = true;
		while (stay) {
			showStates();
			
			System.out.println("Was m�chtest du tun?");
			System.out.println("[1] Tiefe der Kontrollst�be im Reaktor �ndern");
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
				System.out.println("Bitte gib eine g�ltige Zahl ein!");
			}
			Tick.tick();
		}
		
	}
	
	private static void controllRodControll() {
		System.out.println("Aktuell sind die Kontrollst�be zu " + ControllRodDepthReader.controllRodDepth + "% in den Reaktor gefahren");
		System.out.println();
		System.out.println("Kontrollst�be...");
		System.out.println("[1] Herausziehen");
		System.out.println("[2] Hereinfahren");
		System.out.println();
		
		int choice = getUserInput();
		
		switch (choice) {
		case 1:
			System.out.println();
			System.out.println("Um wieviel 1% Schritte m�chtest du die Kontrollst�be herausziehen?");
			System.out.println("Verf�gbare anzahl: " + ControllRodDepthReader.controllRodDepth);
			System.out.println();
			
			choice = getUserInput();
				
			if (choice <= ControllRodDepthReader.controllRodDepth) {
				ControllRodDepthReader.controllRodDepth = ControllRodDepthReader.controllRodDepth - choice;
			}
				
			if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			}
				
			if (choice > ControllRodDepthReader.controllRodDepth) {
				System.out.println("Deine zahl ist zu gro�");
			}
				
			break;
		case 2:
			System.out.println();
			System.out.println("Um wieviel 1% Schritte m�chtest du die Kontrollst�be hereinfahren?");
			System.out.println("Verf�gbare anzahl: " + (100 - ControllRodDepthReader.controllRodDepth));
			System.out.println();
			
			choice = getUserInput();
				
			if (choice <= (100 - ControllRodDepthReader.controllRodDepth)) {
				ControllRodDepthReader.controllRodDepth = ControllRodDepthReader.controllRodDepth + choice;
			}
				
			if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			}
				
			if (choice > (100 - ControllRodDepthReader.controllRodDepth)) {
				System.out.println("Deine zahl ist zu gro�");
			}
			break;
		default:
			System.out.println("Bitte gib eine g�ltige Zahl ein!");
		}
	}
	
	public static void temperature() {
		
		boolean stay = true;
		while (stay) {
			showStates();
			
			System.out.println("Was m�chtest du tun?");
			System.out.println("[1] Reaktorkerntemperatur ver�ndern");
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
				System.out.println("Bitte gib eine g�ltige Zahl ein!");
			}
			Tick.tick();
		}
		
	}
	
	private static void temperatureControll() {
		System.out.println("Aktuelle Reaktorkerntemperatur " + TemperatureReader.temperature + " �C");
		System.out.println();
		System.out.println("Reaktorkerntemperatur...");
		System.out.println("[1] Erh�hen");
		System.out.println("[2] Verringern");
		System.out.println();
		
		int choice = getUserInput();
		
		switch (choice) {
		case 1:
			System.out.println();
			System.out.println("Um wieviel �C m�chtest du die Reaktorkerntemperatur erh�hen?");
			System.out.println("Verf�gbare anzahl: " + (900 - TemperatureReader.temperature));
			System.out.println();
			
			choice = getUserInput();
				
			if (choice <= (900 - TemperatureReader.temperature)) {
				TemperatureReader.temperature = TemperatureReader.temperature + choice;
			}
				
			if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			}
				
			if (choice > (900 - TemperatureReader.temperature)) {
				System.out.println("Deine zahl ist zu gro�");
			}
				
			break;
		case 2:
			System.out.println();
			System.out.println("Um wieviel �C m�chtest du die Reaktorkerntemperatur verringern?");
			System.out.println("Verf�gbare anzahl: " + (TemperatureReader.temperature - 200));
			System.out.println();
			
			choice = getUserInput();
				
			if (choice <= (TemperatureReader.temperature - 200)) {
				TemperatureReader.temperature = TemperatureReader.temperature - choice;
			}
				
			if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			}
				
			if (choice > (TemperatureReader.temperature - 200)) {
				System.out.println("Deine zahl ist zu gro�");
			}
			break;
		default:
			System.out.println("Bitte gib eine g�ltige Zahl ein!");
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
		System.out.println("Reaktorkerntemperatur: " + TemperatureReader.temperature + " �C");
		TextAdventure.wait(100);
		System.out.println("Reaktorleistung: " + PowerReader.power + " TW");
		TextAdventure.wait(100);
		System.out.println();
	}
	
}
