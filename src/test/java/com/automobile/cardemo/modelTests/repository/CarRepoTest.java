package com.automobile.cardemo.modelTests.repository;

import static org.testng.Assert.assertEquals;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automobile.cardemo.model.Car;
import com.automobile.cardemo.repository.CarRepo;
import com.automobile.cardemo.util.Utility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CarRepoTest {
	public CarRepo repo;

	@Autowired
	Utility util;
	GsonBuilder builder;
	Gson gson;

	public CarRepoTest() throws Exception {
		this.repo = new CarRepo();
		this.repo.clearRepo();

		this.util = new Utility();
		this.builder = new GsonBuilder();
		this.gson = builder.create();
	}

	@BeforeMethod
	public void beforeTest() throws Exception {
		this.repo.clearRepo();
	}

	@Test
	public void testInsertCarDetails() throws Exception {
		Car dieselCar = new Car("Car1", "Honda", "CRV", 2010, 10000, "Red", "diesel");
		Car electricCar = new Car("Car2", "Honda", "Accord", 2011, 10000, "Blue", "Electric");
		Car gasCar = new Car("Car3", "Honda", "CRV", 2012, 10000, "Green", "Gas");

		// Add Diesel Car
		assertEquals(repo.insertCarDetails(dieselCar), "Success");
		// Check if Diesel Car is really added
		String deiselCarRecord = repo.getCarDetailsByVin("Car1");
		String expectedDieselCarRecord = gson.toJson(dieselCar);
		assertEquals(deiselCarRecord, expectedDieselCarRecord);

		// Add Electric Car
		assertEquals(repo.insertCarDetails(electricCar), "Success");
		// Check if Electric Car is really added
		String electricCarRecord = repo.getCarDetailsByVin("Car2");
		String expectedElectricCarRecord = gson.toJson(electricCar);
		assertEquals(electricCarRecord, expectedElectricCarRecord);

		// Add Gas Car
		assertEquals(repo.insertCarDetails(gasCar), "Success");
		// Check if Gas Car is really added
		String gasCarRecord = repo.getCarDetailsByVin("Car3");
		String expectedGasCarRecord = gson.toJson(gasCar);
		assertEquals(gasCarRecord, expectedGasCarRecord);

		// Add a car with an existing VIN
		assertEquals(repo.insertCarDetails(gasCar), "Insert Failed as a Car with provided VIN already exists.");
	}

	@Test
	public void testGetAllCarDetails() throws Exception {
		Car dieselCar = new Car("Car1", "Honda", "CRV", 2010, 10000, "Red", "diesel");
		Car electricCar = new Car("Car2", "Honda", "Accord", 2011, 10000, "Blue", "Electric");
		Car gasCar = new Car("Car3", "Honda", "CRV", 2012, 10000, "Green", "Gas");

		repo.insertCarDetails(dieselCar);
		repo.insertCarDetails(electricCar);
		repo.insertCarDetails(gasCar);

		String expectedOutput = "[{\"vin\":\"Car1\",\"model\":\"CRV\",\"year\":2010,\"odometerReading\":10000,\"color\":\"Red\",\"make\":\"Honda\",\"carType\":\"diesel\"},{\"vin\":\"Car2\",\"model\":\"Accord\",\"year\":2011,\"odometerReading\":10000,\"color\":\"Blue\",\"make\":\"Honda\",\"carType\":\"Electric\"},{\"vin\":\"Car3\",\"model\":\"CRV\",\"year\":2012,\"odometerReading\":10000,\"color\":\"Green\",\"make\":\"Honda\",\"carType\":\"Gas\"}]";
		String combinedRecords = repo.getAllCarDetails();
		assertEquals(combinedRecords, expectedOutput);
	}

	@Test
	public void testGetCarDetailsByVin() throws Exception {
		Car car = new Car("Car1", "Honda", "CRV", 2010, 10000, "Red", "diesel");

		repo.insertCarDetails(car);
		String carRecord = repo.getCarDetailsByVin("Car1");
		String expectedCarRecord = gson.toJson(car);
		assertEquals(carRecord, expectedCarRecord);

		String carRecord2 = repo.getCarDetailsByVin("Car2");
		assertEquals(carRecord2, "getCarDetailsByVin- No record found for given VIN");

		String carRecord3 = repo.getCarDetailsByVin(null);
		assertEquals(carRecord3, "getCarDetailsByVin- No record found for given VIN");
	}

	@Test
	public void testGetCarMaintenanceDetailsByVin() throws Exception {
		Car dieselCar = new Car("Car1", "Honda", "CRV", 2010, 10000, "Red", "diesel");
		Car electricCar = new Car("Car2", "Honda", "Accord", 2011, 10000, "Blue", "Electric");
		Car gasCar = new Car("Car3", "Honda", "CRV", 2012, 10000, "Green", "Gas");

		repo.insertCarDetails(dieselCar);
		repo.insertCarDetails(electricCar);
		repo.insertCarDetails(gasCar);

		String carRecord1 = repo.getCarMaintenanceDetailsByVin("Car1");
		assertEquals(carRecord1, "[\"Tire Rotation\",\"Car Wash\",\"Oil Change\"]");

		String carRecord2 = repo.getCarMaintenanceDetailsByVin("Car2");
		assertEquals(carRecord2, "[\"Battery Charger Check\",\"Tire Rotation\",\"Car Wash\"]");

		String carRecord3 = repo.getCarMaintenanceDetailsByVin("Car3");
		assertEquals(carRecord3, "[\"Tire Rotation\",\"Car Wash\",\"Oil Change\"]");

		String carRecord4 = repo.getCarMaintenanceDetailsByVin("Car4");
		assertEquals(carRecord4, "getCarMaintenanceDetailsByVin - No record found for given VIN");

		String carRecord5 = repo.getCarMaintenanceDetailsByVin(null);
		assertEquals(carRecord5, "getCarMaintenanceDetailsByVin - No record found for given VIN");
	}

	@Test
	public void testUpdateCarDetails() throws Exception {
		// Test updates for given vin
		Car car = new Car("Car1", "Honda", "CRV", 2010, 10000, "Red", "diesel");
		repo.insertCarDetails(car);
		Car car1 = new Car("Car1", "Hyndai", "i20", 2010, 10000, "Black", "Gas");
		Car car2 = new Car("Car2", "Hyndai", "i20", 2010, 10000, "Black", "Gas");
		repo.updateCarDetails(car1);
		String carRecord = repo.getCarDetailsByVin("Car1");
		String expectedCarRecord = gson.toJson(car1);
		assertEquals(carRecord, expectedCarRecord);
		
		//Test updates for invalid vin
		String carRecord2 = repo.updateCarDetails(car2);
		String expectedCarRecord2 = "updateCarDetails failed - No record found for given VIN";
		assertEquals(carRecord2, expectedCarRecord2);
		
		//Test updates for null vin
		
		String carRecord3 = repo.updateCarDetails(null);
		String expectedCarRecord3 = "updateCarDetails failed with Exception";
		assertEquals(carRecord3, expectedCarRecord3);
	}
	
	@Test
	public void testDeleteCarDetailsByVin() throws Exception {
		//Test deletes for given vin
		Car car = new Car("Car1", "Honda", "CRV", 2010, 10000, "Red", "diesel");
		repo.insertCarDetails(car);
		String carRecord1 = repo.deleteCarDetailsByVin("Car1");
		String expectedCarRecord1 = "Success";
		assertEquals(carRecord1, expectedCarRecord1);
		
		//Test deletes for invalid vin
		String carRecord2 = repo.deleteCarDetailsByVin("Car1");
		String expectedCarRecord2 = "deleteCarDetailsByVin failed - No record found for given VIN";
		assertEquals(carRecord2, expectedCarRecord2);
		
		//Test deletes for invalid vin
		
		String carRecord3 = repo.deleteCarDetailsByVin(null);
		String expectedCarRecord3 = "deleteCarDetailsByVin failed - No record found for given VIN";
		assertEquals(carRecord3, expectedCarRecord3);
	}
		
		
}
