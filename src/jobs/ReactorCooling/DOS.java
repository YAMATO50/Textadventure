package jobs.ReactorCooling;

import java.util.concurrent.ThreadLocalRandom;

import adventure.text.Config;

import java.util.ArrayList;

public class DOS {

	static int currentIntLocation;
	static int currentRequest;
	static boolean errorOccured = false;
	public static ArrayList<DosElement> dosElement;
	public static boolean loop;
	
	public static void console() {
		ContentFiller.fill();
		ContentFiller.setValues();
		loop = true;
		String command;
		currentIntLocation = 0;
		String currentLocation = "";
		Tick.firstTick();
		while(loop) {
			Tick.tick();
			for (int i = 0; i < dosElement.size(); i++) {
				if (currentIntLocation == dosElement.get(i).location) {
					currentLocation = dosElement.get(i).name;
					if (dosElement.get(i).hasLowerDir) {
						boolean hasLowerDir;
						
						do {
							int origin = dosElement.get(i).origin;
							
							for (int j = 0; j < dosElement.size(); j++) {
								if (origin == dosElement.get(j).location) {
									i = j;
									currentLocation = dosElement.get(j).name + "\\" + currentLocation;
									break;
								}
							}
							hasLowerDir = dosElement.get(i).hasLowerDir;
						} while (hasLowerDir);
						break;
					}
				}
			}
			
			System.out.print(currentLocation + ">");
			command = getInput();
			String[] args_ = command.split(" ");
			
			if (validCommand(command)) {
				args_[0] = args_[0].toLowerCase();
				switch (args_[0]) {
				case "dir":
					listDirs();
					break;
				case "cd":
					moveDirs(args_);
					break;
				case "cd.":
					break;
				case "cd..":
					moveDirs(args_ = new String[] {"",".."});
					break;
				case "echo":
					say(args_);
					break;
				case "help":
					System.out.println("\nDIR\tListet die Dateien und Unterverzeichnisse des aktuellen Verzeichnisses auf\nCD\tÄndert das Verzeichniss in das dahinter angegebene Verzeichniss\n\tBesonderheiten:\n\t.\tÄndert nichts\n\t..\tGeht ein Verzeichniss zurück\nECHO\tGibt die dahinter angegebene nachricht aus\n\nUm eine Datei zu öffnen gib einfach den Namen der Datei ein (mit Endung)");
				}
			} else if (validFile(command)){
				if (currentIntLocation == dosElement.get(currentRequest).origin) {
					if (dosElement.get(currentRequest).type == 1) {
						printFileContent(dosElement.get(currentRequest).fileContent);
					} else {
						switch (dosElement.get(currentRequest).location) {
						case 4:
							Updater.update();
							break;
						case 9:
							ChangeParameter.flowRate();
							break;
						case 12:
							ChangeParameter.temperature();
							break;
						case 15:
							ChangeParameter.reservoirLevel();
							break;
						case 19:
							ChangeParameter.refluxTemperature();
							break;
						}
					}
				} else {
					System.out.println("Der Befehl \"" + args_[0] + "\" ist entweder falsch geschrieben oder \nkonnte nicht gefunden werden");
				}
			} else {
				System.out.println("Der Befehl \"" + args_[0] + "\" ist entweder falsch geschrieben oder \nkonnte nicht gefunden werden");
			}
			System.out.println();
		}
	}

	private static String getInput() {
		String input;
		input = Config.keyScan.nextLine();
		return input;
	}
	
	private static boolean validCommand(String command) {
		String[] args = command.split(" ");
		args[0] = args[0].toLowerCase();
		switch (args[0]) {
		case "dir":
			return true;
		case "cd":
		case "cd.":
		case "cd..":
			return true;
		case "echo":
			return true;
		case "help":
			return true;
		default:
			return false;
		}
	}
	
	private static void listDirs() {
		System.out.println();
		System.out.println(" Datenträger in Laufwerk D: ist Daten");
		System.out.println(" Volumenseriennummer: 6B94-2OB0");
		System.out.println();
		int[] canSee = new int[0];
		for (int i = 0; i < dosElement.size(); i++) {
			if (dosElement.get(i).location == currentIntLocation) {
				canSee = dosElement.get(i).canSee;
				if (dosElement.get(i).hasLowerDir) {
					String path = dosElement.get(i).name;
					
					boolean hasLowerDir = true;
					
					do {
						int origin = dosElement.get(i).origin;
						
						for (int j = 0; j < dosElement.size(); j++) {
							if (origin == dosElement.get(j).location) {
								i = j;
								path = dosElement.get(j).name + "\\" + path;
								break;
							}
						}
						hasLowerDir = dosElement.get(i).hasLowerDir;
					} while (hasLowerDir);
					System.out.println(" Verzeichnis von " + path);
				} else {
					System.out.println(" Verzeichnis von " + dosElement.get(i).name);
				}
				System.out.println();
				System.out.println("<DIR>\t.");
				System.out.println("<DIR>\t..");
				break;
			}
		}
		int dirCount = 2;
		int fileCount = 0;
		for (int i = 0; i < canSee.length; i++) {
			for (int j = 0; j < dosElement.size(); j++) {
				if (dosElement.get(j).location == canSee[i]) {
					fileCount++;
					if (dosElement.get(j).type == 0) {
						System.out.print("<DIR>");
						dirCount++;
						fileCount--;
					}
					System.out.print("\t");
					System.out.print(dosElement.get(j).name);
					System.out.print("\n");
				}
			}
		}
		System.out.println("     " + fileCount + " Datei(en), " + thousandsSeparator(ThreadLocalRandom.current().nextInt(10000,110000)) + " Bytes");
		System.out.println("     " + dirCount + " Verzeichnis(se), " + thousandsSeparator(ThreadLocalRandom.current().nextInt(10000000, 1999999999)) + " Bytes frei");
		
	}
	
