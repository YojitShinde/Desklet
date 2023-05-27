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
import com.myresources.main.dao.PODAOInterface;
import com.myresources.main.pojo.POs;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("po")
public class POController {

	@Autowired
	PODAOInterface poDAOInterface;
	
	@Autowired
	MailService mailService;
	
	@RequestMapping(value = "addPO", method = RequestMethod.POST)
	public void addpo(@RequestBody POs po) {
		poDAOInterface.addPO(po);
	}
	
	@RequestMapping(value = "getPOs", method = RequestMethod.GET)
	public List<POs> getpos() {
		List<POs> pos = poDAOInterface.getPOs();
		return pos;
	}
	
	@RequestMapping(value = "remPO", method = RequestMethod.POST)
	public boolean rempo(@RequestBody int po_number) {
		boolean b = poDAOInterface.removePO(po_number);
		return b;
	}
	
	@RequestMapping(value = "sendPO", method = RequestMethod.POST)
	public void sendPO(@RequestParam("sender_email") String sender_email, @RequestParam("po_number") int po_number, @RequestParam("receiver_email") String receiver_email, @RequestParam("product_name") String product_name, @RequestParam("product_qty") String product_qty, @RequestParam("unit_price") String unit_price, @RequestParam("total_price") int total_price) {
		mailService.sendPO(sender_email, po_number, receiver_email, product_name, product_qty, unit_price, total_price);
	}
	
}
