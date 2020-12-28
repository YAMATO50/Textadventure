package places.visitable;

import adventure.text.Config;
import adventure.text.TextAdventure;
import adventure.text.TextTools;

public class Canteen {
	
	private int choice;
	private int secondChoice;
	private int[] thirdChoice;
	private int time;
	private double money;
	private int category;
	private int index;
	private int length;
	private int counter;
	private int additionalPrice;
	private int price;
	
	public double eatSomething(double money) {
		this.time = Config.save.time;
		this.money = money;
		
		dayTimeMenu();
		
		return this.money;
	}
	
	private void dayTimeMenu() {
		System.out.println("Es ist " + this.time + ":00 Uhr");
		System.out.print("Aktuell gibt es ");
		
		if (this.time >= 5 && this.time <= 9) {
			System.out.println("Frühstück im Lunar-taste");
			this.category = 0;
			breakfast();
		} else if (this.time >= 10 && this.time <= 16) {
			System.out.println("Mittagessen im Lunar-taste");
			this.category = 1;
			lunch();
		} else if (this.time >= 17 && this.time <= 23) {
			System.out.println("Abendessen im Lunar-taste");
			this.category = 2;
			supper();
		} else {
			System.out.println("das Nachtmenü im Lunar-taste");
			this.category = 3;
			nightMenu();
		}
	}
	
	private void breakfast() {
		setIndexes();
		assembleMenu();
		
		do {
			System.out.println();
			System.out.println("Was möchtest du? Du hast aktuell " + TextTools.adjustPriceOutput(((double) Config.save.money) / 100));
			choice = TextAdventure.getIntFromUser();
		} while (choice == -1);
		
		choice--;
		
		if (choice == -1) {
			System.out.println("Du gehst wieder ohne entwas zu bestellen");
			return;
		}
		
		if (choice > counter - 1) {
			System.out.println("Dieses element ist nicht vorhanden");
			return;
		}
		
		choice = choice + index; //setzt die auswahl an die korrekte stelle in der liste aus Config.food
		
		if (money < Config.food.getPrice(choice)) {
			System.out.println("Du hast nicht genug Geld dafür!");
			System.out.println("Du hast nur " + TextTools.adjustPriceOutput(money));
			System.out.println("Du bräuchtest " + TextTools.adjustPriceOutput(Config.food.getPrice(choice)));
			return;
		}
		
		int variationCount = Config.food.getVariationAmount(choice);
		if (variationCount != 0) {
			askVariation();
		}
		
		int extrasCount = Config.food.getExtrasAmount(choice);
		if (extrasCount != 0) {
			askExtras();
		}
		
		boolean succes = false;
		if (variationCount != 0) {
			String[] variations = Config.food.getVariations(choice);
			succes = printEatingProcess(variations[secondChoice], Config.food.getExtras(choice), null, null, null);
		} else {
			succes = printEatingProcess(Config.food.getFood(choice), Config.food.getExtras(choice), null, null, null);
		}
		
		if (!succes) {
			return;
		}
		
		money = money - (price + additionalPrice);
	}
	
	private void lunch() {
		setIndexes();
		assembleMenu();
		
		do {
			System.out.println();
			System.out.println("Was möchtest du? Du hast aktuell " + TextTools.adjustPriceOutput(money / 100));
			choice = TextAdventure.getIntFromUser();
		} while (choice == -1);
		
		choice--;
		
		if (choice == -1) {
			System.out.println("Du gehst wieder ohne etwas zu bestellen");
			return;
		}
		
		if (choice > counter - 1) {
			System.out.println("Dieses element ist nicht vorhanden");
			return;
		}
		
		choice = choice + index;
		
		price = Config.food.getPrice(choice);
		
		if (money < price) {
			System.out.println("Du hast nicht genug Geld dafür!");
			System.out.println("Du hast nur " + TextTools.adjustPriceOutput(money));
			System.out.println("Du bräuchtest " + TextTools.adjustPriceOutput(Config.food.getPrice(choice)));
			return;
		}
		
		int variationCount = Config.food.getVariationAmount(choice);
		if (variationCount != 0) {
			askVariation();
		}
		
		int extrasCount = Config.food.getExtrasAmount(choice);
		if (extrasCount != 0) {
			askExtras();
		}
		
		String garnish = askGarnish();
		
		String dessert = askDessert();
		
		String beverage = askBeverage();
		
		boolean succes = false;
		if (variationCount != 0) {
			String[] variations = Config.food.getVariations(choice);
			succes = printEatingProcess(variations[secondChoice], Config.food.getExtras(choice), dessert, garnish, beverage);
		} else {
			succes = printEatingProcess(Config.food.getFood(choice), Config.food.getExtras(choice), dessert, garnish, beverage);
		}
		
		if (!succes) {
			return;
		}
		
		money = money - Config.food.getPrice(choice);
	}
	
