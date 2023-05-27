package com.myresources.main.pojo;

import org.springframework.stereotype.Component;

@Component
public class POs {
	
	private int po_number;
	private String payment_mode;
	private String supplier_name;
	private String supplier_city;
	private String supplier_email;
	private String supplier_phone;
	private String product;
	private String product_qty;
	private String unit_price;
	private String date;
	private int total_price;
	
	public POs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public POs(int po_number, String payment_mode, String supplier_name, String supplier_city, String supplier_email,
			String supplier_phone, String product, String product_qty, String unit_price, String date, int total_price) {
		super();
		this.po_number = po_number;
		this.payment_mode = payment_mode;
		this.supplier_name = supplier_name;
		this.supplier_city = supplier_city;
		this.supplier_email = supplier_email;
		this.supplier_phone = supplier_phone;
		this.product = product;
		this.product_qty = product_qty;
		this.unit_price = unit_price;
		this.date = date;
		this.total_price = total_price;
	}

	public int getPo_number() {
		return po_number;
	}

	public void setPo_number(int po_number) {
		this.po_number = po_number;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getSupplier_city() {
		return supplier_city;
	}

	public void setSupplier_city(String supplier_city) {
		this.supplier_city = supplier_city;
	}

	public String getSupplier_email() {
		return supplier_email;
	}

	public void setSupplier_email(String supplier_email) {
		this.supplier_email = supplier_email;
	}

	public String getSupplier_phone() {
		return supplier_phone;
	}

	public void setSupplier_phone(String supplier_phone) {
		this.supplier_phone = supplier_phone;
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

	public String getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(String unit_price) {
		this.unit_price = unit_price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	@Override
	public String toString() {
		return "POs [po_number=" + po_number + ", payment_mode=" + payment_mode + ", supplier_name=" + supplier_name
				+ ", supplier_city=" + supplier_city + ", supplier_email=" + supplier_email + ", supplier_phone="
				+ supplier_phone + ", product=" + product + ", product_qty=" + product_qty + ", unit_price="
				+ unit_price + ", date=" + date + ", total_price=" + total_price + "]";
	}
	
}
