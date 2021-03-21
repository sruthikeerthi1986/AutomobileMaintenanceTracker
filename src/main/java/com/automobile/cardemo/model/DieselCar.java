package com.automobile.cardemo.model;

public class DieselCar extends Car{


	
	public DieselCar() {
		// TODO Auto-generated constructor stub
	}
	public DieselCar(Car inputcar) {
		this.setVin(inputcar.getVin());
		this.setModel(inputcar.getModel());
		this.setYear(inputcar.getYear());
		this.setOdometerReading(inputcar.getOdometerReading());
		this.setColor(inputcar.getColor());
		this.setCarType(CarTypeEnum.DIESEL.getName());
		this.setMake(inputcar.getMake());
	}
	@Override
	public String getCarType() {
		return CarTypeEnum.DIESEL.getName();
	}
	@Override
	public String[] getMaintenanceTasksList() {
		return new String[] {"Tire Rotation","Car Wash","Oil Change"};
	}
}
