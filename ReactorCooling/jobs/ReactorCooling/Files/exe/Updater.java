package jobs.ReactorCooling.Files.exe;

import jobs.ReactorCooling.Parameters;
import jobs.ReactorCooling.ContentFiller;
import jobs.ReactorCooling.DOS;
import jobs.ReactorCooling.FlowRateReader;
import jobs.ReactorCooling.RefluxTemperatureReader;
import jobs.ReactorCooling.ReservoirLevelReader;
import jobs.ReactorCooling.TemperatureReader;
import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class Updater implements DOSProgrammInterface {
	
	public void execute() {
		int temperaturDiff, flowRateDiff, refluxTemperaturDiff, reservoirLevelDiff;
		
		temperaturDiff = Math.abs(ContentFiller.targetTemperature - TemperatureReader.temperature);
		flowRateDiff = Math.abs(ContentFiller.targetFlowRate - FlowRateReader.flowRate);
		refluxTemperaturDiff = Math.abs(ContentFiller.targetRefluxTemperature - RefluxTemperatureReader.temperature);
		reservoirLevelDiff = Math.abs(ContentFiller.targetReservoirLevel - ReservoirLevelReader.reservoirLevel);
		
		boolean temperatur = false;
		boolean refluxTemperatur = false;
		boolean flowRate = false;
		boolean reservoir = false;
		
		if (temperaturDiff <= 2) {
			temperatur = true;
		}
		
		if (flowRateDiff <= 100) {
			flowRate = true;
		}
		
		if (refluxTemperaturDiff <= 5) {
			refluxTemperatur = true;
		}
		
		if (reservoirLevelDiff <= 4) {
			reservoir = true;
		}
		
		int choice = 0;
		
		if (temperatur && refluxTemperatur && flowRate && reservoir) {
			System.out.println();
			System.out.println("Alle Parameter sind inerhalb der angeforderten Toleranzen");
			System.out.println("M�chtest du alle Maschienen Updaten?");
			System.out.println();
			System.out.println("[1] Ja");
			System.out.println("[2] Nein");
			System.out.println();
			
			do {
				choice = Parameters.getUserInput();
				
				switch (choice) {
				case 1:
					DOS.loop = false;
					Parameters.succes = true;
					break;
				case 2:
					break;
				default:
					System.out.println("Bitte gib eine g�ltige zahl ein!");
					choice = -1;
				}
				
			} while (choice == -1);
			
			
		} else {
			
			System.out.println();
			System.out.println("Einige Parameter sind noch nicht korrekt eingestellt!");
			System.out.println("Folgende parameter sind noch Falsch eingestellt:");
			System.out.println();
			
			if (!temperatur) {
				System.out.println("K�hlwassertemperatur");
			}
			
			if (!flowRate) {
				System.out.println("Durchflussgeschwindigkeit");
			}
			
			if (!refluxTemperatur) {
				System.out.println("R�ckwassertemperatur");
			}
			
			if (!reservoir) {
				System.out.println("Reservoir F�llstand");
			}
			
			System.out.println();
			System.out.println("M�chtest du trotzdem alle Maschienen Updaten?");
			System.out.println();
			System.out.println("[1] Ja");
			System.out.println("[2] Nein");
			System.out.println();
			
			do {
				choice = Parameters.getUserInput();
				
				switch (choice) {
				case 1:
					DOS.loop = false;
					Parameters.succes = false;
					break;
				case 2:
					break;
				default:
					System.out.println("Bitte gib eine g�ltige zahl ein!");
					choice = -1;
				}
				
			} while (choice == -1);
		}
	}

	public String[] getContents() {
		return null;
	}

	public void setContents(String[] content) {
		
	}

}
