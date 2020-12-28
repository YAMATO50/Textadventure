package adventure.text;

public class TextTools {

	public static void slowTextln(String output) {
		char[] charsOfString = output.toCharArray();
		for (int i = 0; i < charsOfString.length; i++) {
			System.out.print(charsOfString[i]);
			TextAdventure.wait(150);
		}
		System.out.println();
	}
	
	public static void slowTextln(String output, int millisCharDelay) {
		char[] charsOfString = output.toCharArray();
		for (int i = 0; i < charsOfString.length; i++) {
			System.out.print(charsOfString[i]);
			TextAdventure.wait(millisCharDelay);
		}
		System.out.println();
	}
	
	public static void slowText(String output) {
		char[] charsOfString = output.toCharArray();
		for (int i = 0; i < charsOfString.length; i++) {
			System.out.print(charsOfString[i]);
			TextAdventure.wait(150);
		}
	}
	
	public static void slowText(String output, int millisCharDelay) {
		char[] charsOfString = output.toCharArray();
		for (int i = 0; i < charsOfString.length; i++) {
			System.out.print(charsOfString[i]);
			TextAdventure.wait(millisCharDelay);
		}
	}
	
	public static void ddd() {
		System.out.print(".");
		TextAdventure.wait(500);
		System.out.print(".");
		TextAdventure.wait(500);
		System.out.print(".");
		TextAdventure.wait(500);
	}
	
	public static void dddln() {
		System.out.print(".");
		TextAdventure.wait(500);
		System.out.print(".");
		TextAdventure.wait(500);
		System.out.println(".");
		TextAdventure.wait(500);
	}
	
	public static String adjustPriceOutput(double price) {
		String strPrice = String.valueOf(price);
		String priceCarry = "";
		String afterDecimalPoint = "";
		char[] charsOfPrice = strPrice.toCharArray();
		for (int i = 0; i < charsOfPrice.length; i++) {
			String singleChar = String.valueOf(charsOfPrice[i]);
			if (singleChar.equals(".")) {
				int length = charsOfPrice.length - 1;
				if (length - i == 1) {
					afterDecimalPoint = String.valueOf(charsOfPrice[i + 1]);
				} else {
					afterDecimalPoint = String.valueOf(charsOfPrice[i + 1]) + String.valueOf(charsOfPrice[i + 2]);
				}
				break;
			} else {
				priceCarry = priceCarry + singleChar;
			}
		}
			
		strPrice = priceCarry;
		
		String[] split = afterDecimalPoint.split("");
		if (split.length == 1) {
			strPrice = strPrice + "." + afterDecimalPoint + "0€";
		} else {
			strPrice = strPrice + "." + afterDecimalPoint + "€";
		}
		return strPrice;
	}
	
}
