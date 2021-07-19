package jobs.ReactorCooling.Files.exe;

import adventure.text.TextTools;
import jobs.ReactorCooling.Parameters;
import jobs.ReactorCooling.ReservoirLevelReader;
import jobs.ReactorCooling.Tick;
import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class ReservoirLevel implements DOSProgrammInterface {

	public void execute() {
		System.out.println();
		System.out.print("Berechne");
		TextTools.dddln();
		boolean stay = true;
		while (stay) {
			Parameters.showStates();
			System.out.println("Was mˆchtest du tun?");
			System.out.println("[1] Abgabe des Wassers an die Sublimationsk¸hlung ‰ndern");
			System.out.println("[2] R¸ckgewinngungsgeschwindigkeit des R¸ckwassers ‰ndern");
			System.out.println("[3] Exit");
			System.out.println();
			
			int choice;
			do {
				choice = Parameters.getUserInput();
			} while (choice == -1);
			
			switch (choice) {
			case 1:
				System.out.println("Aktuelle werden " + Parameters.reservoirSublimationRate + "% an die Sublimationsk¸hlung abgegeben");
				System.out.println();
				System.out.println("Abgabe an die Sublimationsk¸hlung...");
				System.out.println("[1] Erhˆhen");
				System.out.println("[2] Verringern");
				System.out.println();
				
				do {
					choice = Parameters.getUserInput();
				} while (choice == -1);
				
				if (choice == 1) {
					
					System.out.println();
					System.out.println("Um wieviele 5% schritte mˆchtest du den Anteil erhˆhen?");
					System.out.println("Verf¸gbare schritte: " + (100 - Parameters.reservoirSublimationRate) / 5);
					
					do {
						choice = Parameters.getUserInput();
					} while (choice == -1);
					
					if (choice > (100 - Parameters.reservoirSublimationRate) / 5) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						Parameters.reservoirSublimationRate = Parameters.reservoirSublimationRate + choice * 5;
						ReservoirLevelReader.reservoirLevel = ReservoirLevelReader.reservoirLevel - choice * 5;
					}
					
				} else if (choice == 2) {
					System.out.println();
					System.out.println("Um wieviele 5% schritte mˆchtest du den Anteil verringern?");
					System.out.println("Verf¸gbare schritte: " + Parameters.reservoirSublimationRate / 5);
					
					do {
						choice = Parameters.getUserInput();
					} while (choice == -1);
					
					if (choice > Parameters.reservoirSublimationRate / 5) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						Parameters.reservoirSublimationRate = Parameters.reservoirSublimationRate - choice * 5;
						ReservoirLevelReader.reservoirLevel = ReservoirLevelReader.reservoirLevel + choice * 5;
					}
				} else {
					System.out.println("Bitte gib eine G¸ltige zahl ein!");
				}
				
				break;
			case 2:
				System.out.println("Aktuelle r¸ckgewinnungs geschwindigkeit: " + Parameters.getRefluxWaterRate + "%");
				System.out.println();
				System.out.println("R¸ckgewinnungsgeschwindigkeit...");
				System.out.println("[1] Erhˆhen");
				System.out.println("[2] Verringern");
				System.out.println();
				
				do {
					choice = Parameters.getUserInput();
				} while (choice == -1);
				
				if (choice == 1) {
					
					System.out.println();
					System.out.println("Um wieviele 5% schritte mˆchtest du die R¸ckgewinnungsgeschwindigkeit erhˆhen?");
					System.out.println("Verf¸gbare schritte: " + (200 - Parameters.getRefluxWaterRate) / 5);
					
					do {
						choice = Parameters.getUserInput();
					} while (choice == -1);
					
					if (choice > (200 - Parameters.getRefluxWaterRate) / 10) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						Parameters.getRefluxWaterRate = Parameters.getRefluxWaterRate + choice * 5;
						ReservoirLevelReader.reservoirLevel = ReservoirLevelReader.reservoirLevel + choice * 5;
					}
					
				} else if (choice == 2) {
					System.out.println();
					System.out.println("Um wieviele 5% schritte mˆchtest du die R¸ckgewinnungsgeschwindigkeit verringern?");
					System.out.println("Verf¸gbare schritte: " + Parameters.getRefluxWaterRate / 5);
					
					do {
						choice = Parameters.getUserInput();
					} while (choice == -1);
					
					if (choice > Parameters.getRefluxWaterRate / 5) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						Parameters.getRefluxWaterRate = Parameters.getRefluxWaterRate - choice * 5;
						ReservoirLevelReader.reservoirLevel = ReservoirLevelReader.reservoirLevel - choice * 5;
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