	private void supper() {
		setIndexes();
		assembleMenu();
		
		do {
			System.out.println();
			System.out.println("Was möchtest du? Du hast aktuell " + TextTools.adjustPriceOutput(money / 100));
			choice = TextAdventure.getIntFromUser();
		} while (choice == -1);
		
		choice--;
		
		if (choice == -1) {
			System.out.println("Du gehst wieder ohne etwas zu bestellen");
			return;
		}
		
		if (choice > counter - 1) {
			System.out.println("Dieses element ist nicht vorhanden");
			return;
		}
		
		choice = choice + index;
		
		if (money < Config.food.getPrice(choice)) {
			System.out.println("Du hast nicht genug Geld dafür!");
			System.out.println("Du hast nur " + TextTools.adjustPriceOutput(money));
			System.out.println("Du bräuchtest " + TextTools.adjustPriceOutput(Config.food.getPrice(choice)));
			return;
		}
		
		int variationCount = Config.food.getVariationAmount(choice);
		if (variationCount != 0) {
			askVariation();
		}
		
		int extrasCount = Config.food.getExtrasAmount(choice);
		if (extrasCount != 0) {
			askExtras();
		}
		
		boolean succes = false;
		if (variationCount != 0) {
			String[] variations = Config.food.getVariations(choice);
			succes = printEatingProcess(variations[secondChoice], Config.food.getExtras(choice), null, null, null);
		} else {
			succes = printEatingProcess(Config.food.getFood(choice), Config.food.getExtras(choice), null, null, null);
		}
		
		if (!succes) {
			return;
		}
		
		money = money - Config.food.getPrice(choice);
	}
	
	private void nightMenu() {
		setIndexes();
		assembleMenu();
		
		do {
			System.out.println();
			System.out.println("Was möchtest du? Du hast aktuell " + TextTools.adjustPriceOutput(money / 100));
			choice = TextAdventure.getIntFromUser();
		} while (choice == -1);
		
		choice--;
		
		if (choice == -1) {
			System.out.println("Du gehst wieder ohne etwas zu bestellen");
			return;
		}
		
		if (choice > counter - 1) {
			System.out.println("Dieses element ist nicht vorhanden");
			return;
		}
		
		choice = choice + index;
		
		if (money < Config.food.getPrice(choice)) {
			System.out.println("Du hast nicht genug Geld dafür!");
			System.out.println("Du hast nur " + TextTools.adjustPriceOutput(money));
			System.out.println("Du bräuchtest " + TextTools.adjustPriceOutput(Config.food.getPrice(choice)));
			return;
		}
		
		int variationCount = Config.food.getVariationAmount(choice);
		if (variationCount != 0) {
			askVariation();
		}
		
		int extrasCount = Config.food.getExtrasAmount(choice);
		if (extrasCount != 0) {
			askExtras();
		}
		
		boolean succes = false;
		if (variationCount != 0) {
			String[] variations = Config.food.getVariations(choice);
			succes = printEatingProcess(variations[secondChoice], Config.food.getExtras(choice), null, null, null);
		} else {
			succes = printEatingProcess(Config.food.getFood(choice), Config.food.getExtras(choice), null, null, null);
		}
		
		if (!succes) {
			return;
		}
		
		money = money - Config.food.getPrice(choice);
	}
	
