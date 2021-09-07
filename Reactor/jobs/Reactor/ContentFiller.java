package jobs.Reactor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import jobs.Reactor.Files.DOSProgrammInterface;
import jobs.Reactor.Files.commands.*;
import jobs.Reactor.Files.exe.*;
import jobs.Reactor.Files.txt.TXT;
import jobs.Reactor.directory.Directory;

public class ContentFiller {

	private static ArrayList<DosElement> dosElement = new ArrayList<DosElement>();
	private static ArrayList<Directory> folders = new ArrayList<Directory>();
	
	private static void fillOther() {
		dosElement.add(new DosElement(0,-1,new int[] {1,2,3,4,5,6},0,"D:\\Reactor",false));
		dosElement.add(new DosElement(1,0,new int[] {7,8},0,"Brennstaebe",true)); //8 = txt, 7 = exe
		dosElement.add(new DosElement(2,0,new int[] {9,10},0,"Kontrollstaebe",true)); //10 = txt, 9 = exe
		dosElement.add(new DosElement(3,0,new int[] {11, 12},0,"Temperatur",true)); //12 = txt, 11 = exe
		
		folders.add(new Directory(-1, 0, "D:\\Reactor"));
		folders.add(new Directory(0, 1, "Brennstaebe"));
		folders.add(new Directory(0, 2, "Kontrollstaebe"));
		folders.add(new Directory(0, 3, "Temperatur"));
		
		DOS.folders = folders;
		
		DOS.programms.put("update.exe", new Updater(0));
		DOS.programms.put("brennstab.exe", new FuelRods(1));
		DOS.programms.put("kontrollstab.exe", new ControllRods(2));
		DOS.programms.put("reaktortemperatur.exe", new Temperature(3));
		
		dosElement.add(new DosElement(4,0,2,"update.exe")); 
		dosElement.add(new DosElement(7,1,2,"Brennstab.exe"));
		dosElement.add(new DosElement(9,2,2,"Kontrollstab.exe"));
		dosElement.add(new DosElement(11,3,2,"Reaktortemperatur.exe"));
		
		String[] 	content = new String[] {	
					"Befehle:",
					"",
					"DIR\tListet die Dateien und Unterverzeichnisse des aktuellen Verzeichnisses auf",
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
					"oder den Dateinamen + Endung für dateien eingibst.",
					"In einer .exe Datei siehst du alle Werte und kannst für bestimmte Werte die Parameter anpassen.",
					"Verschiedene Zustände beeinflussen sich, sodass z.b. das Ändern der Brennstabsanzahl die Temperatur beeinflusst.",
					"Die Reaktorleistung darf einen bestimmten wert nicht überschreiten oder unterschreiten. Weitere informationen dazu",
					"in der \"werte.txt\".",
					"Wenn du fertig bist, führe die \"update.exe\" aus. Wenn alle werte stimmen, erhälst du dein Gehalt von Tobias Ingram."};
		dosElement.add(new DosElement(5,0,1,"help.txt",content));
		DOS.programms.put("help.txt", new TXT(content, 0));
		
					content = new String[] {
						"Hier sind die werte eingetragen die erreicht werden müssen. Die Werte ändern sich täglich entsprechend des",
						"Stromverbrauches der Mondbasis. Diese werte müssen innerhalb gewisser tolleranzen eingehalten werden.",
						"",
						"Werte:",
						"",
						"Reaktorleistung:",
						"",
						"Angeforderte Leistung:\t¢ TW",
						"Toleranz:\t\t+/- 1 TW"}; //The symbol ¢ is later replaced with the actual number
		dosElement.add(new DosElement(6,0,1,"werte.txt",content));
		DOS.programms.put("werte.txt", new TXT(content, 0));
		
					content = new String[] {
						"Die Brennstabsanzahl ist die anzahl an Brennstäben, die aktiv und im Reaktor sind.",
						"",
						"Die Anzahl der Brennstäbe wird über einen speziellen greifarm gesteuert.",
						"",
						"Änderung der Anzahl an Brennstäben im Reaktorkern:\t\t+ 1 (= Minimale Schrittweite)",
						"Resultierende Leistungsänderung:\t\t\t\t+ 100 TW",
						"",
						"Änderung der Anzahl an Brennstäben im Reaktorkern:\t\t- 1 (= Minimale Schrittweite)",
						"Resultierende Leistungsänderung:\t\t\t\t- 100 TW",
						"",
						"Beeinflusst durch änderung:",
						"",
						"Temperatur"};
			dosElement.add(new DosElement(8,1,1,"info.txt",content));
			DOS.programms.put("brennstab_info.txt", new TXT(content, 1));
			
					content = new String[] {
						"Die Kontrollstabstiefe gibt in % an, wie Tief die Kontrollstäbe in den Reaktor eingefahren sind",
						"",
						"Die Kontrollstäbe werden durch einen Motor im Deckel des Reaktorkerns gesteuert.",
						"",
						"Änderung der Tiefe der Kontrollstäbe:\t\t+ 1% (= Minimale Schrittweite)",
						"Resultierende Leistungsänderung:\t\t- 10 TW",
						"",
						"Änderung der Tiefe der Kontrollstäbe:\t\t- 1% (= Minimale Schrittweite)",
						"Resultierende Leistungsänderung:\t\t+ 10 TW",
						"",
						"Beeinflusst durch änderung:",
						"",
						"Temperatur"};
		dosElement.add(new DosElement(10,2,1,"info.txt",content));
		DOS.programms.put("kontrollstab_info.txt", new TXT(content, 2));
		
					content = new String[] {
						"Die Reaktorkerntemperatur ist die Temperatur, die der Reaktorkern, die Brenn- und Kontrollsäbe und der ",
						"Moderator (= die Flüssigkeit im Reaktorkern) haben.",
						"",
						"Die Temperatur des Moderators beeinflusst, ob und wie gut der Spaltvorgang abläuft, und wieviel",
						"Dampf erzeugt werden kann. Diese Temperatur kann durch die Kühlung des Reaktorkerns beeinflusst werden.",
						"",
						"Änderung der Temperatur:\t\t\t+ 1°C (= Minimale Schrittweite)",
						"Resultierende Leistungsänderung:\t\t- 1 TW",
						"",
						"Änderung der Temperatur:\t\t\t- 1°C (= Minimale Schrittweite)",
						"Resultierende Leistungsänderung:\t\t+ 1 TW"};
		dosElement.add(new DosElement(12,3,1,"info.txt",content));
		DOS.programms.put("temperatur_info.txt", new TXT(content, 3));
			
		DOS.dosElement = dosElement;
	}
	
