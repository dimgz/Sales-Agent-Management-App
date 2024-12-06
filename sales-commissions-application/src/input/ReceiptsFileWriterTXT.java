package input;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptsFileWriterTXT extends ReceiptsFileWriter
{
	private FileWriter fileWriter;
	
	public  void setFileToAppend(File fileToAppend) {
		
		this.fileToAppend = fileToAppend;
		
	}
	
	public void openFile() throws IOException
	{
		fileWriter = new FileWriter(fileToAppend,true);
	}
	
	public void writeData() throws IOException
	{
		fileWriter.write("\n");
		fileWriter.write("Receipt ID: ");
		fileWriter.write((String.valueOf(receipt.getReceiptID())));
		fileWriter.write("\n");
		
		fileWriter.write("Date: ");
		fileWriter.write(receipt.getDate());
		fileWriter.write("\n");

		fileWriter.write("Kind: ");
		fileWriter.write(receipt.getKind());
		fileWriter.write("\n");

		fileWriter.write("Sales: ");
		fileWriter.write(String.valueOf(receipt.getSales()));
		fileWriter.write("\n");

		fileWriter.write("Items: ");
		fileWriter.write(String.valueOf(receipt.getItems()));
		fileWriter.write("\n");

		fileWriter.write("Company: ");
		fileWriter.write(receipt.getCompany().getName());
		fileWriter.write("\n");

		fileWriter.write("Country: ");
		fileWriter.write(receipt.getCompany().getCompanyAddress().getCountry());
		fileWriter.write("\n");
		
		fileWriter.write("City: ");
		fileWriter.write(receipt.getCompany().getCompanyAddress().getCity());
		fileWriter.write("\n");

		fileWriter.write("Street: ");
		fileWriter.write(receipt.getCompany().getCompanyAddress().getStreet());
		fileWriter.write("\n");

		fileWriter.write("Number: ");
		fileWriter.write(Integer.toString(receipt.getCompany().getCompanyAddress().getStreetNumber()));
		fileWriter.write("\n");
	}
	
	public void closeFile() throws IOException
	{
		fileWriter.close();
	}
	


}
