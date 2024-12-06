package input;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import data.Receipt;

public class ReceiptsFileWriterTxtTest 
{
	private static Input inputTXT;
	private static ReceiptsFileWriter receiptsFileWriterTXT;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		File testTXT = new File("test_write_files/test-case-1-TXT.txt");
		inputTXT = new TXTInput(testTXT);
		
		receiptsFileWriterTXT = new ReceiptsFileWriterTXT();
		receiptsFileWriterTXT.setFileToAppend(testTXT);
	}
	
	@Test
	public void addReceiptToTXTAgentsDataFileTest() throws IOException
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
		
		receiptsFileWriterTXT.setReceipt(expectedReceipt);
		receiptsFileWriterTXT.appendReceipt();
		
		inputTXT.readFile();
		
		ArrayList<Receipt> resultReceipts = inputTXT.getAgent().getReceipts();
		Receipt resultReceipt = inputTXT.getAgent().getReceipts().get(resultReceipts.size()-1);

		
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
