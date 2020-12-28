package template.object.customizables;

import java.util.ArrayList;

public class Beverages {
	
	int beveragesAmount;
	ArrayList<BeverageList> beveragesList = new ArrayList<BeverageList>();
	
	//erhalten der einzelnen elemente mit methoden wie z.b. getBeverage()
	
	public Beverages(int beveragesAmount) {
		this.beveragesAmount = beveragesAmount;
	}
	
	public void addBeverage(String beverage, String[] variations, String[] extraBlocks, int price, int category) {
		int variationAmount = 0;
		if (variations != null) {
			variationAmount = variations.length;
		}
		int amountOfMultipleExtras = 0;
		int extrasAmount = 0;
		String[] extras = null;
		if (extraBlocks != null) {
			amountOfMultipleExtras = extraBlocks.length; //Da die Liste extras nur die einzelnen blöcke der extras enthält
			//etras blöcke müssen hier aufgeteilt werden in einzelne extras
			extras = processExtras(extraBlocks);
			extrasAmount = extras.length;
		}
		BeverageList beverageElement = new BeverageList(beverage, variationAmount,
											extrasAmount, amountOfMultipleExtras,
											price, category, variations, extras);
		this.beveragesList.add(beverageElement);
	}
	
	private static String[] processExtras(String[] extraBlocks) {
		if (extraBlocks.length == 0) {
			return new String[0];
		} else {
			String extrasBlock = extraBlocks[0];
			
			if (extrasBlock.startsWith(" ")) {
				extrasBlock = extrasBlock.substring(1);
			}
			
			if (extrasBlock.endsWith(" ")) {
				extrasBlock = extrasBlock.substring(0, extrasBlock.length() - 1);
			}
			String[] extrasSplit = extrasBlock.split("-");
			return extrasSplit;
		}
	}
	
	//hier kommen die ganzen get methoden
	
	public int getBeveragesAmount() {
		return this.beveragesAmount;
	}
	
	public String getBeverage(int index) {
		return beveragesList.get(index).beverage;
	}
	
	public int getVariationAmount(int index) {
		return beveragesList.get(index).variationAmount;
	}
	
	public int getExtrasAmount(int index) {
		return beveragesList.get(index).extrasAmount;
	}
	
	public int getAmountOfMultipleExtras(int index) {
		return beveragesList.get(index).amountOfMultipleExtras;
	}
	
	public int getPrice(int index) {
		return beveragesList.get(index).price;
	}
	
	public int getCategory(int index) {
		return beveragesList.get(index).category;
	}
	
	public String[] getVariations(int index) {
		return beveragesList.get(index).variations;
	}
	
	public String[] getExtras(int index) {
		return beveragesList.get(index).extras;
	}
	
	public int indexOf(String beverage) {
		int index = -1;
		for (int i = 0; i < this.beveragesAmount; i++) {
			if(beverage.equals(this.getBeverage(i))) {
				index = i;
				return index;
			}
		}
		return index;
	}
	
	public int indexOf(int category) {
		int index = -1;
		for (int i = 0; i < this.beveragesAmount; i++) {
			if (category == this.getCategory(i)) {
				index = i;
				return index;
			}
		}
		return index;
	}
	
	public class BeverageList {
		String beverage;
		
		int variationAmount;
		int extrasAmount;
		int amountOfMultipleExtras;
		int price;
		int category;
		
		String[] variations;
		String[] extras;
		
		public BeverageList(String beverage, int variationAmount, int extrasAmount, int amountOfMultipleExtras, int price, int category , String[] variations, String[] extras) {
			this.beverage = beverage;
			this.variationAmount = variationAmount;
			this.extrasAmount = extrasAmount;
			this.amountOfMultipleExtras = amountOfMultipleExtras;
			this.price = price;
			this.category = category;
			this.variations = variations;
			this.extras = extras;
		}
		
	}
		
}
