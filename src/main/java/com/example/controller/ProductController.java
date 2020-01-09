package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Product;
import com.example.repository.IProductRepo;

@Controller
@RequestMapping("")
public class ProductController {
	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
		
	@Autowired
	private IProductRepo productRepo;
	
	@RequestMapping(value="addproduct", method  = RequestMethod.POST)
	@ResponseBody
	public void addProduct(@RequestParam("name") String name, @RequestParam("price") Double price ,@RequestParam("offerType") String offerType){
		log.info("Add product");
		Product p =  new Product();
		p.setName(name);
		p.setPrice(price);
		p.setOfferType(offerType);
		productRepo.save(p);
	}
	
	@RequestMapping(value="products", method = RequestMethod.GET)
	public String getAllProducts(Model model) {
		log.info("Get All products");
		model.addAttribute("products", productRepo.findAll());
		return "products";
	}
}
