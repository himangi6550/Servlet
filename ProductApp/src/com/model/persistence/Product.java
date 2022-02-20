package com.model.persistence;

import java.sql.Date;

public class Product{
	private int id;
	private String name;
	private double price;
	private int qty;
	private Date manfDate, inspectedDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Date getManfDate() {
		return manfDate;
	}
	public void setManfDate(Date manfDate) {
		this.manfDate = manfDate;
	}
	public Date getInspectedDate() {
		return inspectedDate;
	}
	public void setInspectedDate(Date inspectedDate) {
		this.inspectedDate = inspectedDate;
	}
	
	public Product(int id, String name, double price, int qty, Date manfDate, Date inspectedDate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.manfDate = manfDate;
		this.inspectedDate = inspectedDate;
	}
	public Product(String name, double price, int qty, Date manfDate, Date inspectedDate) {
		super();
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.manfDate = manfDate;
		this.inspectedDate = inspectedDate;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", qty=" + qty + ", manfDate=" + manfDate
				+ ", inspectedDate=" + inspectedDate + "]";
	}
	
	
	
}