	private boolean printEatingProcess(String food, String[] extras, String dessert, String garnish, String beverage) {
		if (food != null && thirdChoice == null || food != null && thirdChoice[0] == -1) {
			System.out.println("Du isst genüsslich " + food);
		} else if (food != null) {
			String extrasToString = "";
			int thirdChoices = thirdChoice.length;
			switch (thirdChoices) {
			case 1: 
				extrasToString = extras[thirdChoice[0]];
				break;
			case 2:
				if (thirdChoice[1] != 0) {
					extrasToString = extras[thirdChoice[0]] + " und " + extras[thirdChoice[1]];
				} else {
					extrasToString = extras[thirdChoice[0]];
				}
				break;
			default:
				for (int i = 0; i < thirdChoice.length; i++) {
					if (thirdChoice.length == i + 1 || thirdChoice[i + 1] == 0) {
						extrasToString = extrasToString + " und " + extras[thirdChoice[i]];
					} else {
						if (i == 0) {
							extrasToString = extras[thirdChoice[i]];
						} else {
							extrasToString = extrasToString + ", " + extras[thirdChoice[i]];
						}
					}
				}
			}
			System.out.println("Du isst genüsslich " + food + " mit " + extrasToString);
		} else if (food == null) {
			System.out.println("Etwas ist schiefgegangen. Du bekommst dein geld zurück!");
			return false; //gibt den misserfolg der methode zurück
		}
		
		if (garnish == null || garnish.equals("")) {
			//gibt keine beilage, ist also unwichtig
		} else {
			TextAdventure.wait(1000);
			System.out.println("Nebenbei isst du genüsslich " + garnish);
		}
		
		if (beverage == null || beverage.equals("")) {
			//gibt kein getränk, ist also unwichtig
		} else {
			TextAdventure.wait(1000);
			System.out.println("Du Trinkst genüsslich " + beverage);
			TextTools.slowTextln("Erfrischend");
		}
		
		if (dessert == null || dessert.equals("")) {
			//gibt kein nachtisch, ist also unwichtig
		} else {
			TextAdventure.wait(1000);
			System.out.println("Zum schluss isst du genüsslich " + dessert);
		}
		return true; //gibt den erfolg der methode zurück
	}
	
	private void askVariation() {
		String[] variations = Config.food.getVariations(choice);
		System.out.println("Welche Variante des Essens möchtest du?");
		assembleAdditionals(variations);
		do {
			secondChoice = TextAdventure.getIntFromUser();
		} while (secondChoice == -1);
		
		secondChoice--;
	}
	
	private void askExtras() {
		String[] extras = Config.food.getExtras(choice);
		thirdChoice = new int[Config.food.getAmountOfMultipleExtras(choice)];
		for (int i = 0; i < Config.food.getAmountOfMultipleExtras(choice); i++) {
			System.out.println("Du kanst noch dein " + (i + 1) + ". Extra auswählen");
			System.out.println("[0] Ich möchte kein / keine weiteren Extras");
			assembleAdditionals(extras);
			do {
				thirdChoice[i] = TextAdventure.getIntFromUser();
			} while (thirdChoice[i] == -1);
			if (thirdChoice[i] == 0) {
				thirdChoice[i] = -1;
				break;
			}
			thirdChoice[i]--;
		}
	}
	
	private String askGarnish() {
		System.out.println("Du darfst noch eine beilage auswählen!");
		System.out.println();
		
		String garnish = "";
		int gCategory = 5; //Beilagen haben den Kategorie-index 5
		int gIndex = Config.food.indexOf(gCategory);
		int gLength = Config.food.getFoodAmount() - Config.food.indexOf(gCategory); //Beilagen sind die letzte kategorie
		int gCounter = 1;
		
		System.out.println("[0] Ich möchte keine beilage");
		for (int i = gIndex; i < gLength + gIndex; i++) {
			System.out.println("[" + gCounter + "] " + Config.food.getFood(i) + " für +" + TextTools.adjustPriceOutput(((double) Config.food.getPrice(i)) / 100));
			gCounter++;
		}
		gCounter--;
		
		int gChoice = -1;
		
		do {
			gChoice = TextAdventure.getIntFromUser();
		} while (gChoice == -1);
		
		if (gChoice == 0) {
			return garnish;
		}
		
		if (gChoice > gCounter) {
			System.out.println("Dieses element ist nicht vorhanden");
			return garnish;
		}
		
		gChoice = gChoice + gIndex - 1;
		
		if (money < price + Config.food.getPrice(gChoice)) {
			System.out.println("Du hast nicht genug geld dafür!");
			System.out.println("Du hast nur " + TextTools.adjustPriceOutput(money / 100));
			System.out.println("Du brauchst " + TextTools.adjustPriceOutput((((double) Config.food.getPrice(gChoice)) + price) / 100));
			return garnish;
		}
		
		if (Config.food.getVariationAmount(gChoice) != 0) {
			System.out.println("Welche variation der Beilage möchtest du?");
				int gSecondChoice = -1;
			String[] gVariations = Config.food.getVariations(gChoice);
			assembleAdditionals(gVariations);
			do {
				gSecondChoice = TextAdventure.getIntFromUser();
			} while (gSecondChoice == -1);
			
			if (gSecondChoice > gVariations.length) {
				System.out.println("Dieses element ist nicht vorhanden");
				return garnish;
			}
			
			garnish = gVariations[gSecondChoice - 1];
			
		} else {
			garnish = Config.food.getFood(gChoice);
		}
		
		if (Config.food.getExtrasAmount(gChoice) != 0) {
			for (int i = 0; i < Config.food.getAmountOfMultipleExtras(gChoice); i++) {
				System.out.println("Wähle dein " + (i + 1) + ". extra");
				System.out.println();
				System.out.println("[0] Ich möchte kein / keine weiteren extras");
				
				String[] gExtras = Config.food.getExtras(gChoice);
				assembleAdditionals(gExtras);
				
				int gEChoice = -1;
				do {
					gEChoice = TextAdventure.getIntFromUser();
				} while (gEChoice == -1);
				
				if (gEChoice == 0) {
					break;
				}
				
				if (gEChoice > gExtras.length) {
					System.out.println("Dieses element ist nicht voranden");
					break;
				}
				
				gEChoice--;
				
				if (i == 0) {
					garnish = garnish + " mit " + gExtras[gEChoice];
				} else {
					garnish = garnish + " " + gExtras[gEChoice];
				}
			}
		}
		
		additionalPrice = additionalPrice + Config.food.getPrice(gChoice);
		return garnish;
	}
	
