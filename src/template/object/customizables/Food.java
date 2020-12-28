package template.object.customizables;

import java.util.ArrayList;

public class Food {
	
	int foodAmount;
	ArrayList<FoodList> foodList = new ArrayList<FoodList>();
	
	//erhalten der einzelnen elemente mit methoden wie z.b. getFood()
	
	public Food(int foodAmount) {
		this.foodAmount = foodAmount;
	}
	
	public void addFood(String food, String[] variations, String[] extraBlocks, int price, int category) {
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
		FoodList foodElement = new FoodList(food, variationAmount,
											extrasAmount, amountOfMultipleExtras,
											price, category, variations, extras);
		this.foodList.add(foodElement);
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
	
	public int getFoodAmount() {
		return this.foodAmount;
	}
	
	public String getFood(int index) {
		return foodList.get(index).food;
	}
	
	public int getVariationAmount(int index) {
		return foodList.get(index).variationAmount;
	}
	
	public int getExtrasAmount(int index) {
		return foodList.get(index).extrasAmount;
	}
	
	public int getAmountOfMultipleExtras(int index) {
		return foodList.get(index).amountOfMultipleExtras;
	}
	
	public int getPrice(int index) {
		return foodList.get(index).price;
	}
	
	public int getCategory(int index) {
		return foodList.get(index).category;
	}
	
	public String[] getVariations(int index) {
		return foodList.get(index).variations;
	}
	
	public String[] getExtras(int index) {
		return foodList.get(index).extras;
	}
	
	public int indexOf(String food) {
		int index = -1;
		for (int i = 0; i < this.foodAmount; i++) {
			if(food.equals(this.getFood(i))) {
				index = i;
				return index;
			}
		}
		return index;
	}
	
	public int indexOf(int category) {
		int index = -1;
		for (int i = 0; i < this.foodAmount; i++) {
			if (category == this.getCategory(i)) {
				index = i;
				return index;
			}
		}
		return index;
	}
	
	public class FoodList {
		String food;
		
		int variationAmount;
		int extrasAmount;
		int amountOfMultipleExtras;
		int price;
		int category;
		
		String[] variations;
		String[] extras;
		
		public FoodList(String food, int variationAmount, int extrasAmount, int amountOfMultipleExtras, int price, int category , String[] variations, String[] extras) {
			this.food = food;
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