	public static int targetPower;
	
	public static void setValues() {
		
		initiateAllValues();
		
		fuelRodsPowerSetter();
		controllRodsPowerSetter();
		temperaturePowerSetter();
		
		Tick.simulatedTick();
		
		targetPower = Parameters.power;
		
		if (targetPower < 0) {
			targetPower = targetPower *-1;
			if (targetPower < 200) {
				targetPower = ThreadLocalRandom.current().nextInt(427, 846) - targetPower;
			} else if (targetPower < 400) {
				targetPower = ThreadLocalRandom.current().nextInt(549, 853) - targetPower;
			} else if (targetPower < 600) {
				targetPower = ThreadLocalRandom.current().nextInt(682, 807) - targetPower;
			} else {
				targetPower = ThreadLocalRandom.current().nextInt(819, 945) - targetPower;
			}
		} else {
			if (targetPower < 200) {
				targetPower = ThreadLocalRandom.current().nextInt(427, 846) + targetPower;
			} else if (targetPower < 400) {
				targetPower = ThreadLocalRandom.current().nextInt(549, 653) + targetPower;
			} else if (targetPower < 600) {
				targetPower = ThreadLocalRandom.current().nextInt(418, 527) + targetPower;
			} else {
				targetPower = ThreadLocalRandom.current().nextInt(228, 469) + targetPower;
			}
		}
		
		Parameters.power = targetPower + Parameters.power;
		power = Parameters.power;
		
		for (int i = 0; i < DOS.dosElement.size(); i++) {
			if (DOS.dosElement.get(i).location == 6) {
				String[] content = DOS.dosElement.get(i).fileContent;
				for (int j = 0; j < content.length; j++) {
					content[j] = content[j].replaceFirst("¢", String.valueOf(targetPower));
				}
				DOS.dosElement.get(i).fileContent = content;
				break;
			}
		}
		
		resetValues();
		
	}
	
