package com.myresources.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myresources.main.dao.MailService;
import com.myresources.main.dao.SODAOInterface;
import com.myresources.main.pojo.SOs;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("so")
public class SOController {

	@Autowired
	SODAOInterface soDAOInterface;
	
	@Autowired
	MailService mailService;
	
	@RequestMapping(value = "addSO", method = RequestMethod.POST)
	public void addso(@RequestBody SOs so) {
		soDAOInterface.addSO(so);
	}
	
	@RequestMapping(value = "getSOs", method = RequestMethod.GET)
	public List<SOs> getsos() {
		List<SOs> sos = soDAOInterface.getSOs();
		return sos;
	}
	
	@RequestMapping(value = "remSO", method = RequestMethod.POST)
	public boolean remso(@RequestBody int so_number) {
		boolean b = soDAOInterface.removeSO(so_number);
		return b;
	}
	
	@RequestMapping(value = "sendSO", method = RequestMethod.POST)
	public void sendSO(@RequestParam("sender_email") String sender_email, @RequestParam("so_number") int so_number, @RequestParam("receiver_email") String receiver_email, @RequestParam("product_name") String product_name, @RequestParam("product_qty") String product_qty, @RequestParam("unit_price") String unit_price, @RequestParam("total_price") int total_price, @RequestParam("customer_add") String customer_address) {
		mailService.sendSO(sender_email, so_number, product_name, receiver_email, product_name, product_qty, unit_price, total_price, customer_address);
	}
}
