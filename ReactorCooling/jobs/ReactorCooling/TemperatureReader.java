package jobs.ReactorCooling;

import adventure.text.TextTools;

public class TemperatureReader {

	public static int temperature;
	
	public static void read() {
		TextTools.slowText("Lese widerstandssensoren aus",100);
		TextTools.dddln();
		TextTools.slowText("Rechne",100);
		TextTools.dddln();
		System.out.println();
		TextTools.slowTextln("Die aktuelle Kühlwassertemperatur beträgt " + temperature + "°C",100);
	}
	
}