	private static int fuelRodAmount;
	private static int controllRodDepth;
	private static int temperature;
	private static int power;
	
	private static void fuelRodsPowerSetter() {	
		int fuelRodAmountChange = ThreadLocalRandom.current().nextInt(2 - fuelRodAmount, 7 - fuelRodAmount);
		
		if (fuelRodAmountChange < 0) {
			fuelRodAmountChange = fuelRodAmountChange * -1;
			
			for (int i = 0; i < fuelRodAmountChange; i++) {
				Parameters.fuelRodAmount = Parameters.fuelRodAmount - 1;
			}
			Tick.simulatedTick();
		} else {
			for (int i = 0; i < fuelRodAmountChange; i++) {
				Parameters.fuelRodAmount = Parameters.fuelRodAmount + 1;
			}
			Tick.simulatedTick();
		}
	}
	
	private static void controllRodsPowerSetter() {
		int controllRodDepthChange = ThreadLocalRandom.current().nextInt(15 - controllRodDepth, 48 - controllRodDepth);
		
		if (controllRodDepthChange < 0) {
			controllRodDepthChange = controllRodDepthChange * -1;
			
			for (int i = 0; i < controllRodDepthChange; i++) {
				Parameters.controllRodDepth = Parameters.controllRodDepth - 1;
			}
			Tick.simulatedTick();
		} else {
			for (int i = 0; i < controllRodDepthChange; i++) {
				Parameters.controllRodDepth = Parameters.controllRodDepth + 1;
			}
			Tick.simulatedTick();
		}
	}
	
	private static void temperaturePowerSetter() {
		int temperatureChange = ThreadLocalRandom.current().nextInt(311 - temperature, 469 - temperature);
		
		if (temperatureChange < 0) {
			temperatureChange = temperatureChange * -1;
			
			for (int i = 0; i < temperatureChange; i++) {
				Parameters.temperature = Parameters.temperature - 1;
			}
			Tick.simulatedTick();
		} else {
			for (int i = 0; i < temperatureChange; i++) {
				Parameters.temperature = Parameters.temperature + 1;
			}
			Tick.simulatedTick();
		}
	}
	
	private static void initiateAllValues() {
		Parameters.fuelRodAmount = ThreadLocalRandom.current().nextInt(2, 7);
		Parameters.controllRodDepth = ThreadLocalRandom.current().nextInt(15, 48);
		Parameters.temperature = ThreadLocalRandom.current().nextInt(311, 469);
		
		//PowerReader.power = ThreadLocalRandom.current().nextInt(217, 789);
		Parameters.power = 0;
		
		Tick.simulatedFirstTick();
		
		fuelRodAmount = Parameters.fuelRodAmount;
		controllRodDepth = Parameters.controllRodDepth;
		temperature = Parameters.temperature;
	}
	
	private static void resetValues() {
		Parameters.fuelRodAmount = fuelRodAmount;
		Parameters.controllRodDepth = controllRodDepth;
		Parameters.temperature = temperature;
		Parameters.power = power;
	}
	
	public static void fillProgramms() {
		
		DOS.programms = new HashMap<String, DOSProgrammInterface>();
		
		DOS.programms.put("cd", new Cd());
		DOS.programms.put("dir", new Dir());
		DOS.programms.put("echo", new Echo());
		DOS.programms.put("help", new Help());
		
		fillOther();
		
	}
	
}
