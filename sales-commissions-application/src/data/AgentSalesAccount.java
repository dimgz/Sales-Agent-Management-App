package data;


import java.util.ArrayList;

import input.ReceiptsFileWriter;
import input.ReceiptsFileWriterHTML;
import input.ReceiptsFileWriterTXT;
import input.ReceiptsFileWriterXML;

public class AgentSalesAccount {
	static final double LOW_PERCENTAGE_COMMISSION = 0.1;
	static final double MEDIUM_PERCENTAGE_COMMISSION = 0.15;
	static final double HIGH_PERCENTAGE_COMMISSION = 0.2;
	static final double LOW_SALES_FUNDS = 6000;
	static final double MEDIUM_SALES_FUNDS = 10000;
	static final double HIGH_SALES_FUNDS = 40000;
	
	private String name;
	private String afm;
	private ArrayList <Receipt> allReceipts;
	private ReceiptsFileWriter fileAppender;
	
	
	public AgentSalesAccount(){
		allReceipts = new ArrayList<Receipt>();
	}
	
	public void setFileType(String fileType) {
		if(fileType.equals("TXT")){
			fileAppender = new ReceiptsFileWriterTXT();
		}	
		else if(fileType.equals("XML"))
		{
			fileAppender = new ReceiptsFileWriterXML();
		}	
		else
		{
			fileAppender = new ReceiptsFileWriterHTML();
		}
	}
	
	public ArrayList<Receipt> getReceipts(){
		return allReceipts;

	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAfm() {
		return afm;
	}
	
	public void setAfm(String afm) {
		this.afm = afm;
	}

	public double calculateTotalSales(){
		double sumSales = 0;
		for(int i = 0; i< allReceipts.size(); i++){
			sumSales += allReceipts.get(i).getSales();
		}
		return sumSales;
	}
	

	public int calculateTotalItems(){
		int sumItems = 0;
		for(int i = 0; i< allReceipts.size(); i++){
			sumItems += allReceipts.get(i).getItems();
		}
		return sumItems;
	}
	
	
	public float calculateSpecificKindSales(String kind)
	{
		float kindSum = 0;
		for (int i = 0; i< allReceipts.size(); i++)
		{
			if(allReceipts.get(i).getKind().equals(kind))
			{
				kindSum += allReceipts.get(i).getItems();
			}
		}
		
		return kindSum;
	}
	
	public double calculateCommission(){
		double commission = 0;
		double totalSales = this.calculateTotalSales();
		
		if(isEligibleForLowCommission(totalSales)){
			commission = calculateLowCommission(totalSales);
		}
		else if(isEligibleForMediumCommission(totalSales)){
			commission = calculateMediumCommission(totalSales);
		}
		else if(isEligibleForHighCommission(totalSales)) {
			commission = calculateHighCommission(totalSales);
		}
		return commission;
	}

	public boolean isEligibleForLowCommission(double totalSales)
	{
		if(totalSales > LOW_SALES_FUNDS && totalSales <= MEDIUM_SALES_FUNDS)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isEligibleForMediumCommission(double totalSales)
	{
		if(totalSales > MEDIUM_SALES_FUNDS && totalSales <= HIGH_SALES_FUNDS )
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isEligibleForHighCommission(double totalSales)
	{
		if(totalSales > HIGH_SALES_FUNDS )
		{
			return true;
		}
		
		return false;
	}
	
	public double calculateLowCommission(double totalSales)
	{
		return LOW_PERCENTAGE_COMMISSION * (totalSales - LOW_SALES_FUNDS);
	}
	
	public double calculateMediumCommission(double totalSales)
	{
		return (((totalSales - MEDIUM_SALES_FUNDS) * MEDIUM_PERCENTAGE_COMMISSION) + (MEDIUM_SALES_FUNDS*LOW_PERCENTAGE_COMMISSION));			
	}
	
	public double calculateHighCommission(double totalSales)
	{
		return MEDIUM_SALES_FUNDS*LOW_PERCENTAGE_COMMISSION + 30000*MEDIUM_PERCENTAGE_COMMISSION + (totalSales - HIGH_SALES_FUNDS)*HIGH_PERCENTAGE_COMMISSION;
	}
	
	
	
	public ReceiptsFileWriter getFileAppender() {
		return fileAppender;
	}


}
