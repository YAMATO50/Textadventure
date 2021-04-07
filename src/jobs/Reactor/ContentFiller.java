package jobs.Reactor;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ContentFiller {

	private static ArrayList<DosElement> dosElement = new ArrayList<DosElement>();
	
	public static void fill() {
		dosElement.add(new DosElement(0,-1,new int[] {1,2,3,4,5,6},0,"D:\\Reactor",false));
		dosElement.add(new DosElement(1,0,new int[] {7,8},0,"Brennstaebe",true)); //8 = txt, 7 = exe
		dosElement.add(new DosElement(2,0,new int[] {9,10},0,"Kontrollstaebe",true)); //10 = txt, 9 = exe
		dosElement.add(new DosElement(3,0,new int[] {11, 12},0,"Temperatur",true)); //12 = txt, 11 = exe
		
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
			
		DOS.dosElement = dosElement;
	}

	public static int targetTemperature;
	public static int targetFlowRate;
	public static int targetRefluxTemperature;
	public static int targetReservoirLevel;
	
	public static void setValues() {
		
		int[] setToValues = temperatureSetter();
		
		ChangeParameter.sublimationRate = setToValues[0];
		ChangeParameter.solarRate = setToValues[1];
		TemperatureReader.temperature = setToValues[2];
		targetTemperature = setToValues[3];
		
		FlowRateReader.flowRate = ThreadLocalRandom.current().nextInt(1000,11000);
		targetFlowRate = ThreadLocalRandom.current().nextInt(4500,7000);
		ChangeParameter.pumpPower = FlowRateReader.flowRate;
		
		setToValues = refluxTemperatureSetter();
		
		ChangeParameter.refluxSublimationRate = setToValues[0];
		ChangeParameter.refluxHeatPower = setToValues[1];
		RefluxTemperatureReader.temperature = setToValues[2];
		targetRefluxTemperature = setToValues[3];
		
		setToValues = reservoirLevelSetter();
		
		ChangeParameter.reservoirSublimationRate = setToValues[0];
		ChangeParameter.getRefluxWaterRate = setToValues[1];
		ReservoirLevelReader.reservoirLevel = setToValues[2];
		targetReservoirLevel = setToValues[3];
		
		for (int i = 0; i < DOS.dosElement.size(); i++) {
			if (DOS.dosElement.get(i).location == 6) {
				String[] content = DOS.dosElement.get(i).fileContent;
				for (int j = 0; j < content.length; j++) {
					
					content[j] = content[j].replaceFirst("¢", String.valueOf(targetTemperature));
					content[j] = content[j].replaceFirst("£", String.valueOf(targetFlowRate));
					content[j] = content[j].replaceFirst("¤", String.valueOf(targetRefluxTemperature));
					content[j] = content[j].replaceFirst("¥", String.valueOf(targetReservoirLevel));
				}
				DOS.dosElement.get(i).fileContent = content;
				break;
			}
		}
		
	}
	
	public static int[] temperatureSetter() {
		
		int[] returner = new int[4];
		
		//Defining "0"
		int cooling = ThreadLocalRandom.current().nextInt(4, 18) * 5;
		int warming = ThreadLocalRandom.current().nextInt(4,18) * 5;
		
		int variabilityUp = (cooling / 5) + (warming / 5) * 2;
		int variabilityDown = ((100 - cooling) / 5) + ((100 - warming) / 5) * 2;
		
		int currentTemp = ThreadLocalRandom.current().nextInt(30,60);
		int goalTemp = 0;
		
		if (ThreadLocalRandom.current().nextInt(0,2) == 0) {
			// Temperatur zu niedrig
			goalTemp = currentTemp + (int) ((float) variabilityUp * ((float) ThreadLocalRandom.current().nextInt(30,90) / 100));
			
		} else {
			//temperatur zu hoch
			goalTemp = currentTemp - (int) ((float) variabilityDown * ((float) ThreadLocalRandom.current().nextInt(30,90) / 100));
			
		}
		
		if (goalTemp <= 0) {
			goalTemp = 1;
		}
		
		returner[0] = cooling;
		returner[1] = warming;
		returner[2] = currentTemp;
		returner[3] = goalTemp;
		
		return returner;
		
	}
	
	public static int[] refluxTemperatureSetter() {
		
		int[] returner = new int[4];
		
		//Defining "0"
		int coolingA = ThreadLocalRandom.current().nextInt(4, 18) * 5;
		int coolingB = ThreadLocalRandom.current().nextInt(4, 18) * 10;
		
		int variabilityUp = (100 - coolingA) + ((100 - coolingB) / 2);
		int variabilityDown = coolingA + coolingB / 2;
		
		int currentTemp = ThreadLocalRandom.current().nextInt(85,240);
		int goalTemp = 0;
		
		if (ThreadLocalRandom.current().nextInt(0,2) == 0) {
			// Temperatur zu niedrig
			goalTemp = currentTemp - (int) ((float) variabilityUp * ((float) ThreadLocalRandom.current().nextInt(30,90) / 100));
			
		} else {
			//temperatur zu hoch
			goalTemp = currentTemp + (int) ((float) variabilityDown * ((float) ThreadLocalRandom.current().nextInt(30,90) / 100));
			
		}
		
		if (goalTemp <= 0) {
			goalTemp = 1;
		}
		
		returner[0] = coolingA;
		returner[1] = coolingB;
		returner[2] = currentTemp;
		returner[3] = goalTemp;
		
		return returner;
		
	}

	public static int[] reservoirLevelSetter() {
		int[] returner = new int[4];
		
		//Defining "0"
		int sublimation = ThreadLocalRandom.current().nextInt(4,18) * 5;
		int fasterReflux = ThreadLocalRandom.current().nextInt(4,32) * 5;
		
		int variabilityDown = (sublimation / 5) + (fasterReflux / 5);
		int variabilityUp = ((100 - sublimation) / 5) + ((200 - fasterReflux) / 5);
		
		int currentLevel = ThreadLocalRandom.current().nextInt(45,100);
		int goalLevel = 0;
		
		if (ThreadLocalRandom.current().nextInt(0,2) == 0) {
			// Temperatur zu hoch
			goalLevel = currentLevel - (int) ((float) variabilityUp * ((float) ThreadLocalRandom.current().nextInt(10,90) / 100));
			
		} else {
			//temperatur zu niedrig
			goalLevel = currentLevel + (int) ((float) variabilityDown * ((float) ThreadLocalRandom.current().nextInt(10,90) / 100));
			
		}
		
		if (goalLevel <= 0) {
			goalLevel = 1;
		}
		
		returner[0] = sublimation;
		returner[1] = fasterReflux;
		returner[2] = currentLevel;
		returner[3] = goalLevel;
		
		return returner;
	}
	
}
