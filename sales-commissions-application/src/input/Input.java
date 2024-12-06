package input;


import java.io.File;

import data.AgentSalesAccount;
import data.Receipt;

public abstract class Input {
	
	protected AgentSalesAccount agent;
	protected File inputFile;
	protected String inputFilePath;
	protected String name;
	protected String afm;
	protected int receiptID;
	protected String date;
	protected String kind;
	protected double sales;
	protected int items;
	protected String companyName;
	protected String companyCountry;
	protected String companyCity;
	protected String companyStreet;
	protected int companyStreetNumber;

	protected abstract void openFile();
	protected abstract void readData();
	protected abstract void closeFile();
	
	public Input() {
		agent = new AgentSalesAccount();
		kind  = new String("");
	}
	

	public void addAgent() {
		agent.setName(name);
		agent.setAfm(afm);
	}
	
	public void readFile()
	{
		openFile();
		readData();
		closeFile();
	}
	
	public void addReceipt( ){
		Receipt receipt;
		
		if(isSpecificKind(kind)) 
		{
			receipt= new Receipt(kind);
		}
		else 
		{
				receipt = new Receipt();
		}
			
		receipt.setReceiptID(receiptID);			
		receipt.setDate(date);
		receipt.setSales(sales);
		receipt.setItems(items);
		receipt.getCompany().setName(companyName);
		receipt.getCompany().getCompanyAddress().setCountry(companyCountry);
		receipt.getCompany().getCompanyAddress().setCity(companyCity);
		receipt.getCompany().getCompanyAddress().setStreet(companyStreet);
		receipt.getCompany().getCompanyAddress().setStreetNumber(companyStreetNumber);
		agent.getReceipts().add(receipt);
	}
	
	public boolean isSpecificKind(String kind)
	{
		if(kind.equals("Shirts") || kind.equals("Skirts") || kind.equals("Trousers" ) || kind.equals("Coats"))
		{
			return true;
		}
		
		return false;
	}
	
	public AgentSalesAccount getAgent() {
		return agent;
	}

	
}
