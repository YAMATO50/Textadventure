package jobs.ReactorCooling.Files.commands;

import jobs.ReactorCooling.DOS;
import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class Cd implements DOSProgrammInterface {

	public void execute() {
		
		String[] moveTo = getMoveTo();
		
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
			for (int i = 0; i < DOS.dosElement.size(); i++) {
				if (DOS.currentIntLocation == DOS.dosElement.get(i).location) {
					currentIndex = i;
					break;
				}
			}
			
			if (currentIndex == -1) {
				System.out.println("Ein Fehler ist aufgetreten!");
				System.out.println("Du wurdest in D:\\Pump zurück gesetzt.");
				DOS.currentIntLocation = 0;
				DOS.errorOccured = true;
				return;
			} else if (DOS.dosElement.get(currentIndex).hasLowerDir) {
				DOS.currentIntLocation = DOS.dosElement.get(currentIndex).origin;
			} else {
				System.out.println("Du bist nicht dazu berechtigt dies zu tun!");
			}
		} else {
			int currentIndex = -1;
			int gotoIndex = -1;
			for (int i = 0; i < DOS.dosElement.size(); i++) {
				if (DOS.currentIntLocation == DOS.dosElement.get(i).location) {
					currentIndex = i;
					break;
				}
			}
			
			if (currentIndex == -1) {
				System.out.println("Ein Fehler ist aufgetreten!");
				System.out.println("Du wurdest in D:\\Pump zurück gesetzt.");
				DOS.errorOccured = true;
				DOS.currentIntLocation = 0;
				return;
			} else {
				
				for (int i = 0; i < DOS.dosElement.size(); i++) {
					if (dirName.equalsIgnoreCase(DOS.dosElement.get(i).name) && DOS.dosElement.get(i).origin == DOS.currentIntLocation) {
						gotoIndex = i;
						break;
					}
				}
			}
			
			if (gotoIndex == -1) {
				System.out.println("Ein Fehler ist aufgetreten!");
				System.out.println("Du wurdest in D:\\Pump zurück gesetzt.");
				DOS.errorOccured = true;
				DOS.currentIntLocation = 0;
				return;
			} else {
				if (DOS.dosElement.get(gotoIndex).origin == DOS.dosElement.get(currentIndex).location) {
					DOS.currentIntLocation = DOS.dosElement.get(gotoIndex).location;
				} else {
					System.out.println("Das System kann den angegebenen Pfad nicht finden");
				}
			}
		}
		
	}

	private String[] getMoveTo() {
		String[] moveTo = DOS.args_;
		
		switch (moveTo[0]) {
		case "cd.":
			return new String[] {"cd", "."};
		case "cd..":
			return new String[] {"cd", ".."};
		default:
			return moveTo;
		}
	}

	private static boolean validDir(String dirName) {
		for (int i = 0; i < DOS.dosElement.size(); i++) {
			if (dirName.equalsIgnoreCase(DOS.dosElement.get(i).name) && DOS.dosElement.get(i).type == 0 && DOS.dosElement.get(i).origin == DOS.currentIntLocation) {
				DOS.currentRequest = i;
				return true;
			}
		}
		if (dirName.equals(".") || dirName.equals("..")) {
			return true;
		}
		return false;
	}
	
	public String[] getContents() {
		return null;
	}

	public void setContents(String[] content) {
		
	}

}
