package cl.vicoga.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloForm";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		
		return "helloSpring";
	}
}
