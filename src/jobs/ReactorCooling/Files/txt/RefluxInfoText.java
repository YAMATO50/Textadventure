package jobs.ReactorCooling.Files.txt;

import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class RefluxInfoText implements DOSProgrammInterface {

	private String[] content = new String[] {
			"Die R�ckwassertemperatur ist die Temperatur die das K�hlwasser hat nachdem es in den Reaktor geleitet wurde",
			"Bevor das R�ckwasser ins Reservoir geleitet wird wird es weiter abk�hlen gelassen (nicht relevant)",
			"",
			"Die Temperatur wird reguliert durch Sublimationsk�hlung und Heizleistung in der Kuppel",
			"",
			"�nderung des durchflussanteils durch die Sublimationsk�hlung:\t+ 5% (= Minimale Schrittweite)",
			"Resultierende Temperatur�nderung:\t\t\t\t- 5�C",
			"",
			"�nderung des durchflussanteils durch die Sublimationsk�hlung:\t- 5% (= Minimale Schrittweite)",
			"Resultierende Temperatur�nderung:\t\t\t\t+ 5�C",
			"",
			"",
			"�nderung der Heizleistung:\t\t\t\t\t+ 10 MW (= Minimale Schrittweite)",
			"Resultierende Temperatur�nderung:\t\t\t\t- 5�C",
			"",
			"�nderung der Heizleistung:\t\t\t\t\t- 10 MW (= Minimale Schrittweite)",
			"Resultierende Temperatur�nderung:\t\t\t\t+ 5�C",
			"",
			"Beeinflusst durch �nderung:",
			"",
			"K�hlwassertemperatur"};

	public void execute() {

		for (int i = 0; i < this.content.length; i++) {
			System.out.println(this.content[i] + "\n");
		}
		
	}

}
