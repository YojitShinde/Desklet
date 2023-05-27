package com.myresources.main.dao;


import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.myresources.main.pojo.POs;

@Service("mailService")
public class MailServiceImplementation implements MailService{
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	POs po;
	
	@Autowired
	PODAOInterface poDAOInterface;

	@Override
	public void sendPO(String sender_email, int po_number, String receiver_email, String product_name, String product_qty, String unit_price, int total_price) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		try {

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

			mimeMessageHelper.setSubject("Purchase Order");
			mimeMessageHelper.setFrom(new InternetAddress(sender_email));
			mimeMessageHelper.setTo(receiver_email);
			mimeMessageHelper.setText("\nDear Sir/Ma'am,\nYou are requested to accept this purchase order for the below-mentioned items.\n\nQuantity: "+product_qty+"\nProduct: "+product_name+"\nUnit Price: "+unit_price+"\nTotal Price: "+total_price+"\n\nAddress: 13th & 14th Floor, Damji Shamji Business Galleria, Lal Bahadur Shastri Rd, next to Huma Mall, Kanjurmarg West, Mumbai, Maharashtra 400078.\nPayment: Immediately on receipt of the materials in good condition.\nPlease treat this as Purchase Order No."+po_number+" If you are unable to service this order, you need to inform us immediately at the contact no. 9594993607.");

			mailSender.send(mimeMessageHelper.getMimeMessage());

		} catch (MessagingException e) {
			e.printStackTrace();
		} 
		
	}

	@Override
	public void sendSO(String sender_email, int so_number, String name, String receiver_email, String product_name, String product_qty, String unit_price, int total_price, String customer_add) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		try {

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

			mimeMessageHelper.setSubject("Sales Order");
			mimeMessageHelper.setFrom(new InternetAddress(sender_email));
			mimeMessageHelper.setTo(receiver_email);
			mimeMessageHelper.setText("\nDear Sir/Ma'am,\nYour requested Purchase Order has been successfully accepted for the below-mentioned items.\n\nQuantity: "+product_qty+"\nProduct: "+product_name+"\nUnit Price: "+unit_price+"\nTotal Price: "+total_price+"\n\nAddress: "+customer_add+"\nPayment: Immediately on receipt of the materials in good condition.\nPlease treat this as Sales Order No."+so_number+" If you are unable to receive this order, you need to inform us immediately at the contact no. 9594993607.");

			mailSender.send(mimeMessageHelper.getMimeMessage());

		} catch (MessagingException e) {
			e.printStackTrace();
		} 
		
	}

	@Override
	public void sendMRN(int po_number, String sender_email) {
		po = poDAOInterface.getPO(po_number);
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		try {

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

			mimeMessageHelper.setSubject("Materials Received Note");
			mimeMessageHelper.setFrom(new InternetAddress(sender_email));
			mimeMessageHelper.setTo(po.getSupplier_email());
			mimeMessageHelper.setText("\nDear Sir/Ma'am,\nOur requested Purchase Order "+po.getPo_number()+" has been successfully delivered and received for the below-mentioned items.\n\nQuantity: "+po.getProduct_qty()+"\nProduct: "+po.getProduct()+"\nUnit Price: "+po.getUnit_price()+"\nTotal Price: "+po.getTotal_price()+"\n\nThank You For Your Service.");

			mailSender.send(mimeMessageHelper.getMimeMessage());

		} catch (MessagingException e) {
			e.printStackTrace();
		} 
	}

}
