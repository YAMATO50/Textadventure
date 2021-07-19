package jobs.ReactorCooling.Files.txt;

import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class WerteText implements DOSProgrammInterface {

	private String[] content = new String[] {
			"Hier sind die werte eingetragen die erreicht werden müssen. Die Werte ändern sich täglich entsprechend des",
			"Stromverbrauches der Mondbasis. Diese werte müssen innerhalb gewisser tolleranzen eingehalten werden.",
			"",
			"Werte:",
			"",
			"Kühlwasser:",
			"",
			"Temperatur:\t¢°C",
			"Toleranz:\t+/- 2°C",
			"",
			"Durchfluss:\t£ L/s",
			"Toleranz:\t+/- 100 L/s",
			"",
			"Rückwasser:",
			"",
			"Temperatur:\t¤°C",
			"Toleranz:\t+/- 5°C",
			"",
			"Reservoir:\t¥% gefüllt",
			"Toleranz:\t+/- 4%"}; //The symbols ¢, £, ¤, ¥ are later replaced with the actual numbers
	
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
