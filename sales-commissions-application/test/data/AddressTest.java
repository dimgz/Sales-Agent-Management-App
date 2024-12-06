package data;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class AddressTest {

	private static Address address;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		address = new Address();
	}

	@Test
	public void getAndSetCountryTest()
	{
		String expectedCountry = "Ireland";
		address.setCountry(expectedCountry);
		
		assertEquals(expectedCountry, address.getCountry());
	}
	
	@Test
	public void getAndSetCityTest()
	{
		String expectedCity = "Dublin";
		address.setCity(expectedCity);
		
		assertEquals(expectedCity, address.getCity());
	}
	
	@Test
	public void getAndSetStreetTest()
	{
		String expectedStreet = "Papandreou";
		address.setStreet(expectedStreet);
		
		assertEquals(expectedStreet, address.getStreet());
	}

	@Test
	public void getAndSetStreetNumberTest()
	{
		int expectedStreetNumber = 39; 
		address.setStreetNumber(expectedStreetNumber);
		
		assertEquals(expectedStreetNumber, address.getStreetNumber());
	}
	
	@Test
	public void getAndSetPhoneNumberTest()
	{
		int expectedPhoneNumber = 69;
		address.setPhoneNumber(expectedPhoneNumber);
		
		assertEquals(expectedPhoneNumber, address.getPhoneNumber());
	}
}
