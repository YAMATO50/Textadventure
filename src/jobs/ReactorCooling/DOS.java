package jobs.ReactorCooling;

import adventure.text.Config;
import jobs.ReactorCooling.Files.DOSProgrammInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class DOS {

	public static int currentIntLocation;
	public static int currentRequest;
	public static boolean errorOccured = false;
	public static ArrayList<DosElement> dosElement;
	public static boolean loop;
	public static HashMap<String, DOSProgrammInterface> programms;
	public static String[] args_;
	
	public static void console() {
		ContentFiller.fill();
		ContentFiller.setValues();
		ContentFiller.fillProgramms();
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
			args_ = command.split(" ");
			
			if (validCommand(command)) {
				args_[0] = args_[0].toLowerCase();
				try {
					programms.get(args_[0]).execute();
				} catch (NullPointerException e) {
					//Unknown Command
				}
			} else if (validFile(command)){
				if (currentIntLocation == dosElement.get(currentRequest).origin) {
					command = command.toLowerCase();
						try {
							programms.get(command).execute();
						} catch (NullPointerException e) {
							//File not Found
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
	
	private static boolean validFile(String fileName) {
		
		for (int i = 0; i < dosElement.size(); i++) {
			if (fileName.equalsIgnoreCase(dosElement.get(i).name) && dosElement.get(i).type != 0 && dosElement.get(i).origin == currentIntLocation) {
				currentRequest = i;
				return true;
			}
		}
		return false;
	}
	

	
}
