package output;

import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.BeforeClass;
import org.junit.Test;
import input.HTMLInput;
import input.Input;

public class ReportCreationHtmlTest {

	private static Input inputHTML;
	private static ReportCreation reportHTML;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		File testInputHTML = new File("test_input_files/test-case-3-HTML.html");
		inputHTML = new HTMLInput(testInputHTML);
		inputHTML.readFile();
		
		reportHTML = new ReportCreationHTML(inputHTML.getAgent(), new File("testReport.html"));
		
	}

	@Test
	public void exportToTxtNotNullTest() throws IOException 
	{
		
		reportHTML.saveFile();
		
		assertNotNull("testReport.html");
	}
	
	@Test
	public void readReportAndVerifyWrittenDataHtmlTest() throws IOException 
	{
		Document doc = Jsoup.parse(new File("testReport.html"));
		
		Elements nodeLst = doc.select("body");
				
    	String name = nodeLst.first().select("h2").text().trim().replace("Name: ", "");
    	String afm = nodeLst.first().select("h4").text().trim().replace("AFM: ", "");
    	
    	String totalSales = nodeLst.first().select("div").select("p").get(0).text().trim().replace("Total Sales: ", "");
    	String trouserSales = nodeLst.first().select("div").select("p").get(1).text().trim().replace("Trouser Sales: ", "");
    	String skirtShales = nodeLst.first().select("div").select("p").get(2).text().trim().replace("Skirt Sales: ", "");
    	String shirtShales = nodeLst.first().select("div").select("p").get(3).text().trim().replace("Shirt Sales: ", "");
    	String coatSales = nodeLst.first().select("div").select("p").get(4).text().trim().replace("Coat Sales: ", "");
    	String commission = nodeLst.first().select("div").select("p").get(5).text().trim().replace("Commission: ", "");
    	
    	
    	
    	assertEquals("Thodoris gouzou", name);
    	assertEquals("130456099", afm);
    	assertEquals("8000.0", totalSales);
    	assertEquals("0.0", trouserSales);
    	assertEquals("0.0", skirtShales);
    	assertEquals("115.0", shirtShales);
    	assertEquals("10.0", coatSales);
    	assertEquals("200.0", commission);
    	
	}

}
