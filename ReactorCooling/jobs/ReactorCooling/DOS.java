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
		ContentFiller.fillProgramms();
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
			args_ = command.split(" ");
			
			if (validCommand(args_[0])) {
				args_[0] = args_[0].toLowerCase();
				try {
					programms.get(args_[0]).execute();
				} catch (NullPointerException e) {
					//Unknown Command
				}
			} else if (validFile(command)){
				System.out.println();
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
		return programms.containsKey(command.toLowerCase());
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
