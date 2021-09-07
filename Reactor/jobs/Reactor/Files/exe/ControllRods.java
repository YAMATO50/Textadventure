package jobs.Reactor.Files.exe;

import jobs.Reactor.Parameters;
import jobs.Reactor.Tick;
import jobs.Reactor.Files.DOSProgrammInterface;

public class ControllRods implements DOSProgrammInterface {

	public ControllRods(int location) {
		this.location = location;
	}
	
	private int location;
	
	public int getLocation() {
		return this.location;
	}
	
	public void setLocation(int location) {
		this.location = location;
	}
	
	public void execute() {
		
		boolean stay = true;
		while (stay) {
			Parameters.showStates();
			
			System.out.println("Was möchtest du tun?");
			System.out.println("[1] Tiefe der Kontrollstäbe im Reaktor ändern");
			System.out.println("[2] Exit");
			System.out.println();
			
			int choice = Parameters.getUserInput();
			
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
		System.out.println("Aktuell sind die Kontrollstäbe zu " + Parameters.controllRodDepth + "% in den Reaktor gefahren");
		System.out.println();
		System.out.println("Kontrollstäbe...");
		System.out.println("[1] Herausziehen");
		System.out.println("[2] Hereinfahren");
		System.out.println();
		
		int choice = Parameters.getUserInput();
		
		switch (choice) {
		case 1:
			System.out.println();
			System.out.println("Um wieviel 1% Schritte möchtest du die Kontrollstäbe herausziehen?");
			System.out.println("Verfügbare anzahl: " + Parameters.controllRodDepth);
			System.out.println();
			
			choice = Parameters.getUserInput();
				
			if (choice <= Parameters.controllRodDepth) {
				Parameters.controllRodDepth = Parameters.controllRodDepth - choice;
			}
				
			if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			}
				
			if (choice > Parameters.controllRodDepth) {
				System.out.println("Deine zahl ist zu groß");
			}
				
			break;
		case 2:
			System.out.println();
			System.out.println("Um wieviel 1% Schritte möchtest du die Kontrollstäbe hereinfahren?");
			System.out.println("Verfügbare anzahl: " + (100 - Parameters.controllRodDepth));
			System.out.println();
			
			choice = Parameters.getUserInput();
				
			if (choice <= (100 - Parameters.controllRodDepth)) {
				Parameters.controllRodDepth = Parameters.controllRodDepth + choice;
			}
				
			if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			}
				
			if (choice > (100 - Parameters.controllRodDepth)) {
				System.out.println("Deine zahl ist zu groß");
			}
			break;
		default:
			System.out.println("Bitte gib eine gültige Zahl ein!");
		}
	}

	public String[] getContents() {
		return null;
	}

	public void setContents(String[] content) {

	}

}
