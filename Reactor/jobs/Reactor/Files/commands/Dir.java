package jobs.Reactor.Files.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import jobs.Reactor.Files.DOSProgrammInterface;
import jobs.Reactor.directory.Directory;
import jobs.Reactor.DOS;

public class Dir implements DOSProgrammInterface {

	private int location = -1;
	
	public int getLocation() {
		return this.location;
	}
	
	public void setLocation(int location) {

	}
	
	public void execute() {
		String output = "\n";
		output = output + " Datenträger in Laufwerk D: ist Daten\n";
		output = output + " Volumenseriennummer: 6B94-2OB0\n";
		output = output + "\n";
		
		int loc = DOS.currentIntLocation;
		
		Directory currentDir = null;
		ArrayList<Directory> containedDirs = new ArrayList<Directory>();
		
		for (int i = 0; i < DOS.folders.size(); i++) {
			if (loc == DOS.folders.get(i).getIdentifyer()) {
				currentDir = DOS.folders.get(i);
			}
			
			if (loc == DOS.folders.get(i).getLocation()) {
				containedDirs.add(DOS.folders.get(i));
			}
		}
		
		ArrayList<String> containedFiles = new ArrayList<String>();
		
		for (HashMap.Entry<String, DOSProgrammInterface> entry : DOS.programms.entrySet()) {
		    if (loc == entry.getValue().getLocation()) {
		    	containedFiles.add(entry.getKey());
		    }
		}
		
		String path = getPath(currentDir);
		
		output = output + " Verzeichnis von " + path + "\n";
		output = output + "\n";
		output = output + "<DIR>\t.\n";
		output = output + "<DIR>\t..\n";
		
		int dirCount = 2 + containedDirs.size();
		int fileCount = containedFiles.size();
		
		for (int i = 0; i < (dirCount - 2); i++) {
			output = output + "<DIR>\t" + containedDirs.get(i).getName() + "\n";
		}
		
		for (int i = 0; i < fileCount; i++) {
			output = output + "\t" + containedFiles.get(i) + "\n";
		}
		
		output = output + "     " + fileCount + " Datei(en), " + thousandsSeparator(ThreadLocalRandom.current().nextInt(10000,110000)) + " Bytes\n";
		output = output + "     " + dirCount + " Verzeichnis(se), " + thousandsSeparator(ThreadLocalRandom.current().nextInt(10000000, 1999999999)) + " Bytes frei";
		
		System.out.println(output);
		
		int[] canSee = new int[0];
		for (int i = 0; i < DOS.dosElement.size(); i++) {
			if (DOS.dosElement.get(i).location == DOS.currentIntLocation) {
				canSee = DOS.dosElement.get(i).canSee;
				if (DOS.dosElement.get(i).hasLowerDir) {
					path = DOS.dosElement.get(i).name;
					
					boolean hasLowerDir = true;
					
					do {
						int origin = DOS.dosElement.get(i).origin;
						
						for (int j = 0; j < DOS.dosElement.size(); j++) {
							if (origin == DOS.dosElement.get(j).location) {
								i = j;
								path = DOS.dosElement.get(j).name + "\\" + path;
								break;
							}
						}
						hasLowerDir = DOS.dosElement.get(i).hasLowerDir;
					} while (hasLowerDir);
					System.out.println(" Verzeichnis von " + path);
				} else {
					System.out.println(" Verzeichnis von " + DOS.dosElement.get(i).name);
				}
				System.out.println();
				System.out.println("<DIR>\t.");
				System.out.println("<DIR>\t..");
				break;
			}
		}
		dirCount = 2;
		fileCount = 0;
		for (int i = 0; i < canSee.length; i++) {
			for (int j = 0; j < DOS.dosElement.size(); j++) {
				if (DOS.dosElement.get(j).location == canSee[i]) {
					fileCount++;
					if (DOS.dosElement.get(j).type == 0) {
						System.out.print("<DIR>");
						dirCount++;
						fileCount--;
					}
					System.out.print("\t");
					System.out.print(DOS.dosElement.get(j).name);
					System.out.print("\n");
				}
			}
		}
		System.out.println("     " + fileCount + " Datei(en), " + thousandsSeparator(ThreadLocalRandom.current().nextInt(10000,110000)) + " Bytes");
		System.out.println("     " + dirCount + " Verzeichnis(se), " + thousandsSeparator(ThreadLocalRandom.current().nextInt(10000000, 1999999999)) + " Bytes frei");
		

	}
	
	private static String getPath(Directory currentDir) {
		String path = currentDir.getName();
		
		if (currentDir.getLocation() != -1) {
			
			int dirLoc = currentDir.getLocation();
			
			while (dirLoc != -1) {
				for (int i = 0; i < DOS.folders.size(); i++) {
					if (DOS.folders.get(i).getIdentifyer() == dirLoc) {
						path = DOS.folders.get(i).getName() + "\\" + path;
						dirLoc = DOS.folders.get(i).getLocation();
					}
				}
			}
			
		}
		return path;
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
	
	public String[] getContents() {
		return null;
	}

	public void setContents(String[] content) {

	}

}
