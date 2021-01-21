package adventure.text;
import java.util.ArrayList;
import java.io.File;
import com.google.gson.Gson;
import template.object.customizables.Food;
import template.object.customizables.Beverages;
import template.object.json.Save;

public class ProcessSaveFiles {

	public static ArrayList<String> tempLoad = new ArrayList<String>();
	public static ArrayList<String> tempSave = new ArrayList<String>();
	
	public static void loadFood() {
		File foodFile = new File("Essen.txt");
		boolean loadSucces = SaveLoad.load(foodFile);
		if (!loadSucces) {
			Log.saveLog(true);
			System.exit(0); //beendet das Programm
		}
		
		String[][] _foodList = to2DArray(); //gibt leider ein nicht ganz korrektes Array zurück, daher noch nicht der Finale Variablen name
		
		String[][] foodList = fixNull(_foodList);
		
		String[][][] returnedLists = splitBySlash(foodList);
		String[][] variations = returnedLists[0];
		foodList = returnedLists[1];
		
		returnedLists = splitByTilde(foodList, variations);
		String[][] options = returnedLists[0];
		variations = returnedLists[1];
		foodList = returnedLists[2];
		
		int foodAmount = foodList.length - 6; //Es werden 6 abgezogen, da es 6 kategorien gibt, die in der liste als Marker element markiert sind
		
		Food food = new Food(foodAmount);
		
		int category = 0;
		for (int i = 0; i < foodList.length; i++) {
			String checkForMarker = foodList[i][0];
			
			if (checkForMarker.equals("marker")) {
				String categoryName = foodList[i][2];
				
				switch (categoryName) {
					case "Frühstück" :
						category = 0;
						break;
					case "Mittagessen" :
						category = 1;
						break;
					case "Abendessen" :
						category = 2;
						break;
					case "Nachtmenü" :
						category = 3;
						break;
					case "Nachtisch" :
						category = 4;
						break;
					case "Beilage" :
						category = 5;
						break;
					default :
						Log.log(categoryName + " not recognized as category. Cannot proceed loading");
						Log.saveLog(true);
						System.exit(0);
				}
			} else {
				int price = 0;
				try {
					price = Integer.valueOf(foodList[i][0]);
				} catch (NumberFormatException e) {
					Log.log(foodList[i][0] + " is not a number!");
					Log.saveLog(true);
					System.exit(0);
				}
				if (variations[i] == null) {
					food.addFood(foodList[i][2], null, options[i], price, category);
				} else {
					food.addFood(foodList[i][2], variations[i], options[i], price, category);
				}
			}
		}
		
		Config.food = food;
		
		Log.log("Food succesfully loaded!");
		
	}
	
	public static void loadBeverages() {
		File beverageFile = new File("Trinken.txt");
		boolean loadSucces = SaveLoad.load(beverageFile);
		if (!loadSucces) {
			Log.saveLog(true);
			System.exit(0);
		}
		
		String[][] _beverageList = to2DArray();
		
		String[][] beverageList = fixNull(_beverageList);
		
		String[][][] returnedLists = splitBySlash(beverageList);
		String[][] variations = returnedLists[0];
		beverageList = returnedLists[1];
		
		returnedLists = splitByTilde(beverageList, variations);
		String[][] options = returnedLists[0];
		variations = returnedLists[1];
		beverageList = returnedLists[2];
		
		int beveragesAmount = beverageList.length - 2; //Es werden 2 abgezogen, da es 2 kategorien gibt, die in der liste als Marker gekennzeichnet sind
		
		Beverages beverage = new Beverages(beveragesAmount);
		
		int category = 0;
		
		for (int i = 0; i < beverageList.length; i++) {
			String checkForMarker = beverageList[i][0];
			
			if (checkForMarker.equals("marker")) {
				String categoryName = beverageList[i][2];
				
				if (categoryName.equals("Menüauswahl")) {
					category = 0;
				} else if (categoryName.equals("Normalauswahl")) {
					category = 1;
				} else {
					Log.log(categoryName + " not recognized as category. Cannot proceed loading");
					Log.saveLog(true);
					System.exit(0);
				}
			} else {
				int price = 0;
				try {
					price = Integer.valueOf(beverageList[i][0]);
				} catch (NumberFormatException e) {
					Log.log(beverageList[i][0] + " is not a number!");
					Log.saveLog(true);
					System.exit(0);
				}
				beverage.addBeverage(beverageList[i][2], variations[i], options[i], price, category);
			}
		}
		
		Config.beverage = beverage;
		
		Log.log("Beverages succesfully loaded!");
	}

	public static void loadSaveFile() {
		File saveFile = new File("Save.json");
		
		boolean loadSucces = SaveLoad.load(saveFile);
		if (!loadSucces) {
			Log.saveLog(true);
			System.exit(0);
		}
		
		String jsonFromFile = tempLoad.get(0);
		Save save = new Gson().fromJson(jsonFromFile, Save.class);
		
		Config.save = save;
		
		Log.log("Save File succesfully loaded!");
	}
	
