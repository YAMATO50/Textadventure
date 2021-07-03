package jobs.Reactor;

public class DosElement {

	public int location;
	public int origin;
	public int[] canSee;
	public int type; //0 = Ordner, 1 = .txt, 2 = .exe
	public String name;
	public boolean hasLowerDir; //false für dateien, wird aber in dem fall nicht geprüft
	public String[] fileContent;
	
	public DosElement(int location, int origin, int[] canSee, int type, String name, boolean hasLowerDir) {
		this.location = location;
		this.origin = origin;
		this.canSee = canSee;
		this.type = type;
		this.name = name;
		this.hasLowerDir = hasLowerDir;
	}
	
	public DosElement(int location, int origin, int type, String name, String[] fileContent) {
		this.location = location;
		this.origin = origin;
		this.type = type;
		this.name = name;
		this.fileContent = fileContent;
	}
	
	public DosElement(int location, int origin, int type, String name) {
		this.location = location;
		this.origin = origin;
		this.type = type;
		this.name = name;
	}
	
}
