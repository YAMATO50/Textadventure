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
	
	public static int targetPower;
	
	public static void setValues() {
		
		initiateAllValues();
		
		fuelRodsPowerSetter();
		controllRodsPowerSetter();
		temperaturePowerSetter();
		
		targetPower = PowerReader.power;
		
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
				FuelRodReader.fuelRodAmount = FuelRodReader.fuelRodAmount - 1;
				Tick.simulatedTick();
			}
			Tick.simulatedTick();
		} else {
			for (int i = 0; i < fuelRodAmountChange; i++) {
				FuelRodReader.fuelRodAmount = FuelRodReader.fuelRodAmount + 1;
				Tick.simulatedTick();
			}
			Tick.simulatedTick();
		}
	}
	
	private static void controllRodsPowerSetter() {
		int controllRodDepthChange = ThreadLocalRandom.current().nextInt(15 - controllRodDepth, 48 - controllRodDepth);
		
		if (controllRodDepthChange < 0) {
			controllRodDepthChange = controllRodDepthChange * -1;
			
			for (int i = 0; i < controllRodDepthChange; i++) {
				ControllRodDepthReader.controllRodDepth = ControllRodDepthReader.controllRodDepth - 1;
				Tick.simulatedTick();
			}
			Tick.simulatedTick();
		} else {
			for (int i = 0; i < controllRodDepthChange; i++) {
				ControllRodDepthReader.controllRodDepth = ControllRodDepthReader.controllRodDepth + 1;
				Tick.simulatedTick();
			}
			Tick.simulatedTick();
		}
	}
	
	private static void temperaturePowerSetter() {
		int temperatureChange = ThreadLocalRandom.current().nextInt(311 - temperature, 469 - temperature);
		
		if (temperatureChange < 0) {
			temperatureChange = temperatureChange * -1;
			
			for (int i = 0; i < temperatureChange; i++) {
				TemperatureReader.temperature = TemperatureReader.temperature - 1;
				Tick.simulatedTick();
			}
			Tick.simulatedTick();
		} else {
			for (int i = 0; i < temperatureChange; i++) {
				TemperatureReader.temperature = TemperatureReader.temperature + 1;
				Tick.simulatedTick();
			}
			Tick.simulatedTick();
		}
	}
	
	private static void initiateAllValues() {
		FuelRodReader.fuelRodAmount = ThreadLocalRandom.current().nextInt(2, 7);
		ControllRodDepthReader.controllRodDepth = ThreadLocalRandom.current().nextInt(15, 48);
		TemperatureReader.temperature = ThreadLocalRandom.current().nextInt(311, 469);
		PowerReader.power = ThreadLocalRandom.current().nextInt(217, 789);
		Tick.simulatedFirstTick();
		fuelRodAmount = FuelRodReader.fuelRodAmount;
		controllRodDepth = ControllRodDepthReader.controllRodDepth;
		temperature = TemperatureReader.temperature;
		power = PowerReader.power;
	}
	
	private static void resetValues() {
		FuelRodReader.fuelRodAmount = fuelRodAmount;
		ControllRodDepthReader.controllRodDepth = controllRodDepth;
		TemperatureReader.temperature = temperature;
		PowerReader.power = power;
	}
	
}
