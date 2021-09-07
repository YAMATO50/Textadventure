package jobs.Reactor;

public class UpdaterOld {
	
	public static boolean succes;
	
	public static void update() {
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
					succes = true;
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
					succes = false;
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
	
}
