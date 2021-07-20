package jobs.ReactorCooling.Files.txt;

import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class TemperatureInfoText implements DOSProgrammInterface {

	private String[] content = new String[] {
			"Die K�hlwassertemperatur ist die Temperatur die das K�hlwasser hat bevor es in den Reaktor geleitet wird",
			"",
			"Die Temperatur wird reguliert durch Sublimationsk�hlung und durch erw�rmen mit Solarzellen",
			"",
			"�nderung des durchflussanteils durch die Sublimationsk�hlung:\t+ 5% (= Minimale Schrittweite)",
			"Resultierende Temperatur�nderung:\t\t\t\t- 1�C",
			"",
			"�nderung des durchflussanteils durch die Sublimationsk�hlung:\t- 5% (= Minimale Schrittweite)",
			"Resultierende Temperatur�nderung:\t\t\t\t+ 1�C",
			"",
			"",
			"�nderung der durchflussanteils durch die Solarzellen:\t\t+ 5% (= Minimale Schrittweite)",
			"Resultierende Temperatur�nderung:\t\t\t\t+ 4�C",
			"",
			"�nderung der durchflussanteils durch die Solarzellen:\t\t- 5% (= Minimale Schrittweite)",
			"Resultierende Temperatur�nderung:\t\t\t\t- 4�C",
			"",
			"Beeinflusst durch �nderung:",
			"",
			"R�ckwassertemperatur"};
	
	
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
