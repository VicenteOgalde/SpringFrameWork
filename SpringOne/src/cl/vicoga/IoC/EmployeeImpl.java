package cl.vicoga.IoC;

public class EmployeeImpl {

	public static void main(String[] args) {
		
		Employee emp= new EmployeeClerk();
		
		System.out.println(emp.getTask());

	}

}
