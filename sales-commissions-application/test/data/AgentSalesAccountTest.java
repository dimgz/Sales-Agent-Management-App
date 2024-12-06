package data;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.Test;
import input.ReceiptsFileWriterHTML;
import input.ReceiptsFileWriterTXT;
import input.ReceiptsFileWriterXML;

public class AgentSalesAccountTest 
{
	private static AgentSalesAccount agent;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		agent = new AgentSalesAccount();
		
		ArrayList<Receipt> receipts = agent.getReceipts();
		for(int i=0; i<5; i++)
		{
			receipts.add(new Receipt());
			receipts.get(i).setSales(5000);
			receipts.get(i).setItems(5);
		}
	}

	@Test
	public void getAndSetNameTest() 
	{
		agent.setName("Thodoris Florentzis");
		assertEquals("Thodoris Florentzis", agent.getName());
	}
	
	@Test
	public void getAndSetAFMTest() 
	{
		agent.setAfm("123456789");
		assertEquals("123456789", agent.getAfm());
	}
	
	@Test
	public void setFileTypeTXTTest() 
	{
		ReceiptsFileWriterTXT expectedObject = new ReceiptsFileWriterTXT();
		agent.setFileType("TXT");
		
		assertEquals(expectedObject.getClass(), agent.getFileAppender().getClass());
	}
	
	@Test
	public void setFileTypeXMLTest() 
	{
		ReceiptsFileWriterXML expectedObject = new ReceiptsFileWriterXML();
		agent.setFileType("XML");

		assertEquals(expectedObject.getClass(), agent.getFileAppender().getClass());
	}
	
	@Test
	public void setFileTypeHTMLTest() 
	{
		ReceiptsFileWriterHTML expectedObject = new ReceiptsFileWriterHTML();
		agent.setFileType("HTML");
		
		assertEquals(expectedObject.getClass(), agent.getFileAppender().getClass());

	}
	
	@Test
	public void calculateTotalSalesTest()
	{	
		assertTrue(agent.calculateTotalSales() == 25000);
	}

	@Test
	public void calculateTotalItemsTest()
	{
		assertTrue(agent.calculateTotalItems() == 25);
	}
	
	@Test
	public void calculateSpecificKindSalesTest()
	{
		agent.getReceipts().get(0).setKind("Coats");
		agent.getReceipts().get(1).setKind("Trousers");
		agent.getReceipts().get(2).setKind("Shirts");
		agent.getReceipts().get(3).setKind("Skirts");
		agent.getReceipts().get(4).setKind("Skirts");
		
		assertTrue(agent.calculateSpecificKindSales("Coats") == 5);
		assertTrue(agent.calculateSpecificKindSales("Trousers") == 5);
		assertTrue(agent.calculateSpecificKindSales("Shirts") == 5);
		assertTrue(agent.calculateSpecificKindSales("Skirts") == 10);
		
	}
	
	@Test
	public void isEligibleForLowCommissionTest()
	{
		assertTrue(agent.isEligibleForLowCommission(10000));
	}
	
	@Test
	public void isEligibleForMediumCommissionTest()
	{
		assertTrue(agent.isEligibleForMediumCommission(40000));
	}
	
	@Test
	public void isEligibleForHighCommissionTest()
	{
		assertTrue(agent.isEligibleForHighCommission(50000));
	}
	
	@Test
	public void calculateCommissionLowTest()
	{
		assertTrue(agent.calculateCommission() == 3250);
	}
	
}
