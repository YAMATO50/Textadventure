package adventure.text;
import java.util.Scanner;
import template.object.customizables.Food;
import template.object.customizables.Beverages;
import template.object.json.Save;

public class Config {

	public static Food food;
	public static Beverages beverage;
	public static Save save;
	public static Scanner keyScan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		load();
		
		startGame();

		save();
		keyScan.close();
		System.out.println("Auf wiedersehen!"); //hier findet sich bestimmt noch was besseres
		TextAdventure.wait(10000);
	}
	
	private static void load() {
		ProcessSaveFiles.loadFood();
		ProcessSaveFiles.loadBeverages();
		ProcessSaveFiles.loadSaveFile();
		ProcessSaveFiles.loadActions();
	}
	
	private static void startGame() {
		TextAdventure.start();
	}
	
	private static void save() {
		ProcessSaveFiles.saveGameData();
		Log.saveLog(false);
	}

}
