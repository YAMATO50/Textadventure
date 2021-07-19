package jobs.ReactorCooling.Files.txt;

import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class ReservoirInfoText implements DOSProgrammInterface {

	private String[] content = new String[] {
			"Das Reservoir beinhaltet eine große menge an Wasser die zum Kühlen verwendet wird",
			"",
			"Der Füllstand wird reguliert durch abgeben von Wasser an die Sublimationskühlanlage und durch",
			"schnelleres erhalten von Rückwasser",
			"",
			"Änderung der Wasseranteile in die Sublimationskühlung:\t+ 5% (= Minimale Schrittweite)",
			"Resultierende Reservoirfüllstandsänderung:\t\t- 5%",
			"",
			"Änderung der Wasseranteile in die Sublimationskühlung:\t- 5% (= Minimale Schrittweite)",
			"Resultierende Reservoirfüllstandsänderung:\t\t+ 5%",
			"",
			"",
			"Änderung der geschwindigkeit des Rückwassererhalts:\t+ 5% (= Minimale Schrittweite)",
			"Resultierende Reservoirfüllstandsänderung:\t\t+ 5%",
			"",
			"Änderung der geschwindigkeit des Rückwassererhalts:\t- 5% (= Minimale Schrittweite)",
			"Resultierende Reservoirfüllstandsänderung:\t\t- 5%",
			"",
			"Beeinflusst durch änderung:",
			"",
			"Kühlwassertemperatur"};
	
	public void execute() {
		
		for (int i = 0; i < this.content.length; i++) {
			System.out.println(this.content[i]);
		}
		
	}

	public String[] getContents() {
		return content;
	}

	public void setContents(String[] content) {
		this.content = content;
	}
	
}
