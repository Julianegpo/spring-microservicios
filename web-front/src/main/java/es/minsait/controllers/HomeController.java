package es.minsait.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/","/inicio"})
public class HomeController {

	@RequestMapping(method = RequestMethod.GET, value = "")
	public String inicio() {
		return "index";
	}
	
}
