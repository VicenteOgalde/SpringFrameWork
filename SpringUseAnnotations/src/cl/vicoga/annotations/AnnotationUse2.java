package cl.vicoga.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationUse2 {

	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Employee emp = context.getBean("salesman",Employee.class);
		Employee emp2 = context.getBean("salesman",Employee.class);
		
		System.out.println(emp);
		System.out.println(emp2);
		
		context.close();
	}

}
