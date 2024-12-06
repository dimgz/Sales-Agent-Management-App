package data;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ReceiptTest {

	private static Receipt receipt;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		receipt = new Receipt();
	}

	@Test
	public void getAndSetReceiptIDTest() 
	{
		receipt.setReceiptID(1);
		assertEquals(1, receipt.getReceiptID());
	}

	@Test
	public void getAndSetDateTest() 
	{
		receipt.setDate("23/12/2050");
		assertEquals("23/12/2050", receipt.getDate());
	}
	
	@Test
	public void getAndSetSalesTest() 
	{
		receipt.setSales(99);
		assertTrue(99 == receipt.getSales());
	}
	
	@Test
	public void getAndSetItemsTest() 
	{
		receipt.setItems(100);
		assertTrue(100 == receipt.getItems());
	}
	
	@Test
	public void getAndSetKindTest() 
	{
		receipt.setKind("Shirts");
		assertEquals("Shirts", receipt.getKind());
	}
}
