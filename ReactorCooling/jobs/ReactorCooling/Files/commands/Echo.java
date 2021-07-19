package jobs.ReactorCooling.Files.commands;

import jobs.ReactorCooling.DOS;
import jobs.ReactorCooling.Files.DOSProgrammInterface;

public class Echo implements DOSProgrammInterface {

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
