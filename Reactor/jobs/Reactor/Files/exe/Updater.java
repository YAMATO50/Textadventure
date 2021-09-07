package jobs.Reactor.Files.exe;

import jobs.Reactor.ContentFiller;
import jobs.Reactor.DOS;
import jobs.Reactor.Parameters;
import jobs.Reactor.PowerReader;
import jobs.Reactor.Files.DOSProgrammInterface;

public class Updater implements DOSProgrammInterface {

	public Updater(int location) {
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
		int powerDiff;
		
		powerDiff = Math.abs(ContentFiller.targetPower - PowerReader.power);
		
		boolean power = false;
		
		if (powerDiff <= 1) {
			power = true;
		}
		
		int choice = 0;
		
		if (power) {
			System.out.println();
			System.out.println("Die Reaktorleistung stimmt mit dem Stromverbrauch der Kuppel überein");
			System.out.println("Möchtest du den Reaktor Updaten?");
			System.out.println();
			System.out.println("[1] Ja");
			System.out.println("[2] Nein");
			System.out.println();
			
			do {
				choice = Parameters.getUserInput();
				
				switch (choice) {
				case 1:
					DOS.loop = false;
					Parameters.succes = true;
					break;
				case 2:
					break;
				default:
					System.out.println("Bitte gib eine gültige zahl ein!");
					choice = -1;
				}
				
			} while (choice == -1);
			
			
		} else {
			
			System.out.println();
			System.out.println("Die Reaktorleistung stimmt noch nicht mit dem Stromverbrauch der Kuppel überien!");
			System.out.println("Möchtest du trotzdem den Reaktor Updaten?");
			System.out.println();
			System.out.println("[1] Ja");
			System.out.println("[2] Nein");
			System.out.println();
			
			do {
				choice = Parameters.getUserInput();
				
				switch (choice) {
				case 1:
					DOS.loop = false;
					Parameters.succes = false;
					break;
				case 2:
					break;
				default:
					System.out.println("Bitte gib eine gültige zahl ein!");
					choice = -1;
				}
				
			} while (choice == -1);
		}
	}

	public String[] getContents() {
		return null;
	}

	public void setContents(String[] content) {

	}

}
