package jobs.ReactorCooling.Files.commands;

import java.util.concurrent.ThreadLocalRandom;

import jobs.ReactorCooling.DOS;
import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class Dir implements DOSProgrammInterface {

	public void execute() {
		System.out.println();
		System.out.println(" Datenträger in Laufwerk D: ist Daten");
		System.out.println(" Volumenseriennummer: 6B94-2OB0");
		System.out.println();
		int[] canSee = new int[0];
		for (int i = 0; i < DOS.dosElement.size(); i++) {
			if (DOS.dosElement.get(i).location == DOS.currentIntLocation) {
				canSee = DOS.dosElement.get(i).canSee;
				if (DOS.dosElement.get(i).hasLowerDir) {
					String path = DOS.dosElement.get(i).name;
					
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
		int dirCount = 2;
		int fileCount = 0;
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
