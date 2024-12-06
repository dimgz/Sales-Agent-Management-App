package output;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import input.Input;
import input.TXTInput;

public class ReportCreationTxtTest 
{
	private static Input inputTXT;
	private static ReportCreation reportTXT;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		File testInputTXT = new File("test_input_files/test-case-1-TXT.txt");
		inputTXT = new TXTInput(testInputTXT);
		inputTXT.readFile();
		
		reportTXT = new ReportCreationTXT(inputTXT.getAgent(), new File("testReport.txt"));
		
	}

	@Test
	public void exportToTxtNotNullTest() throws IOException 
	{
		
		reportTXT.saveFile();
		
		assertNotNull("testReport.txt");
	}
	
	@Test
	public void readReportAndVerifyWrittenDataTxtTest() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("testReport.txt"));
		
		String line = br.readLine();
		String name = line.substring(line.indexOf(":") + 1).trim();
		
		line = br.readLine();
		String afm = line.substring(line.indexOf(":") + 1).trim();
		
		line = br.readLine();
		line = br.readLine();
		line = br.readLine();
		String totalSales = line.substring(line.indexOf(":") + 1).trim();
		
		line = br.readLine();
		String trouserSales = line.substring(line.indexOf(":") + 1).trim();
		
		line = br.readLine();
		String skirtSales = line.substring(line.indexOf(":") + 1).trim();
		
		line = br.readLine();
		String shirtSales = line.substring(line.indexOf(":") + 1).trim();
		
		line = br.readLine();
		String coatSales = line.substring(line.indexOf(":") + 1).trim();
		
		line = br.readLine();
		String commission = line.substring(line.indexOf(":") + 1).trim();
		
		br.close();
		
		assertEquals("Apostolos Zarras", name);
		assertEquals("130456093", afm);
		assertEquals("22000.0", totalSales);
		assertEquals("20.0", trouserSales);
		assertEquals("20.0", skirtSales);
		assertEquals("10.0", shirtSales);
		assertEquals("20.0", coatSales);
		assertEquals("2800.0", commission);

	}

	
	@AfterClass
	public static void removeTestFilesAfterClass() throws IOException 
	{
		File testTXT = new File("testReport.txt");
		testTXT.delete();
		
	}
	


}
