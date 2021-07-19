package jobs.ReactorCooling.Files.exe;

import adventure.text.TextTools;
import jobs.ReactorCooling.Parameters;
import jobs.ReactorCooling.TemperatureReader;
import jobs.ReactorCooling.Tick;
import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class Temperature implements DOSProgrammInterface {

	public void execute() {

		System.out.println();
		System.out.print("Berechne");
		TextTools.dddln();
		boolean stay = true;
		while (stay) {
			Parameters.showStates();
			System.out.println("Was mˆchtest du tun?");
			System.out.println("[1] Durchflussanteil durch Sublimationsk¸hlung ‰ndern");
			System.out.println("[2] Durchflussanteil durch Solarzellen ‰ndern");
			System.out.println("[3] Exit");
			System.out.println();
			
			int choice;
			do {
				choice = Parameters.getUserInput();
			} while (choice == -1);
			
			switch (choice) {
			case 1:
				sublimation();
				break;
			case 2:
				solar();
				break;
			case 3:
				stay = false;
				break;
			default:
				System.out.println("Bitte gib eine G¸ltige zahl ein!");
			}
			Tick.tick();
		}
	}
	
	public static void sublimation() {
		System.out.println("aktuell flieﬂen " + Parameters.sublimationRate + "% des K¸hlwassers durch die Sublimationsk¸hlung");
		System.out.println();
		System.out.println("Durchflussanteile durch die Sublimationsk¸hlung...");
		System.out.println("[1] Erhˆhen");
		System.out.println("[2] Verringern");
		System.out.println();
		
		int choice;
		do {
			choice = Parameters.getUserInput();
		} while (choice == -1);
		
		if (choice == 1) {
			System.out.println();
			System.out.println("Um wieviele 5% schritte mˆchtest du den Anteil erhˆhen?");
			System.out.println("Verf¸gbare schritte: " + ((100 - Parameters.sublimationRate) / 5));
			
			do {
				choice = Parameters.getUserInput();
			} while (choice == -1);
			
			if (choice > (100 - Parameters.sublimationRate) / 5) {
				System.out.println("Deine zahl ist zu groﬂ!");
			} else if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			} else {
				Parameters.sublimationRate = Parameters.sublimationRate + (choice * 5);
				TemperatureReader.temperature = TemperatureReader.temperature - choice;
			}
			
		} else if (choice == 2) {
			System.out.println();
			System.out.println("Um wieviele 5% schritte mˆchtest du den Anteil verringern?");
			System.out.println("Verf¸gbare schritte: " + (Parameters.sublimationRate / 5));
			
			do {
				choice = Parameters.getUserInput();
			} while (choice == -1);
			
			if (choice > Parameters.sublimationRate / 5) {
				System.out.println("Deine zahl ist zu groﬂ!");
			} else if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			} else {
				Parameters.sublimationRate = Parameters.sublimationRate - (choice * 5);
				TemperatureReader.temperature = TemperatureReader.temperature + choice;
			}
		} else {
			System.out.println("Bitte gib eine g¸ltige Zahl ein!");
		}
	}
	
	public static void solar() {
		System.out.println("aktuell flieﬂen " + Parameters.solarRate + "% des K¸hlwassers durch die Solarzellen");
		System.out.println();
		System.out.println("Durchflussanteile durch die Solarzellen...");
		System.out.println("[1] Erhˆhen");
		System.out.println("[2] Verringern");
		System.out.println();
		
		int choice;
		do {
			choice = Parameters.getUserInput();
		} while (choice == -1);
		
		if (choice == 1) {
			System.out.println();
			System.out.println("Um wieviele 5% schritte mˆchtest du den Anteil erhˆhen?");
			System.out.println("Verf¸gbare schritte: " + ((100 - Parameters.solarRate) / 5));
			
			do {
				choice = Parameters.getUserInput();
			} while (choice == -1);
			
			if (choice > (100 - Parameters.solarRate) / 5) {
				System.out.println("Deine zahl ist zu groﬂ!");
			} else if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			} else {
				Parameters.solarRate = Parameters.solarRate + (choice * 5);
				TemperatureReader.temperature = TemperatureReader.temperature + choice * 4;
			}
		} else if (choice == 2) {
			System.out.println();
			System.out.println("Um wieviele 5% schritte mˆchtest du den Anteil verringern?");
			System.out.println("Verf¸gbare schritte: " +  Parameters.solarRate / 5);
			
			do {
				choice = Parameters.getUserInput();
			} while (choice == -1);
			
			if (choice > Parameters.solarRate / 5) {
				System.out.println("Deine zahl ist zu groﬂ!");
			} else if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			} else {
				Parameters.solarRate = Parameters.solarRate + (choice * 5);
				TemperatureReader.temperature = TemperatureReader.temperature - choice * 4;
			}
		} else {
			System.out.println("Bitte gib eine g¸ltige Zahl ein!");
		}
		
	}
}