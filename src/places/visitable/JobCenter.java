package places.visitable;

import adventure.text.*;
import jobs.Reactor.Reactor;
import jobs.ReactorCooling.ReactorCooling;

public class JobCenter {

	private double money;
	private double wage;
	
	private int time;
	
	public JobCenter() {
		
	}
	
	public double work(double money) {
		this.money = money;
		this.time = Config.save.time;
		this.wage = 0; //Für den fall des verlassens, muss nichts weiter getan werden
		
		chooseJob();
		
		this.money = this.money + this.wage;
		return this.money;
	}
	
	private void chooseJob() {
		if (time < 4 || time > 21) {
			System.out.println("Das Jobcenter hat aktuell geschlossen");
			System.out.println("Komm frühestens morgen um 4:00 Uhr wieder");
			return;
		}
		
		int[] availableJobs = new int[6];
		availableJobs[5] = 1;
		
		for (int i = 0; i < 5; i++) {
			availableJobs[i] = TextAdventure.random(0, 10);
			if (contains(availableJobs, availableJobs[i], i)) {
				i--;
			}
		}
		
		System.out.println();
		System.out.println("[0] Ich möchte doch nicht arbeiten");
		
		for (int i = 0; i < availableJobs.length; i++) {
			System.out.println("[" + (i + 1) + "] " + jobList(availableJobs[i]) + ", Lohn: " + TextTools.adjustPriceOutput(wageList(availableJobs[i]) / 100));
		}
		System.out.println("[6] Reaktor (Funktioniert)");
		System.out.println();
		int jobNum;
		
		do {
			jobNum = TextAdventure.getIntFromUser();
			if (jobNum > 6 || jobNum < 0 && jobNum != -1) {

				System.out.println("Dieser Job existiert nicht!");
				jobNum = -1;
			}
		} while (jobNum == -1);
		
		jobNum--;
		
		boolean succes = job(availableJobs[jobNum]);
		if (succes) {
			this.wage = wageList(availableJobs[jobNum]);
		}
	}
	
	private boolean contains(int[] list, int number, int indexToIgnore) { //indexToIgnore auf z.b. -1 setzen wenn nicht vorhanden
		for (int i = 0; i < list.length; i++) {
			if (list[i] == number && i != indexToIgnore) {
				return true;
			}
		}
		return false;
	}
	
	private String jobList(int jobNum) {
		String jobName = "";
		
		switch (jobNum) {
		case 0:
			jobName = "Reaktor kühlung prüfen";
			break;
		case 1:
			jobName = "Reaktor prüfen";
			break;
		case 2:
			jobName = "Waren von der Erde Entladen";
			break;
		case 3:
			jobName = "Waren an die Erde verladen";
			break;
		case 4:
			jobName = "Inventur des Warenhauses";
			break;
		case 5:
			jobName = "Essen für die Katine kochen";
			break;
		case 6:
			jobName = "Eine führung durch den Kajal Krater leiten";
			break;
		case 7:
			jobName = "Lichter in der Hauptkuppel reparieren";
			break;
		case 8:
			jobName = "Wasserversorgung reparieren";
			break;
		case 9:
			jobName = "Park pflegen";
			break;
		case 10:
			jobName = "Verkaufe getränke an der Bar";
			break;
		default:
			jobName = "Der Job dessen name nicht genannt werden darf!";
		}
		return jobName;
	}
	
	private double wageList(int jobNum) {
		double wage = 0;
		
		switch (jobNum) {
		case 0:
			wage = 2024;
			break;
		case 1:
			wage = 1736;
			break;
		case 2:
			wage = 1500;
			break;
		case 3:
			wage = 1500;
			break;
		case 4:
			wage = 1250;
			break;
		case 5:
			wage = 517;
			break;
		case 6:
			wage = 1337;
			break;
		case 7:
			wage = 400;
			break;
		case 8:
			wage = 1427;
			break;
		case 9:
			wage = 605;
			break;
		case 10:
			wage = 514;
			break;
		default:
			wage = 404;
		}
		return wage;
	}
	
	private boolean job(int jobNum) {
		boolean succes = true;
		System.out.println();
		switch (jobNum) {
		case 0:
			//Reaktor kühlung prüfen
			ReactorCooling.start();
			break;
		case 1:
			//Reaktor prüfen
			Reactor.start();
			break;
		case 2:
			//Waren von der Erde Entladen
			break;
		case 3:
			//Waren an die Erde verladen
			break;
		case 4:
			//Inventur des Warenhauses
			break;
		case 5:
			//Essen für die Katine kochen
			break;
		case 6:
			//Eine führung durch den Kajal Krater leiten
			break;
		case 7:
			//Lichter in der Hauptkuppel reparieren
			break;
		case 8:
			//Wasserversorgung reparieren
			break;
		case 9:
			//Park pflegen
			break;
		case 10:
			//Verkaufe getränke an der Bar
			break;
		default:
			System.out.println("Du stehst in der mitte der hauptkuppel");
			TextAdventure.wait(1000);
			System.out.println("Plötzlich kommt ein Nasenloser mann auf dich zu");
			TextAdventure.wait(1000);
			System.out.println("Er gibt dir eine silberne münze und geht wieder");
		}
		return succes; //Gibt den erfolgreich ausgeführten job zurück
	}
}
