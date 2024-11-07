import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankTest {
	
	private HashMap<String, Customer> theBank;

	@BeforeEach
	void setUp() throws Exception {
		
		theBank = new HashMap<String, Customer>();
		System.out.println("Running a unit test");
	}

	@AfterEach
	void tearDown() throws Exception {
	
		System.out.println("Finishing a unit test");
	}


	@Test
	void testAddCustomer() {
		
		Bank bank1 = new Bank();
		
		Account account1 = new Account("ABC123", 500.00);
		Customer customer1 = new Customer("Michael", "Jordan", "def456");
		
		customer1.setAccount(account1);
		bank1.addCustomer(customer1);
		
		for (Entry<String, Customer> entry : theBank.entrySet()) {
		    Customer value = entry.getValue();
		    assertEquals("Michael", value.getFirstName());
		    //assertEquals("Joe", value.getFirstName());
		 	}
	}
	
	@Test
	void testDisplayAllCustomers() {
		
		Bank bank1 = new Bank();
		
		Account account1 = new Account("ABC123", 100.00);
		Account account2 = new Account("DEF456", 200.00);
		Account account3 = new Account("GHI789", 300.00);
		Customer customer1 = new Customer("Adam", "Tesla", "1h3j4");
		Customer customer2 = new Customer("Brian", "Ferrari", "123456");
		Customer customer3 = new Customer("Natalie", "Nissan", "0000");
		
		customer1.setAccount(account1);
		
		bank1.addCustomer(customer1);
		
		assertEquals("Customer [firstName=Adam, lastName=Tesla, passcode=1h3j4, account=Account [accountNumber=ABC123, balance=100.0, active=true]]", customer1.toString());
		
	}
	
	@Test
	void testDisplayCustomerInformation() {
		
		Bank bank1 = new Bank();
		
		Account account1 = new Account("ABC123", 100.00);
		Account account2 = new Account("DEF456", 200.00);
		Account account3 = new Account("GHI789", 300.00);
		Customer customer1 = new Customer("Adam", "Tesla", "1h3j4");
		Customer customer2 = new Customer("Brian", "Ferrari", "123456");
		Customer customer3 = new Customer("Natalie", "Nissan", "0000");
		
		customer1.setAccount(account1);
		customer2.setAccount(account2);
		customer3.setAccount(account3);
		
		bank1.addCustomer(customer1);
		bank1.addCustomer(customer2);
		bank1.addCustomer(customer3);
		
		assertEquals("Customer [firstName=Adam, lastName=Tesla, passcode=1h3j4, account=Account [accountNumber=ABC123, balance=100.0, active=true]]", customer1.toString());
		//assertEquals("", customer2.toString());
		}
	
	@Test
	void testCloseAccount() {
		
		Bank bank1 = new Bank();
		
		Account account1 = new Account("ABC123", 100.00);
		Account account2 = new Account("DEF456", 200.00);
		Customer customer1 = new Customer("Adam", "Tesla", "1h3j4");
		Customer customer2 = new Customer("Brian", "Ferrari", "123456");
		
		customer1.setAccount(account1);
		customer2.setAccount(account2);
		
		bank1.addCustomer(customer1);
		bank1.addCustomer(customer2);
		
		//bank1.displayAllCustomers();
		
		bank1.closeAccount(customer1.getAccount().getAccountNumber());
		
		assertEquals(1, theBank.size());                                            //bug
		
	}
	

}
