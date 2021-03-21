package com.automobile.cardemo.model;

public class GasCar extends Car {

	public GasCar() {
		// TODO Auto-generated constructor stub
	}
	public GasCar(Car inputcar) {
		this.setVin(inputcar.getVin());
		this.setModel(inputcar.getModel());
		this.setYear(inputcar.getYear());
		this.setOdometerReading(inputcar.getOdometerReading());
		this.setColor(inputcar.getColor());
		this.setCarType(CarTypeEnum.GAS.getName());
		this.setMake(inputcar.getMake());
	}
	
	@Override
	public String getCarType() {
		return CarTypeEnum.GAS.getName();
	}
	@Override
	public String[] getMaintenanceTasksList() {
		return new String[] {"Tire Rotation","Car Wash","Oil Change"};
	}
}
