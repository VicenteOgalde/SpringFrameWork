package cl.vicoga.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycle {

	public static void main(String[] args) {
	
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
		EmployeeBoss emp=context.getBean("meEmployee",EmployeeBoss.class);
	
		
		System.out.println(emp.getReport());
		
		context.close();
	}

}
