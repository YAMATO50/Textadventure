package jobs.ReactorCooling;

import adventure.text.Config;
import adventure.text.TextTools;

public class ChangeParameter {

	public static int sublimationRate;
	public static int solarRate;
	
	public static void temperature() {
		System.out.println();
		System.out.print("Berechne");
		TextTools.dddln();
		System.out.println();
		boolean stay = true;
		while (stay) {
			showStates();
			System.out.println("Was mˆchtest du tun?");
			System.out.println("[1] Durchflussanteil durch Sublimationsk¸hlung ‰ndern");
			System.out.println("[2] Durchflussanteil durch Solarzellen ‰ndern");
			System.out.println("[3] Exit");
			System.out.println();
			
			int choice;
			do {
				choice = getUserInput();
			} while (choice == -1);
			
			switch (choice) {
			case 1:
				sublimation();
				break;
			case 2:
				solar();
				break;
			case 3:
				stay = false;
				break;
			default:
				System.out.println("Bitte gib eine G¸ltige zahl ein!");
			}
			
		}
	}
	
	public static void sublimation() {
		System.out.println("aktuell flieﬂen " + sublimationRate + "% des K¸hlwassers durch die Sublimationsk¸hlung");
		System.out.println();
		System.out.println("Durchflussanteile durch die Sublimationsk¸hlung...");
		System.out.println("[1] Erhˆhen");
		System.out.println("[2] Verringern");
		System.out.println();
		
		int choice;
		do {
			choice = getUserInput();
		} while (choice == -1);
		
		if (choice == 1) {
			System.out.println();
			System.out.println("Um wieviele 5% schritte mˆchtest du den Anteil erhˆhen?");
			System.out.println("Verf¸gbare schritte: " + ((100 - sublimationRate) / 5));
			
			do {
				choice = getUserInput();
			} while (choice == -1);
			
			if (choice > (100 - sublimationRate) / 5) {
				System.out.println("Deine zahl ist zu groﬂ!");
			} else if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			} else {
				sublimationRate = sublimationRate + (choice * 5);
				TemperatureReader.temperature = TemperatureReader.temperature - choice;
			}
			
		} else if (choice == 2) {
			System.out.println();
			System.out.println("Um wieviele 5% schritte mˆchtest du den Anteil verringern?");
			System.out.println("Verf¸gbare schritte: " + (sublimationRate / 5));
			
			do {
				choice = getUserInput();
			} while (choice == -1);
			
			if (choice > sublimationRate / 5) {
				System.out.println("Deine zahl ist zu groﬂ!");
			} else if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			} else {
				sublimationRate = sublimationRate - (choice * 5);
				TemperatureReader.temperature = TemperatureReader.temperature + choice;
			}
		} else {
			System.out.println("Bitte gib eine g¸ltige Zahl ein!");
		}
	}
	
	public static void solar() {
		System.out.println("aktuell flieﬂen " + solarRate + "% des K¸hlwassers durch die Solarzellen");
		System.out.println();
		System.out.println("Durchflussanteile durch die Solarzellen...");
		System.out.println("[1] Erhˆhen");
		System.out.println("[2] Verringern");
		System.out.println();
		
		int choice;
		do {
			choice = getUserInput();
		} while (choice == -1);
		
		if (choice == 1) {
			System.out.println();
			System.out.println("Um wieviele 5% schritte mˆchtest du den Anteil erhˆhen?");
			System.out.println("Verf¸gbare schritte: " + ((100 - solarRate) / 5));
			
			do {
				choice = getUserInput();
			} while (choice == -1);
			
			if (choice > (100 - solarRate) / 5) {
				System.out.println("Deine zahl ist zu groﬂ!");
			} else if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			} else {
				solarRate = solarRate + (choice * 5);
				TemperatureReader.temperature = TemperatureReader.temperature + choice * 2;
			}
		} else if (choice == 2) {
			System.out.println();
			System.out.println("Um wieviele 5% schritte mˆchtest du den Anteil verringern?");
			System.out.println("Verf¸gbare schritte: " +  solarRate / 5);
			
			do {
				choice = getUserInput();
			} while (choice == -1);
			
			if (choice > solarRate / 5) {
				System.out.println("Deine zahl ist zu groﬂ!");
			} else if (choice < 0) {
				System.out.println("Deine zahl ist zu klein!");
			} else {
				solarRate = solarRate + (choice * 5);
				TemperatureReader.temperature = TemperatureReader.temperature - choice * 2;
			}
		} else {
			System.out.println("Bitte gib eine g¸ltige Zahl ein!");
		}
	}

	public static int pumpPower;
	
	public static void flowRate() {
		System.out.println();
		System.out.print("Berechne");
		TextTools.dddln();
		System.out.println();
		boolean stay = true;
		while (stay) {
			showStates();
			System.out.println("Was mˆchtest du tun?");
			System.out.println("[1] Pumpleistung der K¸hlwasserpumpen ƒndern");
			System.out.println("[2] Exit");
			System.out.println();
			
			int choice;
			do {
				choice = getUserInput();
			} while (choice == -1);
			
			switch (choice) {
			case 1:
				System.out.println("Aktuelle Gesammtpumpleistung: " + pumpPower + " GW");
				System.out.println();
				System.out.println("Gesammtpumpleistung...");
				System.out.println("[1] Erhˆhen");
				System.out.println("[2] Verringern");
				System.out.println();
				
				do {
					choice = getUserInput();
				} while (choice == -1);
				
				if (choice == 1) {
					
					System.out.println();
					System.out.println("Um wieviele 10 GW schritte mˆchtest du die Leistung erhˆhen?");
					System.out.println("Verf¸gbare schritte: " + (15000 - pumpPower) / 10);
					
					do {
						choice = getUserInput();
					} while (choice == -1);
					
					if (choice > (15000 - pumpPower) / 10) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						pumpPower = pumpPower + choice * 10;
						FlowRateReader.flowRate = FlowRateReader.flowRate + choice * 10;
					}
					
				} else if (choice == 2) {
					System.out.println();
					System.out.println("Um wieviele 10 GW schritte mˆchtest du die Leistung verringern?");
					System.out.println("Verf¸gbare schritte: " + pumpPower / 10);
					
					do {
						choice = getUserInput();
					} while (choice == -1);
					
					if (choice > pumpPower / 10) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						pumpPower = pumpPower - choice * 10;
						FlowRateReader.flowRate = FlowRateReader.flowRate - choice * 10;
					}
				} else {
					System.out.println("Bitte gib eine G¸ltige zahl ein!");
				}
				
				break;
			case 2:
				stay = false;
				break;
			default:
				System.out.println("Bitte gib eine G¸ltige zahl ein!");
			}
			
		}
	}
	
	public static int reservoirSublimationRate;
	public static int getRefluxWaterRate;
	
	public static void reservoirLevel() {
		System.out.println();
		System.out.print("Berechne");
		TextTools.dddln();
		System.out.println();
		boolean stay = true;
		while (stay) {
			showStates();
			System.out.println("Was mˆchtest du tun?");
			System.out.println("[1] Abgabe des Wassers an die Sublimationsk¸hlung ‰ndern");
			System.out.println("[2] R¸ckgewinngungsgeschwindigkeit des R¸ckwassers ‰ndern");
			System.out.println("[3] Exit");
			System.out.println();
			
			int choice;
			do {
				choice = getUserInput();
			} while (choice == -1);
			
			switch (choice) {
			case 1:
				System.out.println("Aktuelle werden " + reservoirSublimationRate + "% an die Sublimationsk¸hlung abgegeben");
				System.out.println();
				System.out.println("Abgabe an die Sublimationsk¸hlung...");
				System.out.println("[1] Erhˆhen");
				System.out.println("[2] Verringern");
				System.out.println();
				
				do {
					choice = getUserInput();
				} while (choice == -1);
				
				if (choice == 1) {
					
					System.out.println();
					System.out.println("Um wieviele 5% schritte mˆchtest du den Anteil erhˆhen?");
					System.out.println("Verf¸gbare schritte: " + (100 - reservoirSublimationRate) / 5);
					
					do {
						choice = getUserInput();
					} while (choice == -1);
					
					if (choice > (100 - reservoirSublimationRate) / 5) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						reservoirSublimationRate = reservoirSublimationRate + choice * 5;
						ReservoirLevelReader.reservoirLevel = ReservoirLevelReader.reservoirLevel - choice * 5;
					}
					
				} else if (choice == 2) {
					System.out.println();
					System.out.println("Um wieviele 5% schritte mˆchtest du den Anteil verringern?");
					System.out.println("Verf¸gbare schritte: " + reservoirSublimationRate / 5);
					
					do {
						choice = getUserInput();
					} while (choice == -1);
					
					if (choice > reservoirSublimationRate / 5) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						reservoirSublimationRate = reservoirSublimationRate - choice * 5;
						ReservoirLevelReader.reservoirLevel = ReservoirLevelReader.reservoirLevel + choice * 5;
					}
				} else {
					System.out.println("Bitte gib eine G¸ltige zahl ein!");
				}
				
				break;
			case 2:
				System.out.println("Aktuelle r¸ckgewinnungs geschwindigkeit: " + getRefluxWaterRate + "%");
				System.out.println();
				System.out.println("R¸ckgewinnungsgeschwindigkeit...");
				System.out.println("[1] Erhˆhen");
				System.out.println("[2] Verringern");
				System.out.println();
				
				do {
					choice = getUserInput();
				} while (choice == -1);
				
				if (choice == 1) {
					
					System.out.println();
					System.out.println("Um wieviele 5% schritte mˆchtest du die R¸ckgewinnungsgeschwindigkeit erhˆhen?");
					System.out.println("Verf¸gbare schritte: " + (200 - getRefluxWaterRate) / 5);
					
					do {
						choice = getUserInput();
					} while (choice == -1);
					
					if (choice > (200 - getRefluxWaterRate) / 10) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						getRefluxWaterRate = getRefluxWaterRate + choice * 5;
						ReservoirLevelReader.reservoirLevel = ReservoirLevelReader.reservoirLevel + choice * 5;
					}
					
				} else if (choice == 2) {
					System.out.println();
					System.out.println("Um wieviele 5% schritte mˆchtest du die R¸ckgewinnungsgeschwindigkeit verringern?");
					System.out.println("Verf¸gbare schritte: " + getRefluxWaterRate / 5);
					
					do {
						choice = getUserInput();
					} while (choice == -1);
					
					if (choice > getRefluxWaterRate / 5) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						getRefluxWaterRate = getRefluxWaterRate - choice * 5;
						ReservoirLevelReader.reservoirLevel = ReservoirLevelReader.reservoirLevel - choice * 5;
					}
				} else {
					System.out.println("Bitte gib eine G¸ltige zahl ein!");
				}
				break;
			case 3:
				stay = false;
				break;
			default:
				System.out.println("Bitte gib eine G¸ltige zahl ein!");
			}
			
		}
	}
	
	public static int refluxSublimationRate;
	public static int refluxHeatPower;
	
	public static void refluxTemperature() {
		System.out.println();
		System.out.print("Berechne");
		TextTools.dddln();
		System.out.println();
		boolean stay = true;
		while (stay) {
			showStates();
			System.out.println("Was mˆchtest du tun?");
			System.out.println("[1] Durchflussanteil durch die Sublimationsk¸hlung ‰ndern");
			System.out.println("[2] Heizleistung des R¸ckwassers in der Kuppel ‰ndern");
			System.out.println("[3] Exit");
			System.out.println();
			
			int choice;
			do {
				choice = getUserInput();
			} while (choice == -1);
			
			switch (choice) {
			case 1:
				System.out.println("Aktuelle flieﬂen " + refluxSublimationRate + "% des Rpckwassers durch die Sublimationsk¸hlung");
				System.out.println();
				System.out.println("Durchflussanteil durch die Sublimationsk¸hlung...");
				System.out.println("[1] Erhˆhen");
				System.out.println("[2] Verringern");
				System.out.println();
				
				do {
					choice = getUserInput();
				} while (choice == -1);
				
				if (choice == 1) {
					
					System.out.println();
					System.out.println("Um wieviele 5% schritte mˆchtest du den Anteil erhˆhen?");
					System.out.println("Verf¸gbare schritte: " + (100 - refluxSublimationRate) / 5);
					
					do {
						choice = getUserInput();
					} while (choice == -1);
					
					if (choice > (100 - refluxSublimationRate) / 5) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						refluxSublimationRate = refluxSublimationRate + choice * 5;
						RefluxTemperatureReader.temperature = RefluxTemperatureReader.temperature - choice * 5;
					}
					
				} else if (choice == 2) {
					System.out.println();
					System.out.println("Um wieviele 5% schritte mˆchtest du den Anteil verringern?");
					System.out.println("Verf¸gbare schritte: " + refluxSublimationRate / 5);
					
					do {
						choice = getUserInput();
					} while (choice == -1);
					
					if (choice > refluxSublimationRate / 5) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						refluxSublimationRate = refluxSublimationRate - choice * 5;
						RefluxTemperatureReader.temperature = RefluxTemperatureReader.temperature + choice * 5;
					}
				} else {
					System.out.println("Bitte gib eine G¸ltige zahl ein!");
				}
				
				break;
			case 2:
				System.out.println("Aktuelle Heizleistung des R¸ckwassers in der Kuppel: " + refluxHeatPower + " MW");
				System.out.println();
				System.out.println("Heizleistung des R¸ckwassers in der Kuppel...");
				System.out.println("[1] Erhˆhen");
				System.out.println("[2] Verringern");
				System.out.println();
				
				do {
					choice = getUserInput();
				} while (choice == -1);
				
				if (choice == 1) {
					
					System.out.println();
					System.out.println("Um wieviele 10 MW schritte mˆchtest du die Heizleistung erhˆhen?");
					System.out.println("Verf¸gbare schritte: " + (500 - refluxHeatPower) / 10);
					
					do {
						choice = getUserInput();
					} while (choice == -1);
					
					if (choice > (500 - refluxHeatPower) / 10) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						refluxHeatPower = refluxHeatPower + choice * 10;
						RefluxTemperatureReader.temperature = RefluxTemperatureReader.temperature - choice * 5;
					}
					
				} else if (choice == 2) {
					System.out.println();
					System.out.println("Um wieviele 10 MW schritte mˆchtest du die Heizleistung verringern?");
					System.out.println("Verf¸gbare schritte: " + refluxHeatPower / 10);
					
					do {
						choice = getUserInput();
					} while (choice == -1);
					
					if (choice > refluxHeatPower / 10) {
						System.out.println("Deine zahl ist zu groﬂ!");
					} else if (choice < 0) {
						System.out.println("Deine zahl ist zu klein!");
					} else {
						refluxHeatPower = refluxHeatPower - choice * 10;
						RefluxTemperatureReader.temperature = RefluxTemperatureReader.temperature + choice * 5;
					}
				} else {
					System.out.println("Bitte gib eine G¸ltige zahl ein!");
				}
				break;
			case 3:
				stay = false;
				break;
			default:
				System.out.println("Bitte gib eine G¸ltige zahl ein!");
			}
			
		}
	}
	
	public static int getUserInput() {
		int number = -1;
		String input = Config.keyScan.nextLine();
		try {
			number = Integer.valueOf(input);
		} catch (NumberFormatException e) {
			System.out.println("\"" + input + "\" ist keine Zahl! Bitte gebe eine Zahl ein!");
		}
		return number;
	}
	
	private static void showStates() {
		System.out.print("Aktuelle Werte");
		System.out.println();
		System.out.println("Durchfluss: " + FlowRateReader.flowRate + " L/s");
		System.out.println("K¸hlwassertemperatur: " + TemperatureReader.temperature + " ∞C");
		System.out.println("R¸ckflusswassertemperatur: " + RefluxTemperatureReader.temperature + " ∞C");
		System.out.println("Reservoirf¸llstand: " + ReservoirLevelReader.reservoirLevel + "%");
		System.out.println();
	}
	
}
