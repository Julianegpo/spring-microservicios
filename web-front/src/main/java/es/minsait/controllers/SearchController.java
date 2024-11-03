package es.minsait.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.minsait.business.IManagementBS;
import es.minsait.models.Product;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private IManagementBS bs;

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("product", new Product());
		return "searchForm";
	}
	
	@PostMapping
	public String submitForm(@ModelAttribute("product") Product product, Model model) {		
		try {
			Product foundProduct = bs.findProduct(product.getID());
			model.addAttribute("foundProduct", foundProduct);			
		} catch (Exception e) {
			model.addAttribute("msg", "Ese producto no existe en nuestro catalogo");
			return "showMessage";
		}
		return "showProduct";
	}
	
}
