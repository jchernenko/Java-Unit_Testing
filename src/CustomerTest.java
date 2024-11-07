import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
	
	private Customer customer;


	@BeforeEach
	void setUp() throws Exception {
		
		System.out.println("Running a unit test");
		customer = new Customer("Joe", "Smith", "ABC123");
	}

	@AfterEach
	void tearDown() throws Exception {
		
		System.out.println("Finishing a unit test");
	}

	@Test
	void testFirstName() {
			
		assertEquals("Joe", customer.getFirstName());
		//assertEquals("123", customer.getFirstName());
		//assertEquals("J", customer.getFirstName());
		//assertEquals("J.R", customer.getFirstName());
		//assertEquals("J K", customer.getFirstName());
		//assertEquals("", customer.getFirstName());
	}
	
	@Test
	void testLastName() {
			
		assertEquals("Smith", customer.getLastName());
		//assertEquals("123", customer.getLastName());
		//assertEquals("S", customer.getLastName());
		//assertEquals("S-R", customer.getLastName());
		//assertEquals("", customer.getLastName());
	}
	
	@Test
	void testPasscode() {
			
		assertEquals("ABC123", customer.getPasscode());
		//assertEquals("123", customer.getPasscode());
		//assertEquals("abc-123", customer.getPasscode());
		//assertEquals("abc123!", customer.getPasscode());
		//assertEquals(" ", customer.getPasscode());
	}
	
	@Test
	void testSetFirstName() {
		
		customer.setFirstName("John");
		
		assertEquals("John", customer.getFirstName());
		//assertEquals("123", customer.getFirstName());          //bug
		//assertEquals("JoHn", customer.getFirstName());         //bug
		//assertEquals("F rank", customer.getFirstName());	     //bug
		//assertEquals(" ", customer.getFirstName());
	}
	
	@Test
	void testSetLastName() {
		
		customer.setLastName("Fraser");
		
		assertEquals("Fraser", customer.getLastName());
		//assertEquals("123", customer.getLastName());          //bug
		//assertEquals("FrAsEr", customer.getLastName());       //bug
		//assertEquals("F raser", customer.getLastName());      //bug
		//assertEquals(" ", customer.getLastName());
	}
	
	@Test
	void testSetPasscode() {
		
		customer.setPasscode("a1b2c3");
		
		assertEquals("a1b2c3", customer.getPasscode());
		//assertEquals("aBc123", customer.getPasscode());
		//assertEquals("aaa 111", customer.getPasscode());      //bug?
		//assertEquals("123", customer.getPasscode());
		//assertEquals("a", customer.getPasscode());          //bug
		//assertEquals(" ", customer.getPasscode());
	}
	
	@Test
	void testGetAccount() { //not entirely sure I did this one correctly.
		
		Account account = new Account("YXZ987", 500.00);
		customer.setAccount(account);
		
		assertEquals("YXZ987", customer.getAccount().getAccountNumber());
		//assertEquals("abc123", customer.getAccount().getAccountNumber());
	}
	
	@Test
	void testSetAccount() {
		
		//Account account1 = new Account("xyz987", 10.00);
		Account account2 = new Account("abc123", 500.00);
		
		customer.setAccount(account2);
		
		assertEquals(account2.getAccountNumber(), customer.getAccount().getAccountNumber());
		//assertEquals(account1.getAccountNumber(), customer.getAccount().getAccountNumber());
	}
	
}
