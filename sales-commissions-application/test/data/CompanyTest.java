package data;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class CompanyTest 
{
	private static Company company;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		company = new Company();
	}

	@Test
	public void getAndSetCompanyNameTest() 
	{
		String expectedCompanyName = "Thodoris Guitar Shop";
		company.setName(expectedCompanyName);
		
		assertEquals(expectedCompanyName, company.getName());
	}
	
	@Test
	public void getAndSetAddressTest()
	{
		Address address = company.getCompanyAddress();
	
		address.setCountry("Ireland");
		address.setCity("Dublin");
		address.setStreet("Velouhioti");
		address.setStreetNumber(77);
		address.setPhoneNumber(69);
		
		assertEquals("Ireland", address.getCountry());
		assertEquals("Dublin", address.getCity());
		assertEquals("Velouhioti", address.getStreet());
		assertEquals(77, address.getStreetNumber());
		assertEquals(69, address.getPhoneNumber());
	}

}
