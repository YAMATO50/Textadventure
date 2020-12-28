package places.visitable;

import adventure.text.TextAdventure;
import adventure.text.TextTools;

public class ATM {

	public static void moneyRequest(double money) {
		System.out.println("Du gehst zum bankautomaten und gibst deine geheim pin ein");
		
		String[] pinSound = new String[4];
		for (int i = 0; i < 4; i++) {
			String beep = "";
			int rnd = TextAdventure.random(1, 8);
			switch (rnd) {
			case 1:
				beep = "beep";
				break;
			case 2:
				beep = "bop";
				break;
			case 3:
				beep = "buup";
				break;
			case 4:
				beep = "düüt";
				break;
			case 5:
				beep = "düt";
				break;
			case 6:
				beep = "bip";
				break;
			case 7:
				beep = "dit";
				break;
			case 8: 
				beep = "büp";
				break;
			}
			
			pinSound[i] = beep;	
		}
		
		TextTools.slowTextln(pinSound[0] + " " + pinSound[1] + " " + pinSound[2] + " " + pinSound[3]);
		
		System.out.println("Dein Kontostand beträgt " + TextTools.adjustPriceOutput(money / 100));
	}
	
}
