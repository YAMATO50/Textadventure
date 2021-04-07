package jobs.Reactor;

import adventure.text.Config;
import adventure.text.TextAdventure;
import adventure.text.TextTools;

public class Reactor {

private static boolean succes;
	
	public static boolean start() {
		
		introduction();
		dos();
		
		return succes;
	}
	
	private static void introduction() {
		System.out.println("Du gehst in Richtung Reaktorkuppel");
		TextAdventure.wait(1000);
		System.out.println("In der Reaktorkuppel angekommen kommt dir ein Mann entgegen");
		TextAdventure.wait(1000);
		System.out.println("Auf seinem Schildchen an seinem anzug steht \"Tobias Ingram, Reaktor Leiter\"");
		TextAdventure.wait(1000);
		TextTools.slowTextln("Hi, " + Config.save.playerName + " Herzlich Willkommen in der Reaktorkuppel!", 30);
		TextTools.slowTextln("Ich bin Tobias Ingram, der Leiter der Reaktorkuppel.", 30);
		TextTools.slowTextln("Du bist also hier um den Reaktor zu prüfen. Hast du das schonmal gemacht?", 30);
		System.out.println();
		
		System.out.println("[1] Ja");
		System.out.println("[2] Nein");
		
		int answer;
		do {
			answer = TextAdventure.getIntFromUser();
			if (answer != 1 && answer != 2 || answer == -1) {
				System.out.println("Bitte gib eine gültige antwort ein!");
				answer = -1;
			}
		} while (answer == -1);
		
		System.out.println();
		
		if (answer == 1) {
			TextTools.slowTextln("Ich kann mir einfach nie merken wer schonmal hier war und wer nicht!", 30);
			TextTools.slowTextln("Na dann leg los! Du weißt ja wie es geht.", 30);
		} else {
			TextTools.slowTextln("Okay, dann erkläre ich dir mal alles!"
					+ "\n" + "Dort drüben an dem Rechner kommen alle Informationen den Reaktor an"
					+ "\n" + "Du musst schauen dass die Reaktorleistung mit dem Verbrauch der Basis übereinstimmt. Diese kannst du mithilfe"
					+ "\n" + "der Reaktortemperatur, Brennstabsanzahl und Kontrollstabstiefe beeinflussen. Achte darauf, dass die Reaktorleistung innerhalb"
					+ "\n" + "der Toleranz ist. Die werte dazu findest du in der \"werte.txt\" auf dem Computer."
					+ "\n" + "Du musst dich leider mit DOS rumschlagen, aber das packst du schon! In der \"help.txt\" steht wie das geht."
					+ "\n" + "Aber noch ein kleiner tipp für dich. Gib in jedem ordner (= Verzeichniss) \"dir\" ein, um zu sehen was in dem ordner ist."
					+ "\n" + "Wenn die Reaktorleistung ausserhalb der Toleranz liegt, musst du in den programmen die Parameter"
					+ "\n" + "neu einstellen. Weitere informationen dazu findest du dann in den entsprechenden \"info.txt\" dateien zu den Programmen."
					+ "\n" + "Wenn du fertig bist, und alle werte in ordnung sind, rufe die \"update.exe\" auf. Du kannst dann wieder zu mir kommen und dein Geld"
					+ "\n" + "abholen. Aber denk drann! Wenn die Reaktorleistung nicht mit dem Verbrauch der Basis übereinstimmt, bekommst du kein Geld!"
					+ "\n" + "Falls dir etwas zu schnell war, schau einfach in die \"help.txt\"."
					+ "\n" + "Also dann! Viel erfolg!", 30);
		}
		System.out.println();
		System.out.println("Du gehst zum Computer, setzt dich hin und blickst auf den Bildschirm");
		if (answer == 2) {
			System.out.println("Gib als erstes mal \"help.txt\" ein");
		}
		System.out.println();
		
	}

	private static void dos() {
		DOS.console();
		
		if (Updater.succes) {
			System.out.println("Du stehst auf und gehst zu Tobias Ingram.");
			TextAdventure.wait(1000);
			TextTools.slowTextln("Oh du bist fertig! Sehr schön. Dann lass mich mal sehen ob du alles richtig gemacht hast.",30);
			System.out.println("Du folgst ihm zu einem Terminal. Er tippt irgendwass ein und ruft eine datei auf.");
			TextAdventure.wait(1000);
			System.out.println("Nach dem er sich die datei kurz angesehen hat dreht er sich um zu dir.");
			TextTools.slowTextln("Sehr gut! Alles ist richtig eingestellt. Komm gerne wieder. Dein Gehalt überweise ich dir!"
					+ "\n" + "Hab noch einen schönen tag!");
			System.out.println();
			System.out.println("Was möchtest du tun?");
			System.out.println("[1] Gehen");
			System.out.println();
			
			TextAdventure.getIntFromUser();
			
		} else {
			System.out.println("Du stehst auf und gehst zu Tobias Ingram.");
			TextAdventure.wait(1000);
			TextTools.slowTextln("Oh du bist fertig! Sehr schön. Dann lass mich mal sehen ob du alles richtig gemacht hast.",30);
			System.out.println("Du folgst ihm zu einem Terminal. Er tippt irgendwass ein und ruft eine datei auf.");
			TextAdventure.wait(1000);
			System.out.println("Nach dem er sich die datei kurz angesehen hat dreht er sich um zu dir.");
			TextTools.slowTextln("Du willst fertig sein?! Definitiv nicht! Hier ist mindesten ein wert nicht korrekt eingestellt!"
					+ "\n" + "Dafür kann ich dich nicht bezahlen! Ich muss jetzt noch jemanden suchen der das hier in Ordnung bringt..."
					+ "\n" + "Schönen tag noch...");
			System.out.println("Etwas verärgert geht der Leiter der Reaktorkuppel weg.");
			
			if (DOS.errorOccured) {
				System.out.println();
				System.out.println("Was möchtest du tun?");
				System.out.println("[1] Gehen");
				System.out.println("[2] Dem Leiter nahlaufen und sagen dass ein Fehler aufgetreten ist");
				System.out.println();
				
				int choice;
				
				do {
					choice = TextAdventure.getIntFromUser();
					
					switch (choice) {
					case 1:
						break;
					case 2:
						System.out.println("Du gehst dem Leiter hinterher und sagts dass es einen Fehler gab");
						TextTools.slowTextln("hmmm... Ich werde das prüfen.", 30);
						System.out.println("Ihr geht zu einem anderen Terminal. Der Leiter ruft wieder eine datei auf. Es sieht aus wie eine Logdatei");
						TextAdventure.wait(1000);
						System.out.println("Er tippt etwas ein, und dreht sich wieder zu dir");
						TextTools.slowTextln("Tatsächlich, du hast recht. Bitte entschuldige meine Reaktion. Ich werde dir dein Gehalt überweisen."
								+ "\n" + "Einen schönen tag dir noch!", 30);
						break;
					default:
						System.out.println("Bitte gib eine gültige zahl ein!");
						choice = -1;
					}
					
				} while (choice == -1);
				
			}
		}
		
		System.out.println("Du gehst wieder zurück in die Hauptkuppel");
		TextAdventure.wait(1000);
	}
	
}
