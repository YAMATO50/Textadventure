package jobs.ReactorCooling.Files.txt;

import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class HelpText implements DOSProgrammInterface {

	private String[] content = new String[] {	
			"Befehle:",
			"",
			"DIR\tListet die Dateien und Unterverzeichnisse des aktuellen Verzeichnisses auf",
			"\ttipp: Gib jedes mal wenn du den ordner wechselst DIR ein",
			"CD\t�ndert das Verzeichniss in das dahinter angegebene Verzeichniss",
			"\tBesonderheiten:",
			"\t.\t�ndert nichts",
			"\t..\tGeht ein Verzeichniss zur�ck",
			"ECHO\tGibt die dahinter angegebene nachricht aus",
			"",
			"Um eine Datei zu �ffnen gib einfach den Namen der Datei ein (mit Endung)",
			"",
			"<DIR> = Verzeichnis = Ordner",
			"",
			"Funktionsweise:",
			"",
			"In den Verzeichnissen findest du Verzeichnisse und Dateien die du �ffnen kannst, indem du \"cd [name]\" f�r Verzeichnisse",
			"oder den Dateinamen + Endung eingibst.",
			"In einer .exe Datei siehst du alle Werte und kannst f�r bestimmte Werte die Parameter anpassen.",
			"Verschiedene Zust�nde beeinflussen sich, sodass z.b. das �ndern der Durchflussrate die Temperatur beeinflusst.",
			"Gewisse werte d�rfen einen bestimmten wert nicht �berschreiten oder unterschreiten. Weitere informationen dazu",
			"in der \"werte.txt\".",
			"Wenn du fertig bist, f�hre die \"update.exe\" aus. Wenn alle werte stimmen, erh�lst du dein Gehalt von Tobias Ingram."};
	
	public void execute() {
		
		for (int i = 0; i < this.content.length; i++) {
			System.out.println(this.content[i] + "\n");
		}
		
	}
	
}
