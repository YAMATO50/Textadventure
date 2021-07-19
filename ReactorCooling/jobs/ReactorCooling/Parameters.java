package jobs.ReactorCooling;

import adventure.text.Config;
import adventure.text.TextAdventure;

public class Parameters {

	public static int sublimationRate;
	public static int solarRate;

	public static int pumpPower;
	
	public static int reservoirSublimationRate;
	public static int getRefluxWaterRate;
	
	public static int refluxSublimationRate;
	public static int refluxHeatPower;
	
	public static boolean succes;
	
	public static int getUserInput() {
		int number = -1;
		String input = Config.keyScan.nextLine();
		try {
			number = Integer.valueOf(input);
		} catch (NumberFormatException e) {
			System.out.println("\"" + input + "\" ist keine Zahl! Bitte gebe eine Zahl ein!");
		}
		return number;
	}
	
	public static void showStates() {
		System.out.println();
		System.out.print("Aktuelle Werte:");
		System.out.println();
		TextAdventure.wait(100);
		System.out.println("Durchfluss: " + FlowRateReader.flowRate + " L/s");
		TextAdventure.wait(100);
		System.out.println("Kühlwassertemperatur: " + TemperatureReader.temperature + " °C");
		TextAdventure.wait(100);
		System.out.println("Rückflusswassertemperatur: " + RefluxTemperatureReader.temperature + " °C");
		TextAdventure.wait(100);
		System.out.println("Reservoirfüllstand: " + ReservoirLevelReader.reservoirLevel + "%");
		TextAdventure.wait(100);
		System.out.println();
	}
	
}
