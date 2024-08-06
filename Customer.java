/*
* Class: CMSC203
* Instructor: Grigory Grinberg
* Description: The customer class sets default data for customer and provides getters and setters.  
* Due: 08/05/2024
* Platform/compiler: Eclipse IDE
* I pledge that I have completed the programming
Deliverables
* assignment independently. I have not copied the code
* from a student or any source. I have not given my code
* to any student.
Print your Name here: Isabel Saffell
*/

public class Customer {
	private String name;
	private int age;

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Customer(Customer c) {
		if (c != null) {
			this.name = c.name;
			this.age = c.age;
		}
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer Name: " + name + "\n" +
				"Age: " + age + "\n";
	}

}
