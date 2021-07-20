package jobs.ReactorCooling;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import jobs.ReactorCooling.Files.*;
import jobs.ReactorCooling.Files.exe.*;
import jobs.ReactorCooling.Files.txt.*;
import jobs.ReactorCooling.Files.commands.*;

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
		
		dosElement.add(new DosElement(5,0,1,"help.txt"));
		dosElement.add(new DosElement(6,0,1,"werte.txt"));
		dosElement.add(new DosElement(11,7,1,"FlowrateInfo.txt"));
		dosElement.add(new DosElement(14,8,1,"TemperatureInfo.txt"));
		dosElement.add(new DosElement(17,2,1,"ReservoirInfo.txt"));
		dosElement.add(new DosElement(21,18,1,"RefluxInfo.txt"));
			
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
		
		fillValuesInTextFile();
				
		resetValues();
	}
	
	private static void temperatureSetter() {
		//Defining "0"
		int cooling = ThreadLocalRandom.current().nextInt(2,9);
		int heating = ThreadLocalRandom.current().nextInt(4,7);
		
		Parameters.sublimationRate = cooling;
		Parameters.solarRate = heating;
		
		int coolingSteps = ThreadLocalRandom.current().nextInt(1-cooling,9-cooling);
		
		if (coolingSteps < 0) {
			coolingSteps = coolingSteps * -1;
			
			for (int i = 0; i < coolingSteps; i++) {
				TemperatureReader.temperature += 2;
				Parameters.sublimationRate -= 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		} else {
			for (int i = 0; i < coolingSteps; i++) {
				TemperatureReader.temperature -= 2;
				Parameters.sublimationRate += 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		}
		
		
		int solarSteps = ThreadLocalRandom.current().nextInt(4-heating,9-heating);
		
		if (solarSteps < 0) {
			solarSteps = solarSteps * -1;
			
			for (int i = 0; i < solarSteps; i++) {
				TemperatureReader.temperature -= 8;
				Parameters.solarRate -= 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		} else {
			for (int i = 0; i < solarSteps; i++) {
				TemperatureReader.temperature += 8;
				Parameters.solarRate += 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		}
		
		Parameters.sublimationRate = cooling * 10;
		Parameters.solarRate = heating * 10;
		
	}
	
	private static void flowRateSetter() {
		int currentFlow = FlowRateReader.flowRate;
		
		//Defining "0"
		int flowRate = currentFlow;
		
		Parameters.pumpPower = flowRate;
		
		int flowSteps = ThreadLocalRandom.current().nextInt(200-flowRate,1000-flowRate);
		
		if (flowSteps < 0) {
			flowSteps = flowSteps * -1;
			
			for (int i = 0; i < flowSteps; i++) {
				FlowRateReader.flowRate -= 1;
				Parameters.pumpPower -= 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		} else {
			for (int i = 0; i < flowSteps; i++) {
				FlowRateReader.flowRate += 1;
				Parameters.pumpPower += 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		}
		
		Parameters.pumpPower = flowRate;
		
	}
	
	private static void refluxTemperatureSetter() {
		//Defining "0"
		int cooling = ThreadLocalRandom.current().nextInt(2,9);
		int heating = ThreadLocalRandom.current().nextInt(10,40);
		
		Parameters.refluxSublimationRate = cooling;
		Parameters.refluxHeatPower = heating;
		
		int coolingSteps = ThreadLocalRandom.current().nextInt(1-cooling,9-cooling);
		
		if (coolingSteps < 0) {
			coolingSteps = coolingSteps * -1;
			
			for (int i = 0; i < coolingSteps; i++) {
				RefluxTemperatureReader.temperature += 10;
				Parameters.refluxSublimationRate -= 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		} else {
			for (int i = 0; i < coolingSteps; i++) {
				RefluxTemperatureReader.temperature -= 10;
				Parameters.refluxSublimationRate += 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		}
		
		int heaterSteps = ThreadLocalRandom.current().nextInt(10-heating,40-heating);
		
		if (heaterSteps < 0) {
			heaterSteps = heaterSteps * -1;
			
			for (int i = 0; i < heaterSteps; i++) {
				RefluxTemperatureReader.temperature -= 5;
				Parameters.refluxHeatPower -= 10;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		} else {
			for (int i = 0; i < heaterSteps; i++) {
				RefluxTemperatureReader.temperature += 5;
				Parameters.refluxHeatPower += 10;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		}
		
		Parameters.refluxSublimationRate = cooling * 10;
		Parameters.refluxHeatPower = heating * 10;
		
		
	}

	private static void reservoirLevelSetter() {
		//Defining "0"
		int sublimationParts = ThreadLocalRandom.current().nextInt(2,9);
		int fasterGain = ThreadLocalRandom.current().nextInt(2,9);
		
		Parameters.reservoirSublimationRate = sublimationParts;
		Parameters.getRefluxWaterRate = fasterGain;
		
		int sublimationRateSteps = ThreadLocalRandom.current().nextInt(1-sublimationParts,9-sublimationParts);
		
		if (sublimationRateSteps < 0) {
			sublimationRateSteps = sublimationRateSteps * -1;
			
			for (int i = 0; i < sublimationRateSteps; i++) {
				ReservoirLevelReader.reservoirLevel += 10;
				Parameters.reservoirSublimationRate -= 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		} else {
			for (int i = 0; i < sublimationRateSteps; i++) {
				ReservoirLevelReader.reservoirLevel -= 10;
				Parameters.reservoirSublimationRate += 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		}
		
		int fasterGainSteps = ThreadLocalRandom.current().nextInt(1-fasterGain,9-fasterGain);
		
		if (fasterGainSteps < 0) {
			fasterGainSteps = fasterGainSteps * -1;
			
			for (int i = 0; i < fasterGainSteps; i++) {
				ReservoirLevelReader.reservoirLevel -= 10;
				Parameters.getRefluxWaterRate -= 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		} else {
			for (int i = 0; i < fasterGainSteps; i++) {
				ReservoirLevelReader.reservoirLevel += 10;
				Parameters.getRefluxWaterRate += 1;
				Tick.simulateTick();
			}
			Tick.simulateTick();
		}
		
		Parameters.reservoirSublimationRate = sublimationParts * 10;
		Parameters.getRefluxWaterRate = fasterGain * 10;
		
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
	
	private static void fillValuesInTextFile() {
		String[] content = DOS.programms.get("werte.txt").getContents();
		
		for (int j = 0; j < content.length; j++) {
					
			content[j] = content[j].replaceFirst("¢", String.valueOf(TemperatureReader.temperature));
			content[j] = content[j].replaceFirst("£", String.valueOf(FlowRateReader.flowRate));
			content[j] = content[j].replaceFirst("¤", String.valueOf(RefluxTemperatureReader.temperature));
			content[j] = content[j].replaceFirst("¥", String.valueOf(ReservoirLevelReader.reservoirLevel));
		}

		DOS.programms.get("werte.txt").setContents(content);
	}
	
	private static void resetValues() {
		TemperatureReader.temperature = temperature;
		FlowRateReader.flowRate = flowRate;
		RefluxTemperatureReader.temperature = refluxTemperature;
		ReservoirLevelReader.reservoirLevel = reservoirLevel;
	}
	
	public static void fillProgramms() {
		DOS.programms = new HashMap<String, DOSProgrammInterface>();
		DOS.programms.put("pumpen.exe", new FlowRate());
		DOS.programms.put("Kuehlwassertemperatur.exe", new Temperature());
		DOS.programms.put("reservoir.exe", new ReservoirLevel());
		DOS.programms.put("rueckflusstemperatur.exe", new RefluxTemperature());
		DOS.programms.put("update.exe", new Updater());
		
		DOS.programms.put("help.txt", new HelpText());
		DOS.programms.put("werte.txt", new WerteText());
		DOS.programms.put("flowrateinfo.txt", new FlowrateInfoText());
		DOS.programms.put("temperatureinfo.txt", new TemperatureInfoText());
		DOS.programms.put("reservoirinfo.txt", new ReservoirInfoText());
		DOS.programms.put("refluxinfo.txt", new RefluxInfoText());
		
		DOS.programms.put("cd", new Cd());
		DOS.programms.put("dir", new Dir());
		DOS.programms.put("echo", new Echo());
		DOS.programms.put("help", new Help());
	}
}
