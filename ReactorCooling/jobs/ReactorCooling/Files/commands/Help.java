package jobs.ReactorCooling.Files.commands;

import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class Help implements DOSProgrammInterface {

	public void execute() {
		System.out.println(
						  "\n" + "DIR\tListet die Dateien und Unterverzeichnisse des aktuellen Verzeichnisses auf"
						+ "\n" + "CD\t�ndert das Verzeichniss in das dahinter angegebene Verzeichniss"
						+ "\n" + "\tBesonderheiten:"
						+ "\n" + "\t.\t�ndert nichts"
						+ "\n" + "\t..\tGeht ein Verzeichniss zur�ck"
						+ "\n" + "ECHO\tGibt die dahinter angegebene nachricht aus"
					  + "\n\n" + "Um eine Datei zu �ffnen gib einfach den Namen der Datei ein (mit Endung)");
	}

	public String[] getContents() {
		return null;
	}

	public void setContents(String[] content) {

	}

}
