package jobs.ReactorCooling.Files.txt;

import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class HelpText implements DOSProgrammInterface {

	private String[] content = new String[] {	
			"Befehle:",
			"",
			"DIR\tListet die Dateien und Unterverzeichnisse des aktuellen Verzeichnisses auf",
			"\ttipp: Gib jedes mal wenn du den ordner wechselst DIR ein",
			"CD\tÄndert das Verzeichniss in das dahinter angegebene Verzeichniss",
			"\tBesonderheiten:",
			"\t.\tÄndert nichts",
			"\t..\tGeht ein Verzeichniss zurück",
			"ECHO\tGibt die dahinter angegebene nachricht aus",
			"",
			"Um eine Datei zu öffnen gib einfach den Namen der Datei ein (mit Endung)",
			"",
			"<DIR> = Verzeichnis = Ordner",
			"",
			"Funktionsweise:",
			"",
			"In den Verzeichnissen findest du Verzeichnisse und Dateien die du öffnen kannst, indem du \"cd [name]\" für Verzeichnisse",
			"oder den Dateinamen + Endung eingibst.",
			"In einer .exe Datei siehst du alle Werte und kannst für bestimmte Werte die Parameter anpassen.",
			"Verschiedene Zustände beeinflussen sich, sodass z.b. das Ändern der Durchflussrate die Temperatur beeinflusst.",
			"Gewisse werte dürfen einen bestimmten wert nicht überschreiten oder unterschreiten. Weitere informationen dazu",
			"in der \"werte.txt\".",
			"Wenn du fertig bist, führe die \"update.exe\" aus. Wenn alle werte stimmen, erhälst du dein Gehalt von Tobias Ingram."};
	
	public void execute() {
		
		for (int i = 0; i < this.content.length; i++) {
			System.out.println(this.content[i] + "\n");
		}
		
	}
	
}
