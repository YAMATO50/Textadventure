package places.visitable;

import adventure.text.*;

public class Room {

	public static boolean room() {
		
		System.out.println("Du gehst in die Wohnkuppel in richtung deines Zimmers");
		TextAdventure.wait(1000);
		System.out.println("An Zimmer 404 holst du deine schlüsselkarte heraus und gehst hinein.");
		
		boolean stayInRoom = true;
		while (stayInRoom) {
			System.out.println();
			System.out.println("Was möchtest du tun?");
			System.out.println("[1] An deinen Computer gehen");
			System.out.println("[2] Schlafen");
			System.out.println("[3] Das Buch \"Credits\" Lesen");
			System.out.println("[4] Zurück zur Hauptkuppel");
			System.out.println("[5] Speichern und Beenden");
			System.out.println();
			int choice;
			do {
				choice = TextAdventure.getIntFromUser();
				if (choice < 1 || choice > 4) {
					choice = -1;
					System.out.println("Bitte wähle eine gültige Option!");
				}
			} while(choice == -1);
			
			switch (choice) {
			case 1:
				System.out.println("COMING SOON");
				break;
			case 2:
				System.out.println("Wieviele Stunden möchtest du schlafen?");
				int timeToSleep;
				
				do {
					timeToSleep = TextAdventure.getIntFromUser();
					
					if (timeToSleep < 1) {
						timeToSleep = -1;
						System.out.println("So kurz kannst du nicht Schlafen!");
					}
					
					if (timeToSleep > 12) {
						timeToSleep = -1;
						System.out.println("Du kannst solange nicht Schlafen!");
					}
				} while (timeToSleep == -1);
				
				Config.save.setTime(Config.save.time + timeToSleep);
				
				if (Config.save.time >= 24) {
					Config.save.setTime(Config.save.time - 24);
				}
				
				System.out.println("Du gehst Zähneputzen und legst dich in dein Bett.");
				System.out.println("Gemütlich schläfst du ein.");
				TextTools.slowTextln("Zzz Zzz Zzz", 100);
				
				TextTools.slowTextln("BEEP BEEP BEEP BEEP BEEP BEEP", 35);
				System.out.println("Der aggresive Wecker reißt dich aus deinem Schlaf.");
				System.out.println("Auf dem Wecker steht " + Config.save.time + ":00 Uhr");
				
				break;
			case 3:
				credits();
				break;
			case 4:
				stayInRoom = false;
				System.out.println("Du gehst zurück in die Hauptkuppel");
				break;
			case 5:			
			    System.out.println("Auf wiedersehen!"); //hier findet sich bestimmt noch was besseres
				return false;
			}
			
		}
		
		return true;
	}
	
	private static void credits() {
		
	}
	
}
