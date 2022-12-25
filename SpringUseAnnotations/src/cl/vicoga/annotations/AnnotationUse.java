package cl.vicoga.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationUse {

	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Employee emp = context.getBean("salesman",Employee.class);
		
		System.out.println(emp.getTask());
		System.out.println(emp.getReport());
		
		context.close();
	}

}
