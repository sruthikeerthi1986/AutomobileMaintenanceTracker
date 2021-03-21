package com.automobile.cardemo.modelTests.repository.controllertest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.automobile.cardemo.controller.CarController;
import com.automobile.cardemo.model.Car;

public class ControllerTest {

	CarController controller;
	
	public ControllerTest() throws Exception {
		controller = new CarController();
	}
	
	@Test
	public void testAllFunctions() throws Exception {
		Car dieselCar = new Car("Car1", "Honda", "CRV", 2010, 10000, "Red", "diesel");
		Car electricCar = new Car("Car2", "Honda", "Accord", 2011, 10000, "Blue", "Electric");
		Car gasCar = new Car("Car3", "Honda", "CRV", 2012, 10000, "Green", "Gas");

		controller.carRepo.clearRepo();
		controller.postCarDetails(dieselCar);
		controller.postCarDetails(electricCar);
		controller.postCarDetails(gasCar);
		
		String getAllCarDetailsOutput = controller.getAllCarDetails();
		String expectedAllCarDetailsOutput = "[{\"vin\":\"Car1\",\"model\":\"CRV\",\"year\":2010,\"odometerReading\":10000,\"color\":\"Red\",\"make\":\"Honda\",\"carType\":\"diesel\"},{\"vin\":\"Car2\",\"model\":\"Accord\",\"year\":2011,\"odometerReading\":10000,\"color\":\"Blue\",\"make\":\"Honda\",\"carType\":\"Electric\"},{\"vin\":\"Car3\",\"model\":\"CRV\",\"year\":2012,\"odometerReading\":10000,\"color\":\"Green\",\"make\":\"Honda\",\"carType\":\"Gas\"}]";
		assertEquals(getAllCarDetailsOutput, expectedAllCarDetailsOutput);
		
		String getCarDetailsByVinOutput = controller.getCarDetailsByVin("Car1");
		String expectedCarDetailsByVinOutput = "{\"vin\":\"Car1\",\"model\":\"CRV\",\"year\":2010,\"odometerReading\":10000,\"color\":\"Red\",\"make\":\"Honda\",\"carType\":\"diesel\"}";
		assertEquals(getCarDetailsByVinOutput, expectedCarDetailsByVinOutput);
		
		String getCarMaintenanceDetailsByVinOutput = controller.getCarMaintenanceDetailsByVin("Car1");
		String expectedCarMaintenanceDetailsByVinOutput = "[\"Tire Rotation\",\"Car Wash\",\"Oil Change\"]";
		assertEquals(getCarMaintenanceDetailsByVinOutput, expectedCarMaintenanceDetailsByVinOutput);
		
		Car gasCar2 = new Car("Car3", "Honda", "CRV", 2012, 10000, "Dark Green", "Gas");
		String getUpdateCarDetailsOutput = controller.updateCarDetails(gasCar2);
		String expectedUpdateCarDetailsOutput = "\"{\\\"vin\\\":\\\"Car3\\\",\\\"model\\\":\\\"CRV\\\",\\\"year\\\":2012,\\\"odometerReading\\\":10000,\\\"color\\\":\\\"Dark Green\\\",\\\"make\\\":\\\"Honda\\\",\\\"carType\\\":\\\"Gas\\\"}\"";
		assertEquals(getUpdateCarDetailsOutput, expectedUpdateCarDetailsOutput);
		
		String getDeleteCarDetailsOutput = controller.deleteCarDetailsByVin("Car3");
		String expectedDeleteCarDetailsOutput = "Success";
		assertEquals(getDeleteCarDetailsOutput, expectedDeleteCarDetailsOutput);
		getAllCarDetailsOutput = controller.getAllCarDetails();
		expectedAllCarDetailsOutput = "[{\"vin\":\"Car1\",\"model\":\"CRV\",\"year\":2010,\"odometerReading\":10000,\"color\":\"Red\",\"make\":\"Honda\",\"carType\":\"diesel\"},{\"vin\":\"Car2\",\"model\":\"Accord\",\"year\":2011,\"odometerReading\":10000,\"color\":\"Blue\",\"make\":\"Honda\",\"carType\":\"Electric\"}]";
		assertEquals(getAllCarDetailsOutput, expectedAllCarDetailsOutput);
		
		
    }
}
