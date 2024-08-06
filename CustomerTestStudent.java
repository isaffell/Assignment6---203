/*
* Class: CMSC203
* Instructor: Grigory Grinberg
* Description: Student tests to test the features of the customer class. 
* Due: 08/05/2024
* Platform/compiler: Eclipse IDE
* I pledge that I have completed the programming
Deliverables
* assignment independently. I have not copied the code
* from a student or any source. I have not given my code
* to any student.
Print your Name here: Isabel Saffell
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CustomerTestStudent {


	private Customer customer;
	private Customer customerCopy;

	@BeforeEach
	public void setUp() {
		customer = new Customer("Alice", 30);
		customerCopy = new Customer(customer); // Using the copy constructor
	}

	@Test
	public void testConstructor() {
		assertEquals("Alice", customer.getName(), "The name should be 'Alice'.");
		assertEquals(30, customer.getAge(), "The age should be 30.");
	}

	@Test
	public void testCopyConstructor() {
		assertEquals(customer.getName(), customerCopy.getName(), "The copied customer name should be the same.");
		assertEquals(customer.getAge(), customerCopy.getAge(), "The copied customer age should be the same.");
	}

	@Test
	public void testSetName() {
		customer.setName("Bob");
		assertEquals("Bob", customer.getName(), "The name should be updated to 'Bob'.");
	}

	@Test
	public void testSetAge() {
		customer.setAge(35);
		assertEquals(35, customer.getAge(), "The age should be updated to 35.");
	}

	@Test
	public void testToString() {
		String expected = "Customer Name: Alice\nAge: 30\n";
		assertEquals(expected, customer.toString(), "The toString output should match the expected format.");
	}

	@Test
	public void testToStringAfterModification() {
		customer.setName("Charlie");
		customer.setAge(40);
		String expected = "Customer Name: Charlie\nAge: 40\n";
		assertEquals(expected, customer.toString(), "The toString output should match the expected format after modification.");
	}

}
