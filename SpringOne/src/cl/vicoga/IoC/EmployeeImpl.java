package cl.vicoga.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeImpl {

	public static void main(String[] args) {
		/*
		Employee emp= new EmployeeClerk();
		
		System.out.println(emp.getTask());
	*/
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee emp=context.getBean("meEmployee",Employee.class);
		System.out.println(emp.getTask());
		context.close();
	}

}
