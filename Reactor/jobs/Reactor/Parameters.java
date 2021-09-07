package jobs.Reactor;

import adventure.text.Config;
import adventure.text.TextAdventure;
import adventure.text.TextTools;

public class Parameters {

	public static boolean succes;
	
	public static int fuelRodAmount;
	
	public static int controllRodDepth;
	
	public static int temperature;
	
	public static int power;
	
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
	
	public static void showStates() {
		System.out.println();
		System.out.print("Berechne");
		TextTools.dddln();
		System.out.println();
		System.out.print("Aktuelle Werte:");
		System.out.println();
		TextAdventure.wait(100);
		System.out.println("Brennstabsanzahl: " + fuelRodAmount);
		TextAdventure.wait(100);
		System.out.println("Kontrollstabstiefe: " + controllRodDepth + "%");
		TextAdventure.wait(100);
		System.out.println("Reaktorkerntemperatur: " + temperature + " °C");
		TextAdventure.wait(100);
		System.out.println("Reaktorleistung: " + power + " TW");
		TextAdventure.wait(100);
		System.out.println();
	}
	
}
