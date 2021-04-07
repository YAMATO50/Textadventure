package jobs.Reactor;

import adventure.text.TextTools;

public class FlowRateReader {

	public static int flowRate;
	
	public static void read() {
		TextTools.slowText("Messe Wassergeschwindigkeit",100);
		TextTools.dddln();
		TextTools.slowText("Rechne",100);
		TextTools.dddln();
		System.out.println();
		TextTools.slowTextln("Der aktuelle Kühlwasserdurchfluss beträgt " + flowRate + " L/s",100);
	}
	
}
