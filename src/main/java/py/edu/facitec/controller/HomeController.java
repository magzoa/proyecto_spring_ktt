package py.edu.facitec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	@GetMapping("/")
	public String formulario() {
		
		System.out.println("Ingrese form login");
		return "usuario/login";
		
	}
	
	
	@GetMapping("/form")
	public String formSuscrito() {
		
		System.out.println("Ingrese form Suscrito");
		return "suscrito/form_rest";
		
	}
	
}
