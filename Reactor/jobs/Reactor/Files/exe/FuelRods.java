package jobs.Reactor.Files.exe;

import jobs.Reactor.Parameters;
import jobs.Reactor.Tick;
import jobs.Reactor.Files.DOSProgrammInterface;

public class FuelRods implements DOSProgrammInterface {

	public FuelRods(int location) {
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
			
			System.out.println("Was m�chtest du tun?");
			System.out.println("[1] Anzahl der Brennst�be im Reaktor �ndern");
			System.out.println("[2] Exit");
			System.out.println();
			
			int choice = Parameters.getUserInput();
			
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
		System.out.println("Aktuell befinden sich " + Parameters.fuelRodAmount + " aktive Brennst�be im Reaktor");
		System.out.println();
		System.out.println("Anzahl an aktiven Brennst�ben im Reaktor...");
		System.out.println("[1] Erh�hen");
		System.out.println("[2] Verringern");
		System.out.println();
		
		int choice = Parameters.getUserInput();
		
		switch (choice) {
		case 1:
			System.out.println();
			System.out.println("Wieviele Brennst�be m�chtest du hinzuf�gen?");
			System.out.println("Verf�gbare anzahl: " + (10 - Parameters.fuelRodAmount));
			System.out.println();
			
			choice = Parameters.getUserInput();
				
			if (choice <= (10 - Parameters.fuelRodAmount)) {
				Parameters.fuelRodAmount = Parameters.fuelRodAmount + choice;
			}
				
			if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			}
				
			if (choice > (10 - Parameters.fuelRodAmount)) {
				System.out.println("Deine zahl ist zu gro�");
			}
				
			break;
		case 2:
			System.out.println();
			System.out.println("Wieviele Brennst�be m�chtest du entfernen?");
			System.out.println("Verf�gbare anzahl: " + (Parameters.fuelRodAmount - 2));
			System.out.println();
			
			choice = Parameters.getUserInput();
				
			if (choice <= (Parameters.fuelRodAmount - 2)) {
				Parameters.fuelRodAmount = Parameters.fuelRodAmount - choice;
			}
				
			if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			}
				
			if (choice > (Parameters.fuelRodAmount - 2)) {
				System.out.println("Deine zahl ist zu gro�");
			}
			break;
		default:
			System.out.println("Bitte gib eine g�ltige Zahl ein!");
		}
	}

	public String[] getContents() {
		return null;
	}

	public void setContents(String[] content) {

	}

}
