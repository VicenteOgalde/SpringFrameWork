package cl.vicoga.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationUse2 {

	public static void main(String[] args) {
		
		
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//read class configuration
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(EmployeeConfig.class);
		
		Employee emp = context.getBean("salesman",Employee.class);
		Employee emp2 = context.getBean("salesman",Employee.class);
		
		System.out.println(emp);
		System.out.println(emp2);
		
		Employee emp3= context.getBean("financeDirector",Employee.class);
		
		System.out.println(emp3.getTask());
		System.out.println(emp3.getReport());
		
		context.close();
	}

}
