package jobs.Reactor.Files.commands;

import jobs.Reactor.Files.DOSProgrammInterface;
import jobs.Reactor.DOS;

public class Echo implements DOSProgrammInterface {


	private int location = -1;
	
	public int getLocation() {
		return this.location;
	}
	
	public void setLocation(int location) {
	}
	
	public void execute() {
		for (int i = 1; i < DOS.args_.length; i++) {
			System.out.print(DOS.args_[i] + " ");
		}
		System.out.print("\n");
	}

	
	public String[] getContents() {
		return null;
	}

	
	public void setContents(String[] content) {

	}

}
