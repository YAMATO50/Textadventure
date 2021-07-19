package jobs.ReactorCooling.Files.txt;

import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class ReservoirInfoText implements DOSProgrammInterface {

	private String[] content = new String[] {
			"Das Reservoir beinhaltet eine gro�e menge an Wasser die zum K�hlen verwendet wird",
			"",
			"Der F�llstand wird reguliert durch abgeben von Wasser an die Sublimationsk�hlanlage und durch",
			"schnelleres erhalten von R�ckwasser",
			"",
			"�nderung der Wasseranteile in die Sublimationsk�hlung:\t+ 5% (= Minimale Schrittweite)",
			"Resultierende Reservoirf�llstands�nderung:\t\t- 5%",
			"",
			"�nderung der Wasseranteile in die Sublimationsk�hlung:\t- 5% (= Minimale Schrittweite)",
			"Resultierende Reservoirf�llstands�nderung:\t\t+ 5%",
			"",
			"",
			"�nderung der geschwindigkeit des R�ckwassererhalts:\t+ 5% (= Minimale Schrittweite)",
			"Resultierende Reservoirf�llstands�nderung:\t\t+ 5%",
			"",
			"�nderung der geschwindigkeit des R�ckwassererhalts:\t- 5% (= Minimale Schrittweite)",
			"Resultierende Reservoirf�llstands�nderung:\t\t- 5%",
			"",
			"Beeinflusst durch �nderung:",
			"",
			"K�hlwassertemperatur"};
	
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
