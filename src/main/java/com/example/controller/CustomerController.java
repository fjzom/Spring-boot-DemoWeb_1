package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Customer;
import com.example.repository.ICustomerRepo;

@Controller
@RequestMapping(path = "")
public class CustomerController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private ICustomerRepo customerRepo;
	
	@PostMapping(path = "/addcustomer")
	@ResponseBody
	public void addCustomer(@RequestBody Customer customer){
		log.info("Add customer");
		customerRepo.save(customer);
	}
	@PutMapping(value = "/editcustomer")
	@ResponseBody
	public void editCustomer(@RequestBody Customer customer){
		log.info("Edit customer");
		customerRepo.save(customer);
	}
	@DeleteMapping(value = "/deletecustomer/${customerId}")
	@ResponseBody
	public void deleteCustomer(@PathVariable(name = "customerId") String customerId){
		log.info("Remove customer");
		customerRepo.deleteById(customerId);
	}
	@GetMapping("customers")
	public String getAllCustomers(Model model){
		log.info("Get All customers");
		model.addAttribute("customers", customerRepo.findAll());
		return "customers";
	}
	@GetMapping("data")
	@ResponseBody
	public List<Customer> data(Model model){
		log.info("Get All customers");		
		return customerRepo.findAll();
	}

}
