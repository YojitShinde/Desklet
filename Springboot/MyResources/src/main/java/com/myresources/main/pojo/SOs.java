package com.myresources.main.pojo;

import org.springframework.stereotype.Component;

@Component
public class SOs {

	private int so_number;
	private String customer_name;
	private String customer_address;
	private String customer_email;
	private String customer_phone;
	private String product;
	private String product_qty;
	private String date;
	private String unit_price;
	private int total_price;
	
	public SOs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SOs(int so_number, String customer_name, String customer_address, String customer_email,
			String customer_phone, String product, String product_qty, String date, String unit_price,
			int total_price) {
		super();
		this.so_number = so_number;
		this.customer_name = customer_name;
		this.customer_address = customer_address;
		this.customer_email = customer_email;
		this.customer_phone = customer_phone;
		this.product = product;
		this.product_qty = product_qty;
		this.date = date;
		this.unit_price = unit_price;
		this.total_price = total_price;
	}

	public int getSo_number() {
		return so_number;
	}

	public void setSo_number(int so_number) {
		this.so_number = so_number;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProduct_qty() {
		return product_qty;
	}

	public void setProduct_qty(String product_qty) {
		this.product_qty = product_qty;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(String unit_price) {
		this.unit_price = unit_price;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	@Override
	public String toString() {
		return "SOs [so_number=" + so_number + ", customer_name=" + customer_name + ", customer_address="
				+ customer_address + ", customer_email=" + customer_email + ", customer_phone=" + customer_phone
				+ ", product=" + product + ", product_qty=" + product_qty + ", date=" + date + ", unit_price="
				+ unit_price + ", total_price=" + total_price + "]";
	}
	
}