	public static void loadActions() {
		//aktuell noch leer, soll noch kommen!
	}
	
	public static void saveGameData() {
		String jsonToSave = new Gson().toJson(Config.save, Save.class);
		tempSave.add(jsonToSave);
		File saveFile = new File("Save.json");
		boolean succes = SaveLoad.save(saveFile);
		
		if (!succes) {
			Log.saveLog(true);
			System.exit(0);
		}
		Log.log("Succesfully saved!");
	}

	private static String[][] to2DArray() {
		//Zur einfacheren verarbeitung das ganze in ein 2D Array Füllen
		String[][] inputList = new String[tempLoad.size()][3];
		int separatCounter = 0;
		for (int i = 0; i < tempLoad.size(); i++) {
			String line = tempLoad.get(i);
			if (line.equals("###")) {
				line = "marker";
				i++;
				String nextLine = tempLoad.get(i);
				inputList[separatCounter][0] = line;
				inputList[separatCounter][1] = null;
				inputList[separatCounter][2] = nextLine;
			} else {
				String[] splitLine = line.split(" ");
				inputList[separatCounter][0] = splitLine[0];
				inputList[separatCounter][1] = splitLine[1];
				String reCreateLine = "";
				for (int index = 2; index < splitLine.length; index++) {
					reCreateLine = reCreateLine + splitLine[index] + " ";
				}
				inputList[separatCounter][2] = reCreateLine;
			}
			separatCounter++;
		}
		return inputList;
	}
	
	private static String[][][] splitBySlash(String[][] inputList) {
		//Suchen nach " / " um das entsprechend die variationen auftzteilen
		String[][] variations = new String[inputList.length][];
		for (int i = 0; i < inputList.length; i++) {
			String[] lineVariation;
			String line = inputList[i][2];
			
			if (!inputList[i][0].equals("marker")) {
				String[] splitLine = line.split(" / ");
				if (splitLine.length == 1) {
					//Gibt keine variationen
					variations[i] = null;
				} else {
					
					//Das erste ist sowohl eine variation als auch keine, und wird daher in beide listen gefüllt
					inputList[i][2] = splitLine[0];
					//Alles weitere ist eine variation, und wird in die andere liste gefüllt
					lineVariation = new String[splitLine.length];
					for (int j = 0; j < splitLine.length; j++) {
						lineVariation[j] = splitLine[j];
					}
					variations[i] = lineVariation;
				}
			} else {
				variations[i] = null;
			}
		}
		String[][][] listReturner = new String[2][][];
		listReturner[0] = variations;
		listReturner[1] = inputList;
		return listReturner;
	}
	
	private static String[][][] splitByTilde(String[][] inputList, String[][] variations) {
		//Suchen nach " | " um die optionen zu erhalten
		String[][] options = new String[inputList.length][];
		for (int i = 0; i < inputList.length; i++) {
			String[] lineOption;
			String line;
			String[] temp = variations[i];
			boolean fromInputList;
			if (!inputList[i][0].equals("marker")) {
				if (variations[i] == null) {
					line = inputList[i][2];
					fromInputList = true;
				} else {
					line = temp[temp.length - 1];
					fromInputList = false;
				}
				
				String[] splitLine = line.split(" ~ ");
				if (splitLine.length == 1) {
					//es gibt keine optionen
					options[i] = null;
				} else {
					//Das erste ist keine option, kann also wieder zurück in die uhrsprungsliste
					if (fromInputList) {
						inputList[i][2] = splitLine[0];
					} else {
						temp[temp.length - 1] = splitLine[0];
					}
					//Der rest wird in eine separate Liste Gefüllt
					lineOption = new String[splitLine.length - 1];
					for (int j = 1; j < splitLine.length; j++) {
						lineOption[j - 1] = splitLine[j];
					}
					options[i] = lineOption;
					variations[i] = temp;
				}
			} else {
				options[i] = null;
			}
		}
		String[][][] listReturner = new String[3][][];
		listReturner[0] = options;
		listReturner[1] = variations;
		listReturner[2] = inputList;
		return listReturner;
	}
	
	public static String[][] fixNull(String[][] inputList) {
		int index = inputList.length;
		for (int i = 0; i < inputList.length; i++) {
			if (inputList[i][0] == null) {
				index = i;
				break;
			}
		}
		if (index == inputList.length) {
			return inputList; //alles ist gut, es gibt kein Null problem
		} else {
			String[][] correctList = new String[index][3];
			for (int i = 0; i < index; i++) {
				correctList[i][0] = inputList[i][0];
				correctList[i][1] = inputList[i][1];
				correctList[i][2] = inputList[i][2];
			}
			return correctList;
		}
	}
	
}
