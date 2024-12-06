package input;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.BeforeClass;
import org.junit.Test;
import data.Receipt;

public class TXTInputTest 
{

	private static Input inputTXT;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		File testTXT = new File("test_input_files/test-case-1-TXT.txt");
		inputTXT = new TXTInput(testTXT);
		inputTXT.readFile();
	}
	
	@Test
	public void inputAgentDataFromTXTTest() 
	{
		String expectedName = "Apostolos Zarras";
		String expectedAFM = "130456093";

		Receipt expectedReceipt = new Receipt();
		expectedReceipt.setReceiptID(2);
		expectedReceipt.setDate("25/2/2014");
		expectedReceipt.setKind("Coats");
		expectedReceipt.setSales(4000);
		expectedReceipt.setItems(10);
		expectedReceipt.getCompany().setName("Hand Made Clothes");
		expectedReceipt.getCompany().getCompanyAddress().setCountry("Greece");
		expectedReceipt.getCompany().getCompanyAddress().setCity("Ioannina");
		expectedReceipt.getCompany().getCompanyAddress().setStreet("Kaloudi");
		expectedReceipt.getCompany().getCompanyAddress().setStreetNumber(10);
		
		String resultName = inputTXT.getAgent().getName();
		String resultAFM = inputTXT.getAgent().getAfm();
		Receipt resultReceipt = inputTXT.getAgent().getReceipts().get(1);

		assertEquals(expectedName, resultName);
		assertEquals(expectedAFM, resultAFM);

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
