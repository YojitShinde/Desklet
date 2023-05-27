package com.myresources.main.dao;

public interface MailService {

	public void sendPO(String sender_email, int po_number, String receiver_email, String product_name, String product_qty, String unit_price, int total_price);
	
	public void sendSO(String sender_email, int so_number, String name, String receiver_email, String product_name, String product_qty, String unit_price, int total_price, String customer_add);
	
	public void sendMRN(int po_number, String sender_email);
}
