package es.minsait.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.minsait.business.IManagementBS;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private IManagementBS bs;

	@PostMapping
	public String login(HttpServletRequest request, HttpServletResponse response) {
		String user = request.getParameter("user");
		Cookie cookie = new Cookie("user", user);
		response.addCookie(cookie);
		
		if (bs.findShoppingCart(user) == null) {
			// creamos el carrito
			bs.create(user);
		}
		
		return "index";
	}
	
}
