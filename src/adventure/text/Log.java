package adventure.text;
import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Log {

	private static ArrayList<String> logList = new ArrayList<String>();
	
	public static void log(String line) {
		logList.add(System.currentTimeMillis() + " " + line);
	}
	
	public static void out(String line) {
		System.out.println(line);
	}
	
	public static void saveLog(boolean potentialyProblematic) {
		ProcessSaveFiles.tempSave = logList;
		
		String fileName = timeRelatetFileName();
		
		File saveLog = new File(fileName);
		try {
			saveLog.createNewFile();
		} catch (IOException e) {
			System.out.println("Failed to create Logfile!");
			System.out.println(e.toString());
		}
		boolean saveSucces = SaveLoad.save(saveLog);
		if (!saveSucces && potentialyProblematic) { //Wichtig für debugging zwecke. Sollten keine probleme auftreten ist es nicht so schlimm wenn keine logdatei vorhanden ist
			for (int i = 0; i < logList.size(); i++) {
				out(logList.get(i));
			}
			out("Es scheint ein fehler aufgetreten zu sein! Um das programm zu beenden, schliese die Konsole");
			try {
				Thread.sleep(1000 * 60 * 60 * 3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static String timeRelatetFileName() {
		String fileName = "";
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH mm ss");
		Date date = new Date();
		String strDate = dateFormat.format(date);
		
		fileName = "Log-" + strDate + ".txt";
		
		return fileName;
	}
	
}