	private static void moveDirs(String[] moveTo) {
		String dirName = "";
		for (int i = 1; i < moveTo.length; i++) {
			dirName = dirName + moveTo[i];
		}
		
		if (!validDir(dirName)) {
			System.out.println("Das System kann den angegebenen Pfad nicht finden");
			return;
		} else if (dirName.equals(".")) {
			//Nichts muss passieren
		} else if (dirName.equals("..")) {
			int currentIndex = -1;
			for (int i = 0; i < dosElement.size(); i++) {
				if (currentIntLocation == dosElement.get(i).location) {
					currentIndex = i;
					break;
				}
			}
			
			if (currentIndex == -1) {
				System.out.println("Ein Fehler ist aufgetreten!");
				System.out.println("Du wurdest in C:\\Pump zurück gesetzt.");
				currentIntLocation = 0;
				errorOccured = true;
				return;
			} else if (dosElement.get(currentIndex).hasLowerDir) {
				currentIntLocation = dosElement.get(currentIndex).origin;
			} else {
				System.out.println("Du bist nicht dazu berechtigt dies zu tun!");
			}
		} else {
			int currentIndex = -1;
			int gotoIndex = -1;
			for (int i = 0; i < dosElement.size(); i++) {
				if (currentIntLocation == dosElement.get(i).location) {
					currentIndex = i;
					break;
				}
			}
			
			if (currentIndex == -1) {
				System.out.println("Ein Fehler ist aufgetreten!");
				System.out.println("Du wurdest in C:\\Pump zurück gesetzt.");
				errorOccured = true;
				currentIntLocation = 0;
				return;
			} else {
				
				for (int i = 0; i < dosElement.size(); i++) {
					if (dirName.equalsIgnoreCase(dosElement.get(i).name) && dosElement.get(i).origin == currentIntLocation) {
						gotoIndex = i;
						break;
					}
				}
			}
			
			if (gotoIndex == -1) {
				System.out.println("Ein Fehler ist aufgetreten!");
				System.out.println("Du wurdest in C:\\Pump zurück gesetzt.");
				errorOccured = true;
				currentIntLocation = 0;
				return;
			} else {
				if (dosElement.get(gotoIndex).origin == dosElement.get(currentIndex).location) {
					currentIntLocation = dosElement.get(gotoIndex).location;
				} else {
					System.out.println("Das System kann den angegebenen Pfad nicht finden");
				}
			}
		}
		
		
	}
	
	private static void say(String[] out) {
		for (int i = 1; i < out.length; i++) {
			System.out.print(out[i] + " ");
		}
		System.out.print("\n"); //warum so und nicht mit println? Weils spaß macht!
	}
	
	private static boolean validDir(String dirName) {
		for (int i = 0; i < dosElement.size(); i++) {
			if (dirName.equalsIgnoreCase(dosElement.get(i).name) && dosElement.get(i).type == 0 && dosElement.get(i).origin == currentIntLocation) {
				currentRequest = i;
				return true;
			}
		}
		if (dirName.equals(".") || dirName.equals("..")) {
			return true;
		}
		return false;
	}
	
	private static boolean validFile(String fileName) {
		
		for (int i = 0; i < dosElement.size(); i++) {
			if (fileName.equalsIgnoreCase(dosElement.get(i).name) && dosElement.get(i).type != 0 && dosElement.get(i).origin == currentIntLocation) {
				currentRequest = i;
				return true;
			}
		}
		return false;
	}
	
	private static void printFileContent(String[] fileContent) {
		System.out.println();
		for (int i = 0; i < fileContent.length; i++) {
			System.out.println(fileContent[i]);
		}
	}
	
	private static String thousandsSeparator(int number) {
		char[] numbers = String.valueOf(number).toCharArray();
		String result = "";
		int counter = 0;
		for (int i = numbers.length - 1; i >= 0; i--) {
			result = String.valueOf(numbers[i]) + result;
			counter++;
			if (counter % 3 == 0) {
				result = "." + result;
			}
		}
		if (result.startsWith(".")) {
			result = result.substring(1);
		}
		
		return result;
	}
	
}
