package jobs.Reactor.Files.txt;

import jobs.Reactor.Files.DOSProgrammInterface;

public class TXT implements DOSProgrammInterface {

	public TXT(String[] content, int location) {
		this.location = location;
		this.content = content;
	}
	
	private String[] content;
	
	private int location;
	
	public int getLocation() {
		return this.location;
	}
	
	public void setLocation(int location) {
		this.location = location;
	}
	
	@Override
	public void execute() {
		for (int i = 0; i < content.length; i++) {
			System.out.println(content[i]);
		}

	}

	@Override
	public String[] getContents() {
		return this.content;
	}

	@Override
	public void setContents(String[] content) {
		this.content = content;

	}

}
