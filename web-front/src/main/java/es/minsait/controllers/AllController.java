package es.minsait.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.minsait.business.IManagementBS;
import es.minsait.models.Product;

@Controller
@RequestMapping("/showAll")
public class AllController {
	
	@Autowired
	private IManagementBS bs;

	@RequestMapping(method = RequestMethod.GET)
	public String getAllProducts(Model model) {
		List<Product> list = bs.getAll();
		model.addAttribute("productsList", list);
		return "showAll";
	}
	
}
