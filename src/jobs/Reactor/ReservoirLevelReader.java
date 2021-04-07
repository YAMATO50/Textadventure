package jobs.Reactor;

import adventure.text.TextTools;

public class ReservoirLevelReader {

	public static int reservoirLevel;
	
	public static void read() {
		TextTools.slowText("Lese Wasserstandssensoren aus",100);
		TextTools.dddln();
		TextTools.slowText("Rechne",100);
		TextTools.dddln();
		System.out.println();
		TextTools.slowTextln("Das Reservoir ist aktuell zu " + reservoirLevel + "% gefüllt",100);
	}
	
}
