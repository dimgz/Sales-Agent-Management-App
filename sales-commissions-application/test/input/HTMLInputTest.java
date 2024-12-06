package input;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.BeforeClass;
import org.junit.Test;
import data.Receipt;

public class HTMLInputTest 
{
	private static Input inputHTML;
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		File testHTML = new File("test_input_files/test-case-3-HTML.html");
		inputHTML = new HTMLInput(testHTML);
		inputHTML.readFile();
	}
	
	@Test
	public void inputAgentDataFromHTMLTest() 
	{
		String expectedName = "Thodoris gouzou";
		String expectedAFM = "130456099";

		Receipt expectedReceipt = new Receipt();
		expectedReceipt.setReceiptID(1);
		expectedReceipt.setDate("25/2/2023");
		expectedReceipt.setKind("Coats");
		expectedReceipt.setSales(2000);
		expectedReceipt.setItems(10);
		expectedReceipt.getCompany().setName("Hand Made Clothes");
		expectedReceipt.getCompany().getCompanyAddress().setCountry("Greece");
		expectedReceipt.getCompany().getCompanyAddress().setCity("Ioannina");
		expectedReceipt.getCompany().getCompanyAddress().setStreet("Kaloudi");
		expectedReceipt.getCompany().getCompanyAddress().setStreetNumber(10);
		
		String resultName = inputHTML.getAgent().getName();
		String resultAFM = inputHTML.getAgent().getAfm();
		Receipt resultReceipt = inputHTML.getAgent().getReceipts().get(0);

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
