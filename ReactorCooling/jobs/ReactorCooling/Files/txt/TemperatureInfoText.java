package jobs.ReactorCooling.Files.txt;

import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class TemperatureInfoText implements DOSProgrammInterface {

	private String[] content = new String[] {
			"Die Kühlwassertemperatur ist die Temperatur die das Kühlwasser hat bevor es in den Reaktor geleitet wird",
			"",
			"Die Temperatur wird reguliert durch Sublimationskühlung und durch erwärmen mit Solarzellen",
			"",
			"Änderung des durchflussanteils durch die Sublimationskühlung:\t+ 5% (= Minimale Schrittweite)",
			"Resultierende Temperaturänderung:\t\t\t\t- 1°C",
			"",
			"Änderung des durchflussanteils durch die Sublimationskühlung:\t- 5% (= Minimale Schrittweite)",
			"Resultierende Temperaturänderung:\t\t\t\t+ 1°C",
			"",
			"",
			"Änderung der durchflussanteils durch die Solarzellen:\t\t+ 5% (= Minimale Schrittweite)",
			"Resultierende Temperaturänderung:\t\t\t\t+ 4°C",
			"",
			"Änderung der durchflussanteils durch die Solarzellen:\t\t- 5% (= Minimale Schrittweite)",
			"Resultierende Temperaturänderung:\t\t\t\t- 4°C",
			"",
			"Beeinflusst durch änderung:",
			"",
			"Rückwassertemperatur"};
	
	
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
