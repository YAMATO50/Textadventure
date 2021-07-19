package jobs.ReactorCooling.Files.txt;

import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class FlowrateInfoText implements DOSProgrammInterface {

	private String[] content = new String[] {
			"Der Durchfluss ist die menge an Wasser, die vom Reservoir zum Reaktor geleitet wird",
			"",
			"Die leistung der Pumpen regulieren den Durchfluss",
			"",
			"�nderung der Pumpenleistung:\t\t+ 10 GW (= Minimale Schrittweite)",
			"Resultierende Durchfluss�nderung:\t+ 10 L/s",
			"",
			"�nderung der Pumpenleistung:\t\t- 10 GW (= Minimale Schrittweite)",
			"Resultierende Durchfluss�nderung:\t- 10 L/s",
			"",
			"Maximale Pumpleistung: 300 GW pro Pumpe",
			"",
			"Beeinflusst durch �nderung:",
			"",
			"Reservoirstand",
			"R�ckwassertemperatur"};

	public void execute() {

		for (int i = 0; i < this.content.length; i++) {
			System.out.println(this.content[i] + "\n");
		}
		
	}

}
