package cl.vicoga.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeImpl {

	public static void main(String[] args) {
		/*
		Employee emp= new EmployeeClerk();
		
		System.out.println(emp.getTask());
	*/
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeBoss empb=context.getBean("meEmployee",EmployeeBoss.class);
		System.out.println(empb.getTask());
		System.out.println(empb.getReport());
		System.out.println(empb.getNameCompany());
		System.out.println(empb.getEmail());
		System.out.println(".........................");
		
		EmployeeClerk emp=context.getBean("MeEmployeeClerk",EmployeeClerk.class);
		System.out.println(emp.getTask());
		System.out.println(emp.getReport());
		System.out.println(emp.getEmail());
		System.out.println(emp.getNameCompany());
		
		context.close();
	}

}
