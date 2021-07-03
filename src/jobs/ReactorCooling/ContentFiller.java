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
		dosElement.add(new DosElement(19,18,2,"Rueckflusstemperatur.exe")); //temp rück
		
		String[] 	content = new String[] {	
						"Befehle:",
						"",
						"DIR\tListet die Dateien und Unterverzeichnisse des aktuellen Verzeichnisses auf",
						"\ttipp: Gib jedes mal wenn du den ordner wechselst DIR ein",
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
						"oder den Dateinamen + Endung eingibst.",
						"In einer .exe Datei siehst du alle Werte und kannst für bestimmte Werte die Parameter anpassen.",
						"Verschiedene Zustände beeinflussen sich, sodass z.b. das Ändern der Durchflussrate die Temperatur beeinflusst.",
						"Gewisse werte dürfen einen bestimmten wert nicht überschreiten oder unterschreiten. Weitere informationen dazu",
						"in der \"werte.txt\".",
						"Wenn du fertig bist, führe die \"update.exe\" aus. Wenn alle werte stimmen, erhälst du dein Gehalt von Tobias Ingram."};
		dosElement.add(new DosElement(5,0,1,"help.txt",content));
					content = new String[] {
						"Hier sind die werte eingetragen die erreicht werden müssen. Die Werte ändern sich täglich entsprechend des",
						"Stromverbrauches der Mondbasis. Diese werte müssen innerhalb gewisser tolleranzen eingehalten werden.",
						"",
						"Werte:",
						"",
						"Kühlwasser:",
						"",
						"Temperatur:\t¢°C",
						"Toleranz:\t+/- 2°C",
						"",
						"Durchfluss:\t£ L/s",
						"Toleranz:\t+/- 100 L/s",
						"",
						"Rückwasser:",
						"",
						"Temperatur:\t¤°C",
						"Toleranz:\t+/- 5°C",
						"",
						"Reservoir:\t¥% gefüllt",
						"Toleranz:\t+/- 4%"}; //The symbols ¢, £, ¤, ¥ are later replaced with the actual numbers
		dosElement.add(new DosElement(6,0,1,"werte.txt",content));
					content = new String[] {
						"Der Durchfluss ist die menge an Wasser, die vom Reservoir zum Reaktor geleitet wird",
						"",
						"Die leistung der Pumpen regulieren den Durchfluss",
						"",
						"Änderung der Pumpenleistung:\t\t+ 10 GW (= Minimale Schrittweite)",
						"Resultierende Durchflussänderung:\t+ 10 L/s",
						"",
						"Änderung der Pumpenleistung:\t\t- 10 GW (= Minimale Schrittweite)",
						"Resultierende Durchflussänderung:\t- 10 L/s",
						"",
						"Maximale Pumpleistung: 300 GW pro Pumpe",
						"",
						"Beeinflusst durch änderung:",
						"",
						"Reservoirstand",
						"Rückwassertemperatur"};
			dosElement.add(new DosElement(11,7,1,"info.txt",content));
					content = new String[] {
						"Die Kühlwassertemperatur ist die Temperatur die das Kühlwasser hat bevor es in den Reaktor geleitet wird",
						"",
						"Die Temperatur wird reguliert durch Sublimationskühlung und durch erwärmen mit Solarzellen",
						"",
						"Änderung des durchflussanteils durch die Sublimationskühlung:\t+ 5% (= Minimale Schrittweite)",
						"Resultierende Temperaturänderung:\t\t\t\t- 1°C",
						"",
						"Änderung des durchflussanteils durch die Sublimationskühlung:\t- 5% (= Minimale Schrittweite)",
						"Resultierende Temperaturänderung:\t\t\t\t+ 1°C",
						"",
						"",
						"Änderung der durchflussanteils durch die Solarzellen:\t\t+ 5% (= Minimale Schrittweite)",
						"Resultierende Temperaturänderung:\t\t\t\t+ 4°C",
						"",
						"Änderung der durchflussanteils durch die Solarzellen:\t\t- 5% (= Minimale Schrittweite)",
						"Resultierende Temperaturänderung:\t\t\t\t- 4°C",
						"",
						"Beeinflusst durch änderung:",
						"",
						"Rückwassertemperatur"};
		dosElement.add(new DosElement(14,8,1,"info.txt",content));
					content = new String[] {
						"Das Reservoir beinhaltet eine große menge an Wasser die zum Kühlen verwendet wird",
						"",
						"Der Füllstand wird reguliert durch abgeben von Wasser an die Sublimationskühlanlage und durch",
						"schnelleres erhalten von Rückwasser",
						"",
						"Änderung der Wasseranteile in die Sublimationskühlung:\t+ 5% (= Minimale Schrittweite)",
						"Resultierende Reservoirfüllstandsänderung:\t\t- 5%",
						"",
						"Änderung der Wasseranteile in die Sublimationskühlung:\t- 5% (= Minimale Schrittweite)",
						"Resultierende Reservoirfüllstandsänderung:\t\t+ 5%",
						"",
						"",
						"Änderung der geschwindigkeit des Rückwassererhalts:\t+ 5% (= Minimale Schrittweite)",
						"Resultierende Reservoirfüllstandsänderung:\t\t+ 5%",
						"",
						"Änderung der geschwindigkeit des Rückwassererhalts:\t- 5% (= Minimale Schrittweite)",
						"Resultierende Reservoirfüllstandsänderung:\t\t- 5%",
						"",
						"Beeinflusst durch änderung:",
						"",
						"Kühlwassertemperatur"};
		dosElement.add(new DosElement(17,2,1,"info.txt",content));
					content = new String[] {
						"Die Rückwassertemperatur ist die Temperatur die das Kühlwasser hat nachdem es in den Reaktor geleitet wurde",
						"Bevor das Rückwasser ins Reservoir geleitet wird wird es weiter abkühlen gelassen (nicht relevant)",
						"",
						"Die Temperatur wird reguliert durch Sublimationskühlung und Heizleistung in der Kuppel",
						"",
						"Änderung des durchflussanteils durch die Sublimationskühlung:\t+ 5% (= Minimale Schrittweite)",
						"Resultierende Temperaturänderung:\t\t\t\t- 5°C",
						"",
						"Änderung des durchflussanteils durch die Sublimationskühlung:\t- 5% (= Minimale Schrittweite)",
						"Resultierende Temperaturänderung:\t\t\t\t+ 5°C",
						"",
						"",
						"Änderung der Heizleistung:\t\t\t\t\t+ 10 MW (= Minimale Schrittweite)",
						"Resultierende Temperaturänderung:\t\t\t\t- 5°C",
						"",
						"Änderung der Heizleistung:\t\t\t\t\t- 10 MW (= Minimale Schrittweite)",
						"Resultierende Temperaturänderung:\t\t\t\t+ 5°C",
						"",
						"Beeinflusst durch änderung:",
						"",
						"Kühlwassertemperatur"};
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
					
					content[j] = content[j].replaceFirst("¢", String.valueOf(TemperatureReader.temperature));
					content[j] = content[j].replaceFirst("£", String.valueOf(FlowRateReader.flowRate));
					content[j] = content[j].replaceFirst("¤", String.valueOf(RefluxTemperatureReader.temperature));
					content[j] = content[j].replaceFirst("¥", String.valueOf(ReservoirLevelReader.reservoirLevel));
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
