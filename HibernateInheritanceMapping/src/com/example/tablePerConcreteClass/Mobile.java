package com.example.tablePerConcreteClass;

import javax.persistence.Entity;

@Entity(name = "Mobile2")
public class Mobile extends Product {

	private String model;
	private String color;
	
	
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Mobile(int pid, String pname, int price, String model, String color) {
		super(pid, pname, price);
		this.model = model;
		this.color = color;
	}
	
	
	@Override
	public String toString() {
		return "Mobile [model=" + model + ", color=" + color + "]";
	}


	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
