package com.automobile.cardemo.model;

public class ElectricCar extends Car {

	public ElectricCar() {
		// TODO Auto-generated constructor stub
	}
	public ElectricCar(Car inputcar) {
		this.setVin(inputcar.getVin());
		this.setModel(inputcar.getModel());
		this.setYear(inputcar.getYear());
		this.setOdometerReading(inputcar.getOdometerReading());
		this.setColor(inputcar.getColor());
		this.setCarType(CarTypeEnum.ELECTRIC.getName());
		this.setMake(inputcar.getMake());
	}
	
	@Override
	public String getCarType(){
		return CarTypeEnum.ELECTRIC.getName();
	}
	@Override
	public String[] getMaintenanceTasksList() {
        return new String[]{"Battery Charger Check", "Tire Rotation", "Car Wash"};
    }
	
	
}
