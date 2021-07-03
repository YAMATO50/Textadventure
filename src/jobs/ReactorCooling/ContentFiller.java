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
						"<DIR> = Verzeichnis = Ordner",
						"",
						"Funktionsweise:",
						"",
						"In den Verzeichnissen findest du Verzeichnisse und Dateien die du �ffnen kannst, indem du \"cd [name]\" f�r Verzeichnisse",
						"oder den Dateinamen + Endung eingibst.",
						"In einer .exe Datei siehst du alle Werte und kannst f�r bestimmte Werte die Parameter anpassen.",
						"Verschiedene Zust�nde beeinflussen sich, sodass z.b. das �ndern der Durchflussrate die Temperatur beeinflusst.",
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
						"Toleranz:\t+/- 4%"}; //The symbols �, �, �, � are later replaced with the actual numbers
		dosElement.add(new DosElement(6,0,1,"werte.txt",content));
					content = new String[] {
						"Der Durchfluss ist die menge an Wasser, die vom Reservoir zum Reaktor geleitet wird",
						"",
						"Die leistung der Pumpen regulieren den Durchfluss",
						"",
						"�nderung der Pumpenleistung:\t\t+ 10 GW (= Minimale Schrittweite)",
						"Resultierende Durchfluss�nderung:\t+ 10 L/s",
						"",
						"�nderung der Pumpenleistung:\t\t- 10 GW (= Minimale Schrittweite)",
						"Resultierende Durchfluss�nderung:\t- 10 L/s",
						"",
						"Maximale Pumpleistung: 300 GW pro Pumpe",
						"",
						"Beeinflusst durch �nderung:",
						"",
						"Reservoirstand",
						"R�ckwassertemperatur"};
			dosElement.add(new DosElement(11,7,1,"info.txt",content));
					content = new String[] {
						"Die K�hlwassertemperatur ist die Temperatur die das K�hlwasser hat bevor es in den Reaktor geleitet wird",
						"",
						"Die Temperatur wird reguliert durch Sublimationsk�hlung und durch erw�rmen mit Solarzellen",
						"",
						"�nderung des durchflussanteils durch die Sublimationsk�hlung:\t+ 5% (= Minimale Schrittweite)",
						"Resultierende Temperatur�nderung:\t\t\t\t- 1�C",
						"",
						"�nderung des durchflussanteils durch die Sublimationsk�hlung:\t- 5% (= Minimale Schrittweite)",
						"Resultierende Temperatur�nderung:\t\t\t\t+ 1�C",
						"",
						"",
						"�nderung der durchflussanteils durch die Solarzellen:\t\t+ 5% (= Minimale Schrittweite)",
						"Resultierende Temperatur�nderung:\t\t\t\t+ 4�C",
						"",
						"�nderung der durchflussanteils durch die Solarzellen:\t\t- 5% (= Minimale Schrittweite)",
						"Resultierende Temperatur�nderung:\t\t\t\t- 4�C",
						"",
						"Beeinflusst durch �nderung:",
						"",
						"R�ckwassertemperatur"};
		dosElement.add(new DosElement(14,8,1,"info.txt",content));
					content = new String[] {
						"Das Reservoir beinhaltet eine gro�e menge an Wasser die zum K�hlen verwendet wird",
						"",
						"Der F�llstand wird reguliert durch abgeben von Wasser an die Sublimationsk�hlanlage und durch",
						"schnelleres erhalten von R�ckwasser",
						"",
						"�nderung der Wasseranteile in die Sublimationsk�hlung:\t+ 5% (= Minimale Schrittweite)",
						"Resultierende Reservoirf�llstands�nderung:\t\t- 5%",
						"",
						"�nderung der Wasseranteile in die Sublimationsk�hlung:\t- 5% (= Minimale Schrittweite)",
						"Resultierende Reservoirf�llstands�nderung:\t\t+ 5%",
						"",
						"",
						"�nderung der geschwindigkeit des R�ckwassererhalts:\t+ 5% (= Minimale Schrittweite)",
						"Resultierende Reservoirf�llstands�nderung:\t\t+ 5%",
						"",
						"�nderung der geschwindigkeit des R�ckwassererhalts:\t- 5% (= Minimale Schrittweite)",
						"Resultierende Reservoirf�llstands�nderung:\t\t- 5%",
						"",
						"Beeinflusst durch �nderung:",
						"",
						"K�hlwassertemperatur"};
		dosElement.add(new DosElement(17,2,1,"info.txt",content));
					content = new String[] {
						"Die R�ckwassertemperatur ist die Temperatur die das K�hlwasser hat nachdem es in den Reaktor geleitet wurde",
						"Bevor das R�ckwasser ins Reservoir geleitet wird wird es weiter abk�hlen gelassen (nicht relevant)",
						"",
						"Die Temperatur wird reguliert durch Sublimationsk�hlung und Heizleistung in der Kuppel",
						"",
						"�nderung des durchflussanteils durch die Sublimationsk�hlung:\t+ 5% (= Minimale Schrittweite)",
						"Resultierende Temperatur�nderung:\t\t\t\t- 5�C",
						"",
						"�nderung des durchflussanteils durch die Sublimationsk�hlung:\t- 5% (= Minimale Schrittweite)",
						"Resultierende Temperatur�nderung:\t\t\t\t+ 5�C",
						"",
						"",
						"�nderung der Heizleistung:\t\t\t\t\t+ 10 MW (= Minimale Schrittweite)",
						"Resultierende Temperatur�nderung:\t\t\t\t- 5�C",
						"",
						"�nderung der Heizleistung:\t\t\t\t\t- 10 MW (= Minimale Schrittweite)",
						"Resultierende Temperatur�nderung:\t\t\t\t+ 5�C",
						"",
						"Beeinflusst durch �nderung:",
						"",
						"K�hlwassertemperatur"};
		dosElement.add(new DosElement(21,18,1,"info.txt",content));
			
		DOS.dosElement = dosElement;
	}

	public static int targetTemperature;
	public static int targetFlowRate;
	public static int targetRefluxTemperature;
	public static int targetReservoirLevel;
	
	private static int temperature;
	private static int flowRate;
	private static int refluxTemperature;
	private static int reservoirLevel;
	
	public static void setValues() {
		
		initiateAllValues();
		
		temperatureSetter();
		flowRateSetter();
		refluxTemperatureSetter();
		reservoirLevelSetter();
		
		for (int i = 0; i < DOS.dosElement.size(); i++) {
			if (DOS.dosElement.get(i).location == 6) {
				String[] content = DOS.dosElement.get(i).fileContent;
				for (int j = 0; j < content.length; j++) {
					
					content[j] = content[j].replaceFirst("�", String.valueOf(TemperatureReader.temperature));
					content[j] = content[j].replaceFirst("�", String.valueOf(FlowRateReader.flowRate));
					content[j] = content[j].replaceFirst("�", String.valueOf(RefluxTemperatureReader.temperature));
					content[j] = content[j].replaceFirst("�", String.valueOf(ReservoirLevelReader.reservoirLevel));
				}
				DOS.dosElement.get(i).fileContent = content;
				break;
			}
		}
		resetValues();
	}
	
	private static void temperatureSetter() {
		//Defining "0"
		int cooling = ThreadLocalRandom.current().nextInt(2,9);
		int heating = ThreadLocalRandom.current().nextInt(4,7);
		
		ChangeParameter.sublimationRate = cooling;
		ChangeParameter.solarRate = heating;
		
		int coolingSteps = ThreadLocalRandom.current().nextInt(1-cooling,9-cooling);
		
		if (coolingSteps < 0) {
			coolingSteps = coolingSteps * -1;
			
			for (int i = 0; i < coolingSteps; i++) {
				TemperatureReader.temperature += 2;
				ChangeParameter.sublimationRate -= 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		} else {
			for (int i = 0; i < coolingSteps; i++) {
				TemperatureReader.temperature -= 2;
				ChangeParameter.sublimationRate += 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		}
		
		
		int solarSteps = ThreadLocalRandom.current().nextInt(4-heating,9-heating);
		
		if (solarSteps < 0) {
			solarSteps = solarSteps * -1;
			
			for (int i = 0; i < solarSteps; i++) {
				TemperatureReader.temperature -= 8;
				ChangeParameter.solarRate -= 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		} else {
			for (int i = 0; i < solarSteps; i++) {
				TemperatureReader.temperature += 8;
				ChangeParameter.solarRate += 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		}
		
		ChangeParameter.sublimationRate = cooling * 10;
		ChangeParameter.solarRate = heating * 10;
		
	}
	
	private static void flowRateSetter() {
		int currentFlow = FlowRateReader.flowRate;
		
		//Defining "0"
		int flowRate = currentFlow;
		
		ChangeParameter.pumpPower = flowRate;
		
		int flowSteps = ThreadLocalRandom.current().nextInt(200-flowRate,1000-flowRate);
		
		if (flowSteps < 0) {
			flowSteps = flowSteps * -1;
			
			for (int i = 0; i < flowSteps; i++) {
				FlowRateReader.flowRate -= 1;
				ChangeParameter.pumpPower -= 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		} else {
			for (int i = 0; i < flowSteps; i++) {
				FlowRateReader.flowRate += 1;
				ChangeParameter.pumpPower += 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		}
		
		ChangeParameter.pumpPower = flowRate;
		
	}
	
	private static void refluxTemperatureSetter() {
		//Defining "0"
		int cooling = ThreadLocalRandom.current().nextInt(2,9);
		int heating = ThreadLocalRandom.current().nextInt(10,40);
		
		ChangeParameter.refluxSublimationRate = cooling;
		ChangeParameter.refluxHeatPower = heating;
		
		int coolingSteps = ThreadLocalRandom.current().nextInt(1-cooling,9-cooling);
		
		if (coolingSteps < 0) {
			coolingSteps = coolingSteps * -1;
			
			for (int i = 0; i < coolingSteps; i++) {
				RefluxTemperatureReader.temperature += 10;
				ChangeParameter.refluxSublimationRate -= 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		} else {
			for (int i = 0; i < coolingSteps; i++) {
				RefluxTemperatureReader.temperature -= 10;
				ChangeParameter.refluxSublimationRate += 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		}
		
		int heaterSteps = ThreadLocalRandom.current().nextInt(10-heating,40-heating);
		
		if (heaterSteps < 0) {
			heaterSteps = heaterSteps * -1;
			
			for (int i = 0; i < heaterSteps; i++) {
				RefluxTemperatureReader.temperature -= 5;
				ChangeParameter.refluxHeatPower -= 10;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		} else {
			for (int i = 0; i < heaterSteps; i++) {
				RefluxTemperatureReader.temperature += 5;
				ChangeParameter.refluxHeatPower += 10;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		}
		
		ChangeParameter.refluxSublimationRate = cooling * 10;
		ChangeParameter.refluxHeatPower = heating * 10;
		
		
	}

	private static void reservoirLevelSetter() {
		//Defining "0"
		int sublimationParts = ThreadLocalRandom.current().nextInt(2,9);
		int fasterGain = ThreadLocalRandom.current().nextInt(2,9);
		
		ChangeParameter.reservoirSublimationRate = sublimationParts;
		ChangeParameter.getRefluxWaterRate = fasterGain;
		
		int sublimationRateSteps = ThreadLocalRandom.current().nextInt(1-sublimationParts,9-sublimationParts);
		
		if (sublimationRateSteps < 0) {
			sublimationRateSteps = sublimationRateSteps * -1;
			
			for (int i = 0; i < sublimationRateSteps; i++) {
				ReservoirLevelReader.reservoirLevel += 10;
				ChangeParameter.reservoirSublimationRate -= 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		} else {
			for (int i = 0; i < sublimationRateSteps; i++) {
				ReservoirLevelReader.reservoirLevel -= 10;
				ChangeParameter.reservoirSublimationRate += 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		}
		
		int fasterGainSteps = ThreadLocalRandom.current().nextInt(1-fasterGain,9-fasterGain);
		
		if (fasterGainSteps < 0) {
			fasterGainSteps = fasterGainSteps * -1;
			
			for (int i = 0; i < fasterGainSteps; i++) {
				ReservoirLevelReader.reservoirLevel -= 10;
				ChangeParameter.getRefluxWaterRate -= 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		} else {
			for (int i = 0; i < fasterGainSteps; i++) {
				ReservoirLevelReader.reservoirLevel += 10;
				ChangeParameter.getRefluxWaterRate += 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		}
		
		ChangeParameter.reservoirSublimationRate = sublimationParts * 10;
		ChangeParameter.getRefluxWaterRate = fasterGain * 10;
		
	}
	
	private static void initiateAllValues() {
		TemperatureReader.temperature = ThreadLocalRandom.current().nextInt(30,50);
		FlowRateReader.flowRate = ThreadLocalRandom.current().nextInt(1000,11000);
		RefluxTemperatureReader.temperature = ThreadLocalRandom.current().nextInt(85,240);
		ReservoirLevelReader.reservoirLevel = ThreadLocalRandom.current().nextInt(45,100);
		Tick.simulateFirstTick();
		temperature = TemperatureReader.temperature;
		flowRate = FlowRateReader.flowRate;
		refluxTemperature = RefluxTemperatureReader.temperature;
		reservoirLevel = ReservoirLevelReader.reservoirLevel;
	}
	
	private static void resetValues() {
		TemperatureReader.temperature = temperature;
		FlowRateReader.flowRate = flowRate;
		RefluxTemperatureReader.temperature = refluxTemperature;
		ReservoirLevelReader.reservoirLevel = reservoirLevel;
	}
}
