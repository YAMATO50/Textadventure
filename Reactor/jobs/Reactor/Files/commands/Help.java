package jobs.Reactor.Files.commands;

import jobs.Reactor.Files.DOSProgrammInterface;

public class Help implements DOSProgrammInterface {

	private int location = -1;
	
	public int getLocation() {
		return this.location;
	}
	
	public void setLocation(int location) {
	}
	
	public void execute() {
		System.out.println(
						  "\n" + "DIR\tListet die Dateien und Unterverzeichnisse des aktuellen Verzeichnisses auf"
						+ "\n" + "CD\tÄndert das Verzeichniss in das dahinter angegebene Verzeichniss"
						+ "\n" + "\tBesonderheiten:"
						+ "\n" + "\t.\tÄndert nichts"
						+ "\n" + "\t..\tGeht ein Verzeichniss zurück"
						+ "\n" + "ECHO\tGibt die dahinter angegebene nachricht aus"
					  + "\n\n" + "Um eine Datei zu öffnen gib einfach den Namen der Datei ein (mit Endung)");
	}

	public String[] getContents() {
		return null;
	}

	public void setContents(String[] content) {

	}

}
