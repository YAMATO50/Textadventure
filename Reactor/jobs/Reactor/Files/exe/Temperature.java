package jobs.Reactor.Files.exe;

import jobs.Reactor.Parameters;
import jobs.Reactor.TemperatureReader;
import jobs.Reactor.Tick;
import jobs.Reactor.Files.DOSProgrammInterface;

public class Temperature implements DOSProgrammInterface {

	public Temperature(int location) {
		this.location = location;
	}
	
	private int location;
	
	public int getLocation() {
		return this.location;
	}
	
	public void setLocation(int location) {
		this.location = location;
	}
	
	@Override
	public void execute() {
		
		boolean stay = true;
		while (stay) {
			Parameters.showStates();
			
			System.out.println("Was m�chtest du tun?");
			System.out.println("[1] Reaktorkerntemperatur ver�ndern");
			System.out.println("[2] Exit");
			System.out.println();
			
			int choice = Parameters.getUserInput();
			
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
		System.out.println("Aktuelle Reaktorkerntemperatur " + Parameters.temperature + " �C");
		System.out.println();
		System.out.println("Reaktorkerntemperatur...");
		System.out.println("[1] Erh�hen");
		System.out.println("[2] Verringern");
		System.out.println();
		
		int choice = Parameters.getUserInput();
		
		switch (choice) {
		case 1:
			System.out.println();
			System.out.println("Um wieviel �C m�chtest du die Reaktorkerntemperatur erh�hen?");
			System.out.println("Verf�gbare anzahl: " + (900 - Parameters.temperature));
			System.out.println();
			
			choice = Parameters.getUserInput();
				
			if (choice <= (900 - Parameters.temperature)) {
				Parameters.temperature = Parameters.temperature + choice;
			}
				
			if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			}
				
			if (choice > (900 - Parameters.temperature)) {
				System.out.println("Deine zahl ist zu gro�");
			}
				
			break;
		case 2:
			System.out.println();
			System.out.println("Um wieviel �C m�chtest du die Reaktorkerntemperatur verringern?");
			System.out.println("Verf�gbare anzahl: " + (Parameters.temperature - 200));
			System.out.println();
			
			choice = Parameters.getUserInput();
				
			if (choice <= (Parameters.temperature - 200)) {
				Parameters.temperature = Parameters.temperature - choice;
			}
				
			if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			}
				
			if (choice > (Parameters.temperature - 200)) {
				System.out.println("Deine zahl ist zu gro�");
			}
			break;
		default:
			System.out.println("Bitte gib eine g�ltige Zahl ein!");
		}
	}

	@Override
	public String[] getContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContents(String[] content) {
		// TODO Auto-generated method stub

	}

}
