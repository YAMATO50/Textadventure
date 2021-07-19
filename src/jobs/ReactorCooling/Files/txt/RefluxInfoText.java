package jobs.ReactorCooling.Files.txt;

import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class RefluxInfoText implements DOSProgrammInterface {

	private String[] content = new String[] {
			"Die Rückwassertemperatur ist die Temperatur die das Kühlwasser hat nachdem es in den Reaktor geleitet wurde",
			"Bevor das Rückwasser ins Reservoir geleitet wird wird es weiter abkühlen gelassen (nicht relevant)",
			"",
			"Die Temperatur wird reguliert durch Sublimationskühlung und Heizleistung in der Kuppel",
			"",
			"Änderung des durchflussanteils durch die Sublimationskühlung:\t+ 5% (= Minimale Schrittweite)",
			"Resultierende Temperaturänderung:\t\t\t\t- 5°C",
			"",
			"Änderung des durchflussanteils durch die Sublimationskühlung:\t- 5% (= Minimale Schrittweite)",
			"Resultierende Temperaturänderung:\t\t\t\t+ 5°C",
			"",
			"",
			"Änderung der Heizleistung:\t\t\t\t\t+ 10 MW (= Minimale Schrittweite)",
			"Resultierende Temperaturänderung:\t\t\t\t- 5°C",
			"",
			"Änderung der Heizleistung:\t\t\t\t\t- 10 MW (= Minimale Schrittweite)",
			"Resultierende Temperaturänderung:\t\t\t\t+ 5°C",
			"",
			"Beeinflusst durch änderung:",
			"",
			"Kühlwassertemperatur"};

	public void execute() {

		for (int i = 0; i < this.content.length; i++) {
			System.out.println(this.content[i] + "\n");
		}
		
	}

}
