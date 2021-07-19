package jobs.ReactorCooling.Files.txt;

import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class WerteText implements DOSProgrammInterface {

	private String[] content = new String[] {
			"Hier sind die werte eingetragen die erreicht werden m�ssen. Die Werte �ndern sich t�glich entsprechend des",
			"Stromverbrauches der Mondbasis. Diese werte m�ssen innerhalb gewisser tolleranzen eingehalten werden.",
			"",
			"Werte:",
			"",
			"K�hlwasser:",
			"",
			"Temperatur:\t��C",
			"Toleranz:\t+/- 2�C",
			"",
			"Durchfluss:\t� L/s",
			"Toleranz:\t+/- 100 L/s",
			"",
			"R�ckwasser:",
			"",
			"Temperatur:\t��C",
			"Toleranz:\t+/- 5�C",
			"",
			"Reservoir:\t�% gef�llt",
			"Toleranz:\t+/- 4%"}; //The symbols �, �, �, � are later replaced with the actual numbers
	
	public void execute() {
		
		for (int i = 0; i < this.content.length; i++) {
			System.out.println(this.content[i] + "\n");
		}

	}

	public String[] getContents() {
		return this.content;
	}

	@Override
	public void setContents(String[] content) {
		this.content = content;	
	}

}