	private String askDessert() {
		System.out.println("Du darfst noch einen Nachtisch auswählen!");
		System.out.println();
		
		String dessert = "";
		int dCategory = 4; //Nachtisch hat den Kategorie-index 4
		int dIndex = Config.food.indexOf(dCategory);
		int dLength = Config.food.indexOf(dCategory + 1) - Config.food.indexOf(dCategory);
		int dCounter = 1;
		
		System.out.println("[0] Ich möchte keinen Nachtisch");
		for (int i = dIndex; i < dLength + dIndex; i++) {
			System.out.println("[" + dCounter + "] " + Config.food.getFood(i) + " für +" + TextTools.adjustPriceOutput(((double) Config.food.getPrice(i)) / 100));
			dCounter++;
		}
		dCounter--;
		
		int dChoice = -1;
		
		do {
			dChoice = TextAdventure.getIntFromUser();
		} while (dChoice == -1);
		
		if (dChoice == 0) {
			return dessert;
		}
		
		if (dChoice > dCounter) {
			System.out.println("Dieses element ist nicht vorhanden");
			return dessert;
		}
		
		dChoice = dChoice + dIndex - 1;
		
		if (money < price + Config.food.getPrice(dChoice)) {
			System.out.println("Du hast nicht genug geld dafür!");
			System.out.println("Du hast nur " + TextTools.adjustPriceOutput(money / 100));
			System.out.println("Du brauchst " + TextTools.adjustPriceOutput((((double) Config.food.getPrice(dChoice)) + price + additionalPrice) / 100));
			return dessert;
		}
		
		if (Config.food.getVariationAmount(dChoice) != 0) {
			System.out.println("Welche variation des Nachtischs möchtest du?");
				int dSecondChoice = -1;
			String[] dVariations = Config.food.getVariations(dChoice);
			assembleAdditionals(dVariations);
			do {
				dSecondChoice = TextAdventure.getIntFromUser();
			} while (dSecondChoice == -1);
			
			if (dSecondChoice > dVariations.length) {
				System.out.println("Dieses element ist nicht vorhanden");
				return dessert;
			}
			
			dessert = dVariations[dSecondChoice - 1];
			
		} else {
			dessert = Config.food.getFood(dChoice);
		}
		
		if (Config.food.getExtrasAmount(dChoice) != 0) {
			for (int i = 0; i < Config.food.getAmountOfMultipleExtras(dChoice); i++) {
				System.out.println("Wähle dein " + (i + 1) + ". extra");
				System.out.println();
				System.out.println("[0] Ich möchte kein / keine weiteren extras");
				
				String[] dExtras = Config.food.getExtras(dChoice);
				assembleAdditionals(dExtras);
				
				int dEChoice = -1;
				do {
					dEChoice = TextAdventure.getIntFromUser();
				} while (dEChoice == -1);
				
				if (dEChoice == 0) {
					break;
				}
				
				if (dEChoice > dExtras.length) {
					System.out.println("Dieses element ist nicht voranden");
					break;
				}
				
				dEChoice--;
				
				if (i == 0) {
					dessert = dessert + " mit " + dExtras[dEChoice];
				} else {
					dessert = dessert + " " + dExtras[dEChoice];
				}
			}
		}
		
		additionalPrice = additionalPrice + Config.food.getPrice(dChoice);
		return dessert;
	}
	
