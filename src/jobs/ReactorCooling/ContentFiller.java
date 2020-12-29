package jobs.ReactorCooling;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ContentFiller {

	private static ArrayList<DosElement> dosElement = new ArrayList<DosElement>();
	
	public static void fill() {
		dosElement.add(new DosElement(0,-1,new int[] {1,2,3,4,5,6},0,"D:\\Pump",false));
		dosElement.add(new DosElement(1,0,new int[] {7,8},0,"Kuehlwasser",true));
		dosElement.add(new DosElement(7,1,new int[] {9,11},0,"Durchfluss",true));
		dosElement.add(new DosElement(8,1,new int[] {12,14},0,"Temperatur",true));
		dosElement.add(new DosElement(2,0,new int[] {15,17},0,"Reservoir",true));
		dosElement.add(new DosElement(3,0,new int[] {18},0,"Rueckwasser",true));
		dosElement.add(new DosElement(18,3,new int[] {19,21},0,"Temperatur",true));
		
		dosElement.add(new DosElement(4,0,2,"update.exe"));
		dosElement.add(new DosElement(9,7,2,"Pumpen.exe")); //flow rate
		dosElement.add(new DosElement(12,8,2,"Kuehlwassertemperatur.exe")); //temp
		dosElement.add(new DosElement(15,2,2,"Reservoir.exe")); // reservoir
		dosElement.add(new DosElement(19,18,2,"Rueckflusstemperatur.exe")); //temp r�ck
		
		String[] 	content = new String[] {	
						"Befehle:",
						"",
						"DIR\tListet die Dateien und Unterverzeichnisse des aktuellen Verzeichnisses auf",
						"\ttipp: Gib jedes mal wenn du den ordner wechselst DIR ein",
						"CD\t�ndert das Verzeichniss in das dahinter angegebene Verzeichniss",
						"\tBesonderheiten:",
						"\t.\t�ndert nichts",
						"\t..\tGeht ein Verzeichniss zur�ck",
						"ECHO\tGibt die dahinter angegebene nachricht aus",
						"",
						"Um eine Datei zu �ffnen gib einfach den Namen der Datei ein (mit Endung)",
						"",
						"<DIR> = Verzeichnis",
						"",
						"Funktionsweise:",
						"",
						"Eine \"*reader.exe\" gibt den aktuellen zustand zur�ck.",
						"Beispiel: die \"temperatur reader.exe\" (z.b. f�r das K�hlwasser) gibt die aktuelle Temperatur des K�hlwassers zur�ck.",
						"�ber die \"change parameter.exe\" Dateien lassen sich diverse parameter einstellen, um die zust�nde zu �ndern.",
						"Verschiedene zust�nde beeinflussen sich, sodass z.b. Das �ndern der Durchflussrate die Temperatur beeinflusst.",
						"Gewisse werte d�rfen einen bestimmten wert nicht �berschreiten oder unterschreiten. Weitere informationen dazu",
						"in der \"werte.txt\".",
						"Wenn du fertig bist, f�hre die \"update.exe\" aus. Wenn alle werte stimmen, erh�lst du dein Gehalt von Tobias Ingram."};
		dosElement.add(new DosElement(5,0,1,"help.txt",content));
					content = new String[] {
						"Hier sind die werte eingetragen die erreicht werden m�ssen. Die Werte �ndern sich t�glich entsprechend des",
						"Stromverbrauches der Mondbasis. Diese werte m�ssen innerhalb gewisser tolleranzen eingehalten werden.",
						"",
						"Werte:",
						"",
						"K�hlwasser:",
						"",
						"Temperatur:\t��C",
						"Toleranz:\t+/- 2�C",
						"",
						"Durchfluss:\t� L/s",
						"Toleranz:\t+/- 100 L/s",
						"",
						"R�ckwasser:",
						"",
						"Temperatur:\t��C",
						"Toleranz:\t+/- 5�C",
						"",
						"Reservoir:\t�% gef�llt",
						"Toleranz:\t+/- 4%"};
		dosElement.add(new DosElement(6,0,1,"werte.txt",content));
					content = new String[] {
						"Der Durchfluss ist die menge an Wasser, die vom Reservoir zum Reaktor geleitet wird",
						"",
						"Die leistung der Pumpen regulieren den Durchfluss",
						"",
						"�nderung der Pumpenleistung:\t\t+/- 10 GW (= Minimale Schrittweite)",
						"Resultierende Durchfluss�nderung:\t+/- 10 L/s",
						"",
						"Maximale Pumpleistung: 300 GW pro Pumpe",
						"",
						"Beeinflusst durch �nderung:",
						"",
						"Reservoirstand:\t\t\t\t+/- 1%   pro 1000 L/s",
						"R�ckwassertemperatur:\t\t\t+/- 10�C pro 1000 L/s"};
			dosElement.add(new DosElement(11,7,1,"info.txt",content));
					content = new String[] {
						"Die K�hlwassertemperatur ist die Temperatur die das K�hlwasser hat bevor es in den Reaktor geleitet wird",
						"",
						"Die Temperatur wird reguliert durch Sublimationsk�hlung und durch erw�rmen mit Solarzellen",
						"",
						"�nderung des durchflussanteils durch die Sublimationsk�hlung:\t+/- 5% (= Minimale Schrittweite)",
						"Resultierende Temperatur�nderung:\t\t\t\t-/+ 1�C",
						"",
						"�nderung der durchflussanteils durch die Solarzellen:\t\t+/- 5% (= Minimale Schrittweite)",
						"Resultierende Temperatur�nderung:\t\t\t\t+/- 2�C",
						"",
						"Beeinflusst durch �nderung:",
						"",
						"R�ckwassertemperatur:\t\t\t\t\t\t+/- 2�C pro 5�C"};
		dosElement.add(new DosElement(14,8,1,"info.txt",content));
					content = new String[] {
						"Das Reservoir beinhaltet eine gro�e menge an Wasser die zum K�hlen verwendet wird",
						"",
						"Der F�llstand wird reguliert durch abgeben von Wasser an die Sublimationsk�hlanlage und durch",
						"schnelleres erhalten von R�ckwasser",
						"",
						"�nderung der Wasseranteile in die Sublimationsk�hlung:\t+/- 5% (= Minimale Schrittweite)",
						"Resultierende Reservoirf�llstands�nderung:\t\t-/+ 5%",
						"",
						"�nderung der geschwindigkeit des R�ckwassererhalts:\t+/- 5% (= Minimale Schrittweite)",
						"Resultierende Reservoirf�llstands�nderung:\t\t+/- 5%",
						"",
						"Beeinflusst durch �nderung:",
						"",
						"K�hlwassertemperatur:\t\t\t\t\t-/+ 1�C pro 10% F�llstands�nderung"};
		dosElement.add(new DosElement(17,2,1,"info.txt",content));
					content = new String[] {
						"Die R�ckwassertemperatur ist die Temperatur die das K�hlwasser hat nachdem es in den Reaktor geleitet wurde",
						"Bevor das R�ckwasser ins Reservoir geleitet wird wird es weiter abk�hlen gelassen (nicht relevant)",
						"",
						"Die Temperatur wird reguliert durch Sublimationsk�hlung und Heizleistung in der Kuppel",
						"",
						"�nderung des durchflussanteils durch die Sublimationsk�hlung:\t+/- 5% (= Minimale Schrittweite)",
						"Resultierende Temperatur�nderung:\t\t\t\t-/+ 5�C",
						"",
						"�nderung der Heizleistung:\t\t\t\t\t+/- 10 MW (= Minimale Schrittweite)",
						"Resultierende Temperatur�nderung:\t\t\t\t-/+ 5�C",
						"",
						"Beeinflusst durch �nderung:",
						"",
						"K�hlwassertemperatur:\t\t\t\t\t\t+/- 2�C pro 10�C"};
		dosElement.add(new DosElement(21,18,1,"info.txt",content));
			
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
					
					content[j] = content[j].replaceFirst("�", String.valueOf(targetTemperature));
					content[j] = content[j].replaceFirst("�", String.valueOf(targetFlowRate));
					content[j] = content[j].replaceFirst("�", String.valueOf(targetRefluxTemperature));
					content[j] = content[j].replaceFirst("�", String.valueOf(targetReservoirLevel));
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
