package input;

import java.io.File;
import java.io.IOException;

import data.Receipt;



public abstract class ReceiptsFileWriter {

	protected File fileToAppend;
	protected Receipt receipt = new Receipt();
		
	public abstract void setFileToAppend(File fileToAppend); 
	public abstract void openFile() throws Exception;
	public abstract void writeData() throws Exception; 
	public abstract void closeFile() throws Exception; 
	
	public final void appendReceipt() throws IOException
	{
		try 
		{
			openFile();
			writeData();
			closeFile();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
	
	public void setReceipt(Receipt receipt)
	{
		this.receipt = receipt;
	}
	
	public Receipt getReceipt() 
	{
		return receipt;
	}
	
	



}

