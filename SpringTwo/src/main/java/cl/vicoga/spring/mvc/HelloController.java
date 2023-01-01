package cl.vicoga.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@RequestMapping("/processForm2")
	public String otherProcess(HttpServletRequest request, Model model){
		
		String name= request.getParameter("meName");
		name+=" <<<<<>>>>";
		
		model.addAttribute("name", name);
		
		
		return "helloSpring";
		
		
	}
}
