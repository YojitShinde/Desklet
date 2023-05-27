package com.myresources.main.pojo;

import org.springframework.stereotype.Component;

@Component
public class MRNs {
	
	private int mrn_number;
	private int po_number;
	private String supplier_name;
	private String supplier_city;
	private String product;
	private String product_qty;
	
	public MRNs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MRNs(int mrn_number, int po_number, String supplier_name, String supplier_city, String product,
			String product_qty) {
		super();
		this.mrn_number = mrn_number;
		this.po_number = po_number;
		this.supplier_name = supplier_name;
		this.supplier_city = supplier_city;
		this.product = product;
		this.product_qty = product_qty;
	}

	public int getMrn_number() {
		return mrn_number;
	}

	public void setMrn_number(int mrn_number) {
		this.mrn_number = mrn_number;
	}

	public int getPo_number() {
		return po_number;
	}

	public void setPo_number(int po_number) {
		this.po_number = po_number;
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

	@Override
	public String toString() {
		return "MRNs [mrn_number=" + mrn_number + ", po_number=" + po_number + ", supplier_name=" + supplier_name
				+ ", supplier_city=" + supplier_city + ", product=" + product + ", product_qty=" + product_qty + "]";
	}
	
}
