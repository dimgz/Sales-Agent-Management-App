package output;

import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import input.Input;
import input.XMLInput;

public class ReportCreationXmlTest {
	private static Input inputXML;
	private static ReportCreation reportXML;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		File testInputXML = new File("test_input_files/test-case-2-XML.xml");
		inputXML = new XMLInput(testInputXML);
		inputXML.readFile();
		
		reportXML = new ReportCreationXML(inputXML.getAgent(), new File("testReport.xml"));
	}

	
	@Test
	public void exportToTxtNotNullTest() throws IOException 
	{
		reportXML.saveFile();
		
		assertNotNull("testReport.xml");
	}
	
	@Test
	public void readReportAndVerifyWrittenDataXmlTest() throws SAXException, IOException, ParserConfigurationException
	{
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse("testReport.xml");
		
		doc.getDocumentElement().normalize();
        NodeList nodeLst = doc.getElementsByTagName("Agent");
		
    	String name = ((Element) nodeLst.item(0)).getElementsByTagName("Name").
		item(0).getChildNodes().item(0).getNodeValue().trim();
		
    	String afm = ((Element) nodeLst.item(0)).getElementsByTagName("AFM").
		item(0).getChildNodes().item(0).getNodeValue().trim();
    	
    	String totalSales =  ((Element) nodeLst.item(0)).getElementsByTagName("TotalSales").
    	item(0).getChildNodes().item(0).getNodeValue().trim();
    	
    	String trouserSales =  ((Element) nodeLst.item(0)).getElementsByTagName("TrouserSales").
    	item(0).getChildNodes().item(0).getNodeValue().trim();
    	
    	String skirtSales =  ((Element) nodeLst.item(0)).getElementsByTagName("SkirtsSales").
    	item(0).getChildNodes().item(0).getNodeValue().trim();
    	
    	String shirtSales =  ((Element) nodeLst.item(0)).getElementsByTagName("ShirtsSales").
    	item(0).getChildNodes().item(0).getNodeValue().trim();
    	
    	String coatSales =  ((Element) nodeLst.item(0)).getElementsByTagName("CoatsSales").
    	item(0).getChildNodes().item(0).getNodeValue().trim();
    	
    	String commission =  ((Element) nodeLst.item(0)).getElementsByTagName("Commission").
    	item(0).getChildNodes().item(0).getNodeValue().trim();
    	
		assertEquals("Vassileios Zarras", name);
		assertEquals("130456097", afm);
		assertEquals("34000.0", totalSales);
		assertEquals("20.0", trouserSales);
		assertEquals("40.0", skirtSales);
		assertEquals("20.0", shirtSales);
		assertEquals("40.0", coatSales);
		assertEquals("4600.0", commission);
	}
	
	
	@AfterClass
	public static void removeTestFilesAfterClass() throws IOException 
	{
		File testXML = new File("testReport.xml");
		testXML.delete();
		
	}

}
