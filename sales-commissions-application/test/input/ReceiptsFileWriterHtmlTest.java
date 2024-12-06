package input;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import data.Receipt;

public class ReceiptsFileWriterHtmlTest
{
	private static Input inputHTML;
	private static ReceiptsFileWriter receiptsFileWriterHTML;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		File testHTML = new File("test_write_files/test-case-3-HTML.html");
		inputHTML = new HTMLInput(testHTML);
		
		receiptsFileWriterHTML = new ReceiptsFileWriterHTML();
		receiptsFileWriterHTML.setFileToAppend(testHTML);
	}

	@Test
	public void addReceiptToHTMLAgentsDataFileTest() throws IOException
	{
		Receipt expectedReceipt = new Receipt();
		expectedReceipt.setReceiptID(50);
		expectedReceipt.setDate("25/2/2014");
		expectedReceipt.setKind("Coats");
		expectedReceipt.setSales(4000);
		expectedReceipt.setItems(10);
		expectedReceipt.getCompany().setName("Hand Made Clothes");
		expectedReceipt.getCompany().getCompanyAddress().setCountry("Greece");
		expectedReceipt.getCompany().getCompanyAddress().setCity("Ioannina");
		expectedReceipt.getCompany().getCompanyAddress().setStreet("Kaloudi");
		expectedReceipt.getCompany().getCompanyAddress().setStreetNumber(10);
		
		receiptsFileWriterHTML.setReceipt(expectedReceipt);
		receiptsFileWriterHTML.appendReceipt();
		
		inputHTML.readFile();
		
		ArrayList<Receipt> resultReceipts = inputHTML.getAgent().getReceipts();
		Receipt resultReceipt = inputHTML.getAgent().getReceipts().get(resultReceipts.size()-1);

		
		assertEquals(expectedReceipt.getReceiptID(), resultReceipt.getReceiptID());
		assertEquals(expectedReceipt.getDate(), resultReceipt.getDate());
		assertEquals(expectedReceipt.getKind(), resultReceipt.getKind());
		assertEquals(expectedReceipt.getSales(), resultReceipt.getSales(), 0);
		assertEquals(expectedReceipt.getItems(), resultReceipt.getItems());
		assertEquals(expectedReceipt.getCompany().getName(), resultReceipt.getCompany().getName());
		assertEquals(expectedReceipt.getCompany().getCompanyAddress().getCountry(), resultReceipt.getCompany().getCompanyAddress().getCountry());
		assertEquals(expectedReceipt.getCompany().getCompanyAddress().getCity(), resultReceipt.getCompany().getCompanyAddress().getCity());
		assertEquals(expectedReceipt.getCompany().getCompanyAddress().getStreet(), resultReceipt.getCompany().getCompanyAddress().getStreet());
		assertEquals(expectedReceipt.getCompany().getCompanyAddress().getStreetNumber(), resultReceipt.getCompany().getCompanyAddress().getStreetNumber());	

	}
}
