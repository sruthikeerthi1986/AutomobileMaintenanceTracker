package com.automobile.cardemo.model;

public enum CarTypeEnum {
	
	DIESEL("diesel"),
	GAS("Gas"),
	ELECTRIC("Electric");

	private String name;

	private CarTypeEnum(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
