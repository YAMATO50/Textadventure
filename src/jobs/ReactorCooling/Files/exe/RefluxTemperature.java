package jobs.ReactorCooling.Files.exe;

import adventure.text.TextTools;
import jobs.ReactorCooling.Parameters;
import jobs.ReactorCooling.RefluxTemperatureReader;
import jobs.ReactorCooling.Tick;
import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class RefluxTemperature implements DOSProgrammInterface {

	public void execute() {
		System.out.println();
		System.out.print("Berechne");
		TextTools.dddln();
		boolean stay = true;
		while (stay) {
			Parameters.showStates();
			System.out.println("Was mˆchtest du tun?");
			System.out.println("[1] Durchflussanteil durch die Sublimationsk¸hlung ‰ndern");
			System.out.println("[2] Heizleistung des R¸ckwassers in der Kuppel ‰ndern");
			System.out.println("[3] Exit");
			System.out.println();
			
			int choice;
			do {
				choice = Parameters.getUserInput();
			} while (choice == -1);
			
			switch (choice) {
			case 1:
				System.out.println("Aktuelle flieﬂen " + Parameters.refluxSublimationRate + "% des Rpckwassers durch die Sublimationsk¸hlung");
				System.out.println();
				System.out.println("Durchflussanteil durch die Sublimationsk¸hlung...");
				System.out.println("[1] Erhˆhen");
				System.out.println("[2] Verringern");
				System.out.println();
				
				do {
					choice = Parameters.getUserInput();
				} while (choice == -1);
				
				if (choice == 1) {
					
					System.out.println();
					System.out.println("Um wieviele 5% schritte mˆchtest du den Anteil erhˆhen?");
					System.out.println("Verf¸gbare schritte: " + (100 - Parameters.refluxSublimationRate) / 5);
					
					do {
						choice = Parameters.getUserInput();
					} while (choice == -1);
					
					if (choice > (100 - Parameters.refluxSublimationRate) / 5) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						Parameters.refluxSublimationRate = Parameters.refluxSublimationRate + choice * 5;
						RefluxTemperatureReader.temperature = RefluxTemperatureReader.temperature - choice * 5;
					}
					
				} else if (choice == 2) {
					System.out.println();
					System.out.println("Um wieviele 5% schritte mˆchtest du den Anteil verringern?");
					System.out.println("Verf¸gbare schritte: " + Parameters.refluxSublimationRate / 5);
					
					do {
						choice = Parameters.getUserInput();
					} while (choice == -1);
					
					if (choice > Parameters.refluxSublimationRate / 5) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						Parameters.refluxSublimationRate = Parameters.refluxSublimationRate - choice * 5;
						RefluxTemperatureReader.temperature = RefluxTemperatureReader.temperature + choice * 5;
					}
				} else {
					System.out.println("Bitte gib eine G¸ltige zahl ein!");
				}
				
				break;
			case 2:
				System.out.println("Aktuelle Heizleistung des R¸ckwassers in der Kuppel: " + Parameters.refluxHeatPower + " MW");
				System.out.println();
				System.out.println("Heizleistung des R¸ckwassers in der Kuppel...");
				System.out.println("[1] Erhˆhen");
				System.out.println("[2] Verringern");
				System.out.println();
				
				do {
					choice = Parameters.getUserInput();
				} while (choice == -1);
				
				if (choice == 1) {
					
					System.out.println();
					System.out.println("Um wieviele 10 MW schritte mˆchtest du die Heizleistung erhˆhen?");
					System.out.println("Verf¸gbare schritte: " + (500 - Parameters.refluxHeatPower) / 10);
					
					do {
						choice = Parameters.getUserInput();
					} while (choice == -1);
					
					if (choice > (500 - Parameters.refluxHeatPower) / 10) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						Parameters.refluxHeatPower = Parameters.refluxHeatPower + choice * 10;
						RefluxTemperatureReader.temperature = RefluxTemperatureReader.temperature - choice * 5;
					}
					
				} else if (choice == 2) {
					System.out.println();
					System.out.println("Um wieviele 10 MW schritte mˆchtest du die Heizleistung verringern?");
					System.out.println("Verf¸gbare schritte: " + Parameters.refluxHeatPower / 10);
					
					do {
						choice = Parameters.getUserInput();
					} while (choice == -1);
					
					if (choice > Parameters.refluxHeatPower / 10) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						Parameters.refluxHeatPower = Parameters.refluxHeatPower - choice * 10;
						RefluxTemperatureReader.temperature = RefluxTemperatureReader.temperature + choice * 5;
					}
				} else {
					System.out.println("Bitte gib eine G¸ltige zahl ein!");
				}
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

}
