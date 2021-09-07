package jobs.Reactor.directory;

public class Directory {

	private int location;
	private int identifyer;
	private String name;
	
	public Directory(int location, int identifyer, String name) {
		this.location = location;
		this.name = name;
		this.identifyer = identifyer;
	}
	
	public int getLocation() {
		return this.location;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getIdentifyer() {
		return this.identifyer;
	}
}
