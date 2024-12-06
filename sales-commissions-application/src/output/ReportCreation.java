package output;

import java.io.File;
import java.io.IOException;

import data.AgentSalesAccount;

public abstract class ReportCreation {

	protected AgentSalesAccount agent;
	protected File reportFile;
	
	protected abstract void createFile();
	protected abstract void writeFile();
	protected abstract void closeFile() throws IOException;
	
	public void saveFile() throws IOException
	{
		createFile();
		writeFile();
		closeFile();
	}
}
