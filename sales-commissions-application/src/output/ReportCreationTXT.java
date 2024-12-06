package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import data.AgentSalesAccount;


public class ReportCreationTXT extends ReportCreation{

	private BufferedWriter bufferedWriter = null;
	
	
	public ReportCreationTXT(AgentSalesAccount a, File reportFileTXT){
		agent = a;
		reportFile = reportFileTXT;
	}
	
	protected void createFile() 
	{
		try 
		{
			bufferedWriter = new BufferedWriter(new FileWriter(reportFile));
		}
		catch (IOException ex)
		{
			JOptionPane.showMessageDialog(null,"Δεν μπόρεσε να δημιουργηθεί το αρχείο.");
		}
	}

	protected void writeFile() 
	{
		try
		{
			bufferedWriter.write("Name: " + agent.getName());
	        bufferedWriter.newLine();
	
	        bufferedWriter.write("AFM: " + agent.getAfm());
	        bufferedWriter.newLine();
	        bufferedWriter.newLine();
	        bufferedWriter.newLine();
	
	        
	        bufferedWriter.write("Total Sales: " + agent.calculateTotalSales());
	        bufferedWriter.newLine();
	
	        bufferedWriter.write("Trousers Sales: " + agent.calculateSpecificKindSales("Trousers"));
	        bufferedWriter.newLine();
	
	        bufferedWriter.write("Skirts Sales: " + agent.calculateSpecificKindSales("Skirts"));
	        bufferedWriter.newLine();
	
	        bufferedWriter.write("Shirts Sales: " + agent.calculateSpecificKindSales("Shirts"));
	        bufferedWriter.newLine();
	        
	        bufferedWriter.write("Coats Sales: " + agent.calculateSpecificKindSales("Coats"));
	        bufferedWriter.newLine();
	
	        bufferedWriter.write("Commission: " + agent.calculateCommission());
		}
		catch (IOException ex)
		{
			JOptionPane.showMessageDialog(null,"Παρουσιάστηκε σφάλμα κατην την εγγραφή του αρχείου.");
		}
		
	}


	@Override
	protected void closeFile() 
	{
		try
		{
			bufferedWriter.close();
		}
		catch (IOException ex)
		{
			JOptionPane.showMessageDialog(null,"Παρουσιάστηκε σφάλμα κατα το κλείσιμο του αρχείου.");
		}
	}
	
}

