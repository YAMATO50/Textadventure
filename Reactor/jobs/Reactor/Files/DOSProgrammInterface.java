package jobs.Reactor.Files;

public interface DOSProgrammInterface {

	public void execute();
	
	public String[] getContents();
	
	public void setContents(String[] content);
	
	public int getLocation();
	
	public void setLocation(int location);
}
