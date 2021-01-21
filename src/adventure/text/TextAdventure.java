package adventure.text;
import java.util.concurrent.ThreadLocalRandom;
import places.visitable.*;

public class TextAdventure {

	static int choice;
	static double money;
	
	static Canteen canteen = new Canteen();
	static Bar bar = new Bar();
	static JobCenter job = new JobCenter();
	
	public static void start() {
		switch (Config.save.savePoint) {
		case 0:
			//Wenn das spiel das aller erste mal gestartet wird
			firstStart();
			Config.save.setSavePoint(1);
			System.out.println("Herzlich Willkommen in der Hauptkuppel der Caja-Basis auf dem Mond.");
			coreLoop();
			break;
			//setzt den spieler direkt in den start loop 
		case 1:
			System.out.println("Herzlich Willkommen in der Hauptkuppel der Caja-Basis auf dem Mond.");
			break;
		}
	}
	
	private static void firstStart() {
		//hier kommt dann bissle StoryStuff
	}
	
	public static void coreLoop() {
		boolean stay = true;
		money = Config.save.money;
		while (stay) {
			System.out.println();
			System.out.println("Aktuell ist es " + Config.save.time + ":00 Uhr");
			System.out.println();
			System.out.println("Was möchtest du tun?");
			System.out.println();
			System.out.println("[1] Kantine 'Lunar-Taste' ");
		    System.out.println("[2] Bar zum Krug in Mond");
		    System.out.println("[3] Erlebe etwas");
		    System.out.println("[4] Park 'Kuppel-Grün'");
		    System.out.println("[5] Jobcenter");
		    System.out.println("[6] Bankautomat");
		    System.out.println("[7] Zurück ins Zimmer gehen");
		    int checkForError = 0;
		    
		    String input = Config.keyScan.nextLine();
		    
		    try {
		    	 choice = Integer.valueOf(input);
		    } catch (NumberFormatException e) {
		    	System.out.println("\"" + input + "\" ist keine zahl! Bitte gebe eine zahl ein!");
		    	Log.log(input + "is not a number");
		    	choice = 8;
		    	checkForError = 1;
		    }
		    
		    	switch (choice) {
		    	case 1 :
		    		money = canteen.eatSomething(money);
		    		break;
		    	case 2 :
		    		money = bar.drinkSomething(money);
		    		break;
		    	case 3 :
		    		System.out.println("Du steigst in den Rover und fährst durch den krater. Du kommst vorbei an Steinen und Löchen im Boden.");
		    		break;
		    	case 4 :
		    		System.out.println("Du kommst auf einer Parkbank eine weile zur ruhe");
		    		wait(1000);
		    		System.out.println("Es ist ein schöner Park, trotz der Kuppel und dem tiefschwarzen Himmel.");
		    		wait(2000);
		    		System.out.println("Ein Vogel fliegt vorbei");
		    		TextTools.slowTextln("Tschilp tschilp");
		    		break;
		    	case 5 :
		    		money = job.work(money);
		    		break;
		    	case 6 :
		    		ATM.moneyRequest(money);
		    		break;
		    	case 7 :
		    		stay = Room.room();
		    		break;
		    	case 8 :
		    		if (checkForError == 1) {
		    			Config.save.setTime(Config.save.time - 1);
		    			break;
		    		} else {
		    			System.out.println("Du gehst zur Luftschläuse und gehst raus. Doch leider hasst du dein Schutzanzug vergessen. Du stirbst im Vakuum");	
		    		}
		    		break;
		    	default:
		    		System.out.println("Du gehst zur Luftschläuse und gehst raus. Doch leider hasst du dein Schutzanzug vergessen. Du stirbst im Vakuum");
		    }
		    	Config.save.setTime(Config.save.time + 1);
		    	if (Config.save.time == 24) {
		    		Config.save.setTime(0);
		    	}
		    	Config.save.setMoney(money);
		}
	    
	    wait(7 * 1000);
	    //In der Config wird dann gespeichert
	}
	
	public static void wait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public static int random(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	
	public static int getIntFromUser() {
		String input = Config.keyScan.nextLine();
		int inputInt = -1;
		try {
			inputInt = Integer.valueOf(input);
	    } catch (NumberFormatException e) {
	    	System.out.println("\"" + input + "\" ist keine zahl! Bitte gebe eine zahl ein!");
	    	Log.log(input + "is not a number");
	    }
		return inputInt;
	}
	
}
