package adventure.text;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SaveLoad {

	public static boolean save(File fileToSave) { //Gibt in einem boolean zurück ob das speichern erfolgreich war
		ArrayList<String> fileContent = ProcessSaveFiles.tempSave;
		try {
			PrintWriter output = new PrintWriter(fileToSave);
			for (int i = 0; i < fileContent.size(); i++) {
				output.println(fileContent.get(i));
			}
			output.close();
		} catch (FileNotFoundException e) {
			Log.log("Unable to save to File " + fileToSave.getName());
			Log.log("Further informations: ");
			Log.log(fileToSave.getAbsolutePath());
			Log.log(e.getMessage());
			
			if (e.getCause() != null) {
				Log.log(e.getCause().toString());
			}
			
			Log.out("Daten konnten in Datei " + fileToSave.getName() + " nicht gespeichert werden! Für genauere informationen schaue bitte in die Log datei!");
			ProcessSaveFiles.tempSave.clear();
			return false;
		}
		ProcessSaveFiles.tempSave.clear();
		return true;
	}
	
	public static boolean load(File fileToLoad) { //Gibt in einem boolean zurück ob das laden erfolgreich war
		String encoding = "UTF-8";
		ArrayList<String> fileContent = new ArrayList<String>();
		try {
			Scanner fileInput = new Scanner(fileToLoad, encoding);
			while (fileInput.hasNext()) {
				fileContent.add(fileInput.nextLine());
			}
			fileInput.close();
		} catch (FileNotFoundException e) {
			Log.log("Unable to load File " + fileToLoad.getName());
			Log.log("Further informations: ");
			Log.log(fileToLoad.getAbsolutePath());
			Log.log(e.getMessage());
			Log.log(e.getCause().toString());
			Log.out("Datei " + fileToLoad.getName() + " konnte nicht geladen werden! Für genauere informationen schaue bitte in die Log datei!");
			return false;
		}
		
		ProcessSaveFiles.tempLoad.clear();
		ProcessSaveFiles.tempLoad = fileContent;
		return true;
	}
	
}
