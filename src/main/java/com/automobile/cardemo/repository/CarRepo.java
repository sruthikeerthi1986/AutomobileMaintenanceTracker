package com.automobile.cardemo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.automobile.cardemo.model.Car;
import com.automobile.cardemo.model.CarTypeEnum;
import com.automobile.cardemo.model.DieselCar;
import com.automobile.cardemo.model.ElectricCar;
import com.automobile.cardemo.model.GasCar;
import com.automobile.cardemo.util.Utility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class CarRepo {

	@Autowired
	Utility util;
	GsonBuilder builder;
	Gson gson;

	public CarRepo() {
		this.util = new Utility();
		this.builder = new GsonBuilder();
		this.gson = builder.create();
	}

	public String insertCarDetails(Car inputCar) throws Exception {
		try {
			List<Car> carList = new ArrayList<Car>();
			Car newCar;
			carList = util.readFromCSV();
			for (Car car : carList) {
				if (car.getVin().equals(inputCar.getVin())) {
					return "Insert Failed as a Car with provided VIN already exists.";
				}
			}
			if (inputCar.getCarType().equalsIgnoreCase(CarTypeEnum.DIESEL.getName())) {
				newCar = new DieselCar(inputCar);
			} else if (inputCar.getCarType().equalsIgnoreCase(CarTypeEnum.ELECTRIC.getName())) {
				newCar = new ElectricCar(inputCar);
			} else if (inputCar.getCarType().equalsIgnoreCase(CarTypeEnum.GAS.getName())) {
				newCar = new GasCar(inputCar);
			} else
				return "Insert Failed as Car Type not provided";
			util.writeToTxt(newCar);
			return "Success";
		} catch (Exception e) {
			return "Exception " + e.getMessage();
		}
	}
/*
	public int insertCarDetails(Car inputCar, Car newReturnCar) throws Exception {
		try {
			List<Car> carList = new ArrayList<Car>();
			Car newCar;
			carList = util.readFromCSV();
			for (Car car : carList) {
				if (car.getVin().equals(inputCar.getVin())) {
					return 2;
				}
			}
			if (inputCar.getCarType().equalsIgnoreCase(CarTypeEnum.DIESEL.getName())) {
				newCar = new DieselCar(inputCar);
			} else if (inputCar.getCarType().equalsIgnoreCase(CarTypeEnum.ELECTRIC.getName())) {
				newCar = new ElectricCar(inputCar);
			} else if (inputCar.getCarType().equalsIgnoreCase(CarTypeEnum.GAS.getName())) {
				newCar = new GasCar(inputCar);
			} else {
				newReturnCar = null;
			    return 1;
			}
			newReturnCar = newCar;
			util.writeToTxt(newCar);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
*/
	public String getAllCarDetails() throws Exception {
		try {
			return gson.toJson(util.readFromCSV());
		} catch (Exception e) {
			return "getAllCarDetails failed with Exception";
		}
	}

	public String getCarDetailsByVin(String vin) throws Exception {
		try {
			List<Car> carList = new ArrayList<Car>();
			if (vin != null) {
				carList = util.readFromCSV();
				for (Car car : carList) {
					if (car.getVin().equals(vin)) {
						return gson.toJson(car);
					}
				}
			}
			return "getCarDetailsByVin- No record found for given VIN";
		} catch (Exception e) {
			return "getCarDetailsByVin- failed with Exception";
		}
	}

	public String getCarMaintenanceDetailsByVin(String vin) throws Exception {
		try {
			List<Car> carList = new ArrayList<Car>();
			if (vin != null) {
				carList = util.readFromCSV();
				for (Car car : carList) {
					if (car.getCarType().equalsIgnoreCase(CarTypeEnum.DIESEL.getName())) {
						DieselCar tempCar = new DieselCar(car);
						if (tempCar.getVin().equals(vin)) {
							return gson.toJson(tempCar.getMaintenanceTasksList());
						}
					} else if (car.getCarType().equalsIgnoreCase(CarTypeEnum.ELECTRIC.getName())) {
						ElectricCar tempCar = new ElectricCar(car);
						if (tempCar.getVin().equals(vin)) {
							return gson.toJson(tempCar.getMaintenanceTasksList());
						}
					} else if (car.getCarType().equalsIgnoreCase(CarTypeEnum.GAS.getName())) {
						GasCar tempCar = new GasCar(car);

						if (tempCar.getVin().equals(vin)) {
							return gson.toJson(tempCar.getMaintenanceTasksList());
						}
					}
				}
			}
			return "getCarMaintenanceDetailsByVin - No record found for given VIN";
		} catch (Exception e) {
			return "getCarMaintenanceDetailsByVin - failed with Exception";
		}
	}

	public String updateCarDetails(Car inputCar) throws Exception {
		try {
			List<Car> list = new ArrayList<Car>();
			list = util.readFromCSV();
			for (Car car : list) {
				if (car.getVin().equals(inputCar.getVin())) {
					car.copyCarDetails(inputCar);
					util.OverwriteToTxt(list);
					return gson.toJson(car);
				}
			}
			return "updateCarDetails failed - No record found for given VIN";
		} catch (Exception e) {
			return "updateCarDetails failed with Exception";
		}
	}

	public String deleteCarDetailsByVin(String vin) throws Exception {
		try {
			List<Car> list = new ArrayList<Car>();
			list = util.readFromCSV();
			for (Car car : list) {
				if (car.getVin().equals(vin)) {
					list.remove(car);
					util.OverwriteToTxt(list);
					return "Success";
				}
			}
			return "deleteCarDetailsByVin failed - No record found for given VIN";
		} catch (Exception e) {
			return "deleteCarDetailsByVin failed with Exception";
		}
	}
	
	public void clearRepo() throws Exception {
		try {
			util.clearFile();
		} catch (Exception e) {
		}
	}

}
