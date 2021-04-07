package jobs.Reactor;

import adventure.text.TextTools;

public class RefluxTemperatureReader {

	public static int temperature;
	
	public static void read() {
		TextTools.slowText("Lese widerstandssensoren aus",100);
		TextTools.dddln();
		TextTools.slowText("Rechne",100);
		TextTools.dddln();
		System.out.println();
		TextTools.slowTextln("Die aktuelle Rückwassertemperatur beträgt " + temperature + "°C",100);
	}
	
}