	private String askBeverage() {
		System.out.println("Du darfst noch eine Getränk auswählen!");
		System.out.println();
		
		String beverage = "";
		int bCategory = 0; //Das menüauswahl getränk hat den Kategorie-Index 0
		int bIndex = Config.beverage.indexOf(bCategory);
		int bLength = Config.beverage.indexOf(bCategory + 1) - bIndex;
		int bCounter = 1;	
		
		System.out.println("[0] Ich möchte kein Getränk");
		for (int i = bIndex; i < bLength + bIndex; i++) {
			System.out.println("[" + bCounter + "] " + Config.beverage.getBeverage(i) + " für +" + TextTools.adjustPriceOutput(((double) Config.beverage.getPrice(i)) / 100));
			bCounter++;
		}
		bCounter--;
		
		int bChoice = -1;
		
		do {
			bChoice = TextAdventure.getIntFromUser();
		} while (bChoice == -1);
		
		if (bChoice == 0) {
			return beverage;
		}
		
		if (bChoice > bCounter) {
			System.out.println("Dieses element ist nicht vorhanedn");
			return beverage;
		}
		
		bChoice = bChoice + bIndex - 1;
		
		if (money < price + Config.beverage.getPrice(bChoice)) {
			System.out.println("Du hast nicht genug geld dafür!");
			System.out.println("Du hast nur " + TextTools.adjustPriceOutput(money / 100));
			System.out.println("Du brauchst " + TextTools.adjustPriceOutput((((double) Config.beverage.getPrice(bChoice)) + price + additionalPrice) / 100));
			return beverage;
		}
		
		if (Config.beverage.getVariationAmount(bChoice) != 0) {
			System.out.println("Welche variation des Getränks möchtest du?");
			int bSecondChoice = -1;
			String[] bVariations = Config.beverage.getVariations(bChoice);
			assembleAdditionals(bVariations);
			do {
				bSecondChoice = TextAdventure.getIntFromUser();
			} while (bSecondChoice == -1);
			
			if (bSecondChoice > bVariations.length) {
				System.out.println("Dieses element ist nicht vorhanden");
				return beverage;
			}
			
			beverage = bVariations[bSecondChoice - 1];
		} else {
			beverage = Config.beverage.getBeverage(bChoice);
		}
		
		if (Config.beverage.getExtrasAmount(bChoice) != 0) {
			for (int i = 0; i < Config.beverage.getAmountOfMultipleExtras(bChoice); i++) {
				System.out.println("Wähle dein " + (i + 1) + ". extra");
				System.out.println();
				System.out.println("[0] Ich möchte kein / keine weiteren extras");
				
				String bExtras[] = Config.beverage.getExtras(bChoice);
				assembleAdditionals(bExtras);
				
				int bEChoice = -1;
				do {
					bEChoice = TextAdventure.getIntFromUser();
				} while (bEChoice == -1);
				
				if (bEChoice == 0) {
					break;
				}
				
				if (bEChoice > bExtras.length) {
					System.out.println("Dieses element ist nicht vorhanden");
					break;
				}
				
				bEChoice--;
				
				if (i == 0) {
					beverage = beverage + " mit " + bExtras[bEChoice];
				} else {
					beverage = beverage + " " + bExtras[bEChoice];
				}
			}
		}
		
		additionalPrice = additionalPrice + Config.beverage.getPrice(bChoice);
		return beverage;
	}
	
	private void assembleMenu() {
		System.out.println();
		System.out.println("[0] Ich möchte doch nichts essen");
		this.counter = 1;
		for (int i = this.index; i < this.length + this.index; i++) {
			int iPrice = Config.food.getPrice(i);
			float price = iPrice;
			price = price / 100;
			
			String strPrice = TextTools.adjustPriceOutput(price);
			
			String food = Config.food.getFood(i);
			if (food.endsWith(" ")) {
				System.out.println("[" + counter + "] " + food + "für " + strPrice);
			} else {
				System.out.println("[" + counter + "] " + food + " für " + strPrice);
			}
			counter++;
		}
		counter--;
	}
	
	private void assembleAdditionals(String[] inputList) {
		for (int i = 0; i < inputList.length; i++) {
			System.out.println("[" + (i + 1) + "]" + " " + inputList[i]);
		}
	}
	
	private void setIndexes() {
		this.index = Config.food.indexOf(this.category);
		this.length = (Config.food.indexOf(this.category + 1) - this.index);
	}

}
