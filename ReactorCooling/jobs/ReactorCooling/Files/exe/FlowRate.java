package jobs.ReactorCooling.Files.exe;

import adventure.text.TextTools;
import jobs.ReactorCooling.Parameters;
import jobs.ReactorCooling.FlowRateReader;
import jobs.ReactorCooling.Tick;
import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class FlowRate implements DOSProgrammInterface {

	public void execute() {
		System.out.println();
		System.out.print("Berechne");
		TextTools.dddln();
		boolean stay = true;
		while (stay) {
			Parameters.showStates();
			System.out.println("Was mˆchtest du tun?");
			System.out.println("[1] Pumpleistung der K¸hlwasserpumpen ƒndern");
			System.out.println("[2] Exit");
			System.out.println();
			
			int choice;
			do {
				choice = Parameters.getUserInput();
			} while (choice == -1);
			
			switch (choice) {
			case 1:
				System.out.println("Aktuelle Gesammtpumpleistung: " + Parameters.pumpPower + " GW");
				System.out.println();
				System.out.println("Gesammtpumpleistung...");
				System.out.println("[1] Erhˆhen");
				System.out.println("[2] Verringern");
				System.out.println();
				
				do {
					choice = Parameters.getUserInput();
				} while (choice == -1);
				
				if (choice == 1) {
					
					System.out.println();
					System.out.println("Um wieviele 10 GW schritte mˆchtest du die Leistung erhˆhen?");
					System.out.println("Verf¸gbare schritte: " + (15000 - Parameters.pumpPower) / 10);
					
					do {
						choice = Parameters.getUserInput();
					} while (choice == -1);
					
					if (choice > (15000 - Parameters.pumpPower) / 10) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						Parameters.pumpPower = Parameters.pumpPower + choice * 10;
						FlowRateReader.flowRate = FlowRateReader.flowRate + choice * 10;
					}
					
				} else if (choice == 2) {
					System.out.println();
					System.out.println("Um wieviele 10 GW schritte mˆchtest du die Leistung verringern?");
					System.out.println("Verf¸gbare schritte: " + Parameters.pumpPower / 10);
					
					do {
						choice = Parameters.getUserInput();
					} while (choice == -1);
					
					if (choice > Parameters.pumpPower / 10) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						Parameters.pumpPower = Parameters.pumpPower - choice * 10;
						FlowRateReader.flowRate = FlowRateReader.flowRate - choice * 10;
					}
				} else {
					System.out.println("Bitte gib eine G¸ltige zahl ein!");
				}
				
				break;
			case 2:
				stay = false;
				break;
			default:
				System.out.println("Bitte gib eine G¸ltige zahl ein!");
			}
			Tick.tick();
		}
	}
	
	public String[] getContents() {
		return null;
	}

	public void setContents(String[] content) {
		
	}

}
