import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {
	
	private Account account;
	
	@BeforeEach
	void setUp() throws Exception {
		
		System.out.println("Running a unit test");
		account = new Account("ABC123", 500.00);
	}

	@AfterEach
	void tearDown() throws Exception {
		
		System.out.println("Finishing a unit test");
	}


	@Test
	void testAccountNumber() {
			
		assertEquals("ABC123", account.getAccountNumber());
		//assertEquals("123", account.getAccountNumber());
		//assertEquals("abc-123", account.getAccountNumber());
		//assertEquals("abc123!", account.getAccountNumber());
		//assertEquals("aBc123", account.getAccountNumber());
		//assertEquals(" ", account.getAccountNumber());
	}
	
	@Test
	void testAccountBalance() {
		
		assertEquals(500.00, account.getBalance());
		//assertEquals(10, account.getBalance());
		//assertEquals(-10.0, account.getBalance());
		//assertEquals("two", account.getBalance());
	}
	
	@Test
	void testIsActive() {
	
		assertEquals(true, account.isActive());
		//assertEquals(false, account.isActive());
		//assertEquals(" ", account.isActive());
	}
	
	@Test
	void testSetBalance() {
		
		account.setBalance(2000.00);
		
		//assertEquals("", account.getBalance());
		//assertEquals(1.00, account.getBalance());
		//assertEquals(500.00, account.getBalance());
		assertEquals(2000.00, account.getBalance());	
	}
	
	@Test
	void testSetActive() {
		
		account.setActive(false);
		
		//assertEquals("", account.isActive());
		//assertEquals(true, account.isActive());
		//assertEquals("false", account.isActive());
		assertEquals(false, account.isActive());	
	}
	
	@Test
	void testAddToBalance() {
		
		account.addToBalance(100.00);
	
		//assertEquals("", account.getBalance());
		//assertEquals("one hundred", account.getBalance());
		//assertEquals(450.00, account.getBalance());
		//assertEquals(500.00, account.getBalance());               //bug?
		//assertEquals(501, account.getBalance());
		//assertEquals(500.25, account.getBalance());
		assertEquals(600.00, account.getBalance());
	}
	
	@Test
	void testSubtractFromBalance() {
		
		account.subtractFromBalance(100.00);
	
		//assertEquals("", account.getBalance());
		//assertEquals("one hundred", account.getBalance());
		//assertEquals(450.00, account.getBalance());
		//assertEquals(500.00, account.getBalance());               //bug?
		//assertEquals(499, account.getBalance());
		//assertEquals(499.75, account.getBalance());
		assertEquals(400.00, account.getBalance());
	}
	
	@Test
	void testBadConstructorParam() {
			
		IllegalArgumentException e;
			
		e = assertThrows(IllegalArgumentException.class, ()-> new Account(" ", 500.00));         //bug
		assertEquals("invalid account number", e.getMessage());
	}
	
	@Test
    void testBadConstructorName()
    {
		badConstructorName(null);
		badConstructorName("");
		badConstructorName("    ");
        badConstructorName("\n");
        badConstructorName("\t");
        badConstructorName("\t    \n  \t");
    }


    void badConstructorName(final String attemptedName)
    {
        final IllegalArgumentException e;

        e = assertThrows(IllegalArgumentException.class, ()->new Account(attemptedName, 500.00));
        assertEquals("invalid account number", e.getMessage());
    }
	
}
