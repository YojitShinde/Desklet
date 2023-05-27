package com.myresources.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myresources.main.dao.MRNDAOInterface;
import com.myresources.main.dao.MailService;
import com.myresources.main.pojo.MRNs;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("mrn")
public class MRNController {

	@Autowired
	MRNDAOInterface mrnDAOInterface;
	
	@Autowired
	MailService mailService;
	
	@RequestMapping(value = "addMRN", method = RequestMethod.POST)
	public void addmrn(@RequestBody MRNs mrn) {
		mrnDAOInterface.addMRN(mrn);
	}
	
	@RequestMapping(value = "getMRNs", method = RequestMethod.GET)
	public List<MRNs> getmrn() {
		List<MRNs> mrns = mrnDAOInterface.getMRNs();
		return mrns;
	}
	
	@RequestMapping(value = "remMRN", method = RequestMethod.POST)
	public boolean remmrn(@RequestBody int mrn_number) {
		boolean b = mrnDAOInterface.removeMRN(mrn_number);
		return b;
	}
	
	@RequestMapping(value = "sendMRN", method = RequestMethod.POST)
	public void sendMRN(@RequestParam("sender_email") String sender_email, @RequestParam("po_number") int po_number) {
		mailService.sendMRN(po_number, sender_email);
	}
}
