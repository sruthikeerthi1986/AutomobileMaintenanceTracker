package com.automobile.cardemo.model;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	private String vin;
	private String model;
	private int year;
	private int odometerReading;
	private String color;
	private String make;
	private String carType;
	
	public Car() {
		
	}
	
	public Car(String vin, String make, String model, int year, int odometerReading, String color, String carType) {
		this.vin = vin;
		this.model = model;
		this.year = year;
		this.odometerReading = odometerReading;
		this.color = color;
		this.make = make;
		this.carType = carType;
	}
	
	public void copyCarDetails(Car inputCar) {
		this.vin = inputCar.vin;
		this.model = inputCar.model;
		this.year = inputCar.year;
		this.odometerReading = inputCar.odometerReading;
		this.color = inputCar.color;
		this.make = inputCar.make;
		this.carType = inputCar.carType;
	}
	
	public boolean compareCar(Car inputCar) {
		if (inputCar == null) {
			return false;
		}
		if (this.vin.equalsIgnoreCase(inputCar.vin) && this.model.equalsIgnoreCase(inputCar.model)
				&& this.year == inputCar.year && this.odometerReading == inputCar.odometerReading
				&& this.color.equalsIgnoreCase(inputCar.color) && this.make.equalsIgnoreCase(inputCar.make)
				&& this.carType.equalsIgnoreCase(inputCar.carType)) {
			return true;
		}
		return false;
	}
	public String[] getMaintenanceTasksList() {
        return new String[]{"Car Wash", "Tire Rotation"};
    }
	
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getOdometerReading() {
		return odometerReading;
	}

	public void setOdometerReading(int odometerReading) {
		this.odometerReading = odometerReading;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	@Override
	public String toString() {
		return "Car[Vin=" + vin + " Model="+model + " Year=" + year + " OdometerReading=" + odometerReading + " Color=" + color + "Make=" + make + " CarType=" + carType+ "]";
	}

	
}
