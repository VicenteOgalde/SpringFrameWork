package cl.vicoga.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoSingletonPrototype {

	public static void main(String[] args) {
		
		// load xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

		//petition of bean from the container of Spring
		
		EmployeeClerk emp=context.getBean("MeEmployeeClerk",EmployeeClerk.class);
		
		EmployeeClerk emp2=context.getBean("MeEmployeeClerk",EmployeeClerk.class);
		
		System.out.println(emp);
		System.out.println(emp2);
		
		System.out.println((emp.equals(emp2))?"same":"not the same");
	}

}
