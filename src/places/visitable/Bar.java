package places.visitable;

import adventure.text.Config;
import adventure.text.TextTools;
import adventure.text.TextAdventure;

public class Bar {

	private double money;
	private double price;
	
	private int index;
	private int length;
	private int counter;
	private int choice;
	private int secondChoice;
	private int[] thirdChoice;
	
	private String variation;
	private String extra;
	
	private boolean leave = false;
	
	public Bar() {
		
	}
	
	public double drinkSomething(double money) {
		this.money = money;
		
		setIndexes();
		assembleMenu();
		askMenu();
		
		if (leave) {
			return this.money;
		}
		
		return this.money;
	}

	private void assembleMenu() {
		System.out.println();
		System.out.println("[0] Ich möchte doch nichts trinken!");
		counter = 1;
		for (int i = 0; i < length; i++) {
			String beverage = Config.beverage.getBeverage(i + index);
			if (beverage.endsWith(" ")) {
				System.out.println("[" + (i + 1) + "] " + beverage + "für " + TextTools.adjustPriceOutput(((double) Config.beverage.getPrice(i + index)) / 100));
			} else {
				System.out.println("[" + (i + 1) + "] " + beverage + " für " + TextTools.adjustPriceOutput(((double) Config.beverage.getPrice(i + index)) / 100));
			}
			counter++;
		}
		counter--;
	}
	
	private void askMenu() {
		int choice = TextAdventure.getIntFromUser();
		if (choice == 0) {
			leave = true;
			System.out.println("Du gehst wieder ohne etwas zu bestellen");
			return;
		}
		
		if (choice > counter) {
			System.out.println("Dieses element ist nicht vorhanden!");
			leave = true;
			return;
		}
		
		this.choice = choice + index - 1;
		this.price = Config.beverage.getPrice(this.choice);
		
		if (this.price > this.money) {
			System.out.println("Du hast nicht genug Geld dafür!");
			System.out.println("Du hast nur " + TextTools.adjustPriceOutput(this.money / 100));
			System.out.println("Du bräuchtest " + TextTools.adjustPriceOutput(this.price / 100));
			leave = true;
			return;
		}
		
		int variationCount = Config.beverage.getVariationAmount(this.choice);
		if (variationCount != 0) {
			askVariation();
			
			String[] variations = Config.beverage.getVariations(this.choice);
			this.variation = variations[this.secondChoice];
		}
		
		int extrasCount = Config.beverage.getExtrasAmount(this.choice);
		if (extrasCount != 0) {
			askExtras();
			
			int length = thirdChoice.length;
			String[] extras = Config.beverage.getExtras(this.choice);
			
			if (length == 1) {
				
				if (this.thirdChoice[0] != -1) {
					this.extra = extras[this.thirdChoice[0]];
				}
				
			} else if (length == 2) {
				
				if (this.thirdChoice[0] != -1) {
					this.extra = extras[this.thirdChoice[0]];
					
					if (this.thirdChoice[1] != -1) {
						this.extra = this.extra + " und " + extras[this.thirdChoice[1]];
					}
				}
				
			} else {
				
				int endPoint = -1;
				for (int i = 0; i < this.thirdChoice.length; i++) {
					if (this.thirdChoice[i] == -1) {
						endPoint = i;
						break;
					}
				}
				
				switch (endPoint) {
				case 0:
					break;
				case 1:
					this.extra = extras[this.thirdChoice[0]];
					break;
				case 2:
					this.extra = extras[this.thirdChoice[0]] + " und " + extras[this.thirdChoice[1]];
					break;
				case -1:
					this.extra = extras[this.thirdChoice[0]];
					for (int i = 1; i < this.thirdChoice.length - 1; i++) {
						this.extra = extra + ", " + extras[this.thirdChoice[i]];
					}
					this.extra = this.extra + " und " + extras[this.thirdChoice[this.thirdChoice.length - 1]];
					break;
				default:
					this.extra = extras[this.thirdChoice[0]];
					for (int i = 1; i < endPoint - 2; i++) {
						this.extra = this.extra + ", " + extras[this.thirdChoice[i]];
					}
					this.extra = this.extra + " und " + extras[this.thirdChoice[endPoint - 1]];
				}
			}
			
		}
		
		System.out.println();
		System.out.println("Möchtest du Eiswürfel in dein Getränk?");
		System.out.println("[1] Ja");
		System.out.println("[2] Nein");
		int ice = TextAdventure.getIntFromUser();
		System.out.println();
		
		if (variationCount != 0) {
			if (this.extra == null) {
				if (ice == 1) {
					System.out.println("Du trinkst genüsslich " + this.variation + " mit Eiswürfeln");
					TextTools.slowTextln("Erfrischend!");
				} else {
					System.out.println("Du trinkst genüsslich " + this.variation);
				}
			} else {
				if (ice == 1) {
					System.out.println("Du trinkst genüsslich " + this.variation + " in der geschmacksrichtung " + this.extra + " mit Eiswürfeln");
					TextTools.slowTextln("Erfrischend!");
				} else {
					System.out.println("Du trinkst genüsslich " + this.variation + " in der geschmacksrichtung " + this.extra);
				}
			}
		} else {
			if (this.extra == null) {
				if (ice == 1) {
					System.out.println("Du trinkst genüsslich " + Config.beverage.getBeverage(this.choice) + " mit Eiswürfeln");
					TextTools.slowTextln("Erfrischend!");
				} else {
					System.out.println("Du trinkst genüsslich " + Config.beverage.getBeverage(this.choice));
				}
			} else {
				if (ice == 1) {
					System.out.println("Du trinkst genüsslich " + Config.beverage.getBeverage(this.choice) + " in der geschmacksrichtung " + this.extra + " mit Eiswürfeln");
					TextTools.slowTextln("Erfrischend!");
				} else {
					System.out.println("Du trinkst genüsslich " + Config.beverage.getBeverage(this.choice) + " in der geschmacksrichtung " + this.extra);
				}
			}
		}
		
		this.money = this.money - this.price;
	}
	
	private void setIndexes() {
		index = Config.beverage.indexOf(1); //Bargetränke haben den index 1
		length = Config.beverage.getBeveragesAmount() - index; //Da die bargetränke das letzte in der liste sind
	}
	
	private void askVariation() {
		String[] variations = Config.beverage.getVariations(this.choice);
		System.out.println("Welche Variante des Getränks möchtest du?");
		assembleAdditionals(variations);
		do {
			secondChoice = TextAdventure.getIntFromUser();
		} while (secondChoice == -1);
		
		this.secondChoice--;
	}
	
	
	private void askExtras() {
		String[] extras = Config.beverage.getExtras(this.choice);
		thirdChoice = new int[Config.beverage.getAmountOfMultipleExtras(this.choice)];
		for (int i = 0; i < Config.beverage.getAmountOfMultipleExtras(this.choice); i++) {
			System.out.println("Du kanst noch deine " + (i + 1) + ". Geschmacksrichtung auswählen");
			System.out.println("[0] Ich möchte keine (weiteren) Geschmacksrichtungen");
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
	
	private void assembleAdditionals(String[] inputList) {
		for (int i = 0; i < inputList.length; i++) {
			System.out.println("[" + (i + 1) + "]" + " " + inputList[i]);
		}
	}
}
