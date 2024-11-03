package es.minsait.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.minsait.business.IManagementBS;
import es.minsait.models.ShoppingCart;

@Controller
@RequestMapping("/buy")
public class BuyController {

	@Autowired
	private IManagementBS bs;
	
	@PostMapping
	public String addToCart(long id, int quantity, HttpServletRequest request) {
		String user = null;
		boolean login = false;
		
		// Recuperar las cookies de la peticion y ver si tenemos el nombre del usuario
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("user".equals(cookie.getName())) {
				user = cookie.getValue();
				login = true;
			}
		}
		
		if (!login) {
			return "loginForm";
		}
		
		// proceso de compra
		bs.add(id,  quantity, user);
		ShoppingCart shoppingCart = bs.findShoppingCart(user);
		request.setAttribute("shoppingCart", shoppingCart);
		
		return "showCart";
	}
	
	@GetMapping(value="deleteItem")
	public String deleteItemFromCart(long id, HttpServletRequest request) {
		String user = null;
		
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("user".equals(cookie.getName())) {
				user = cookie.getValue();
			}
		}
		
		bs.delete(id, user);
		ShoppingCart shoppingCart = bs.findShoppingCart(user);
		request.setAttribute("shoppingCart", shoppingCart);
		
		return "showCart";
	}
	
}
