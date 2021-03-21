package com.automobile.cardemo.modelTests;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.Test;

import com.automobile.cardemo.model.Car;

public class CarTest {

    @Test
    public void testGetFunctions() {
        int year = 2010;
        int odometerReading = 10000;
        Car testCar = new Car("Car1", "Honda", "CRV", year, odometerReading, "Red", "diesel" );
        String maintenanceList[] = {"Car Wash", "Tire Rotation"};
        
        //VIN
        String expectedVin = "Car1";
        String actualVin = testCar.getVin();
        assertEquals(expectedVin, actualVin);

        //Make
        String expectedMake = "Honda";
        String actualMake = testCar.getMake();
        assertEquals(expectedMake, actualMake);

        //Model
        String expectedModel = "CRV";
        String actualModel = testCar.getModel();
        assertEquals(expectedModel, actualModel);

        //Year
        int expectedYear = year;
        int actualYear = testCar.getYear();
        assertEquals(expectedYear, actualYear);

        //Odometer Reading
        int expectedOdoReading= 10000;
        int actualOdoReading = testCar.getOdometerReading();
        assertEquals(expectedOdoReading, actualOdoReading);
        
        //Car Type
        String expectedCarType= "diesel";
        String actualCarType = testCar.getCarType();
        assertEquals(expectedCarType, actualCarType);
        
        assertEquals(maintenanceList, testCar.getMaintenanceTasksList());
    }

    @Test
    public void testSetFunctions() {
        int year = 2010;
        int odometerReading = 10000;
        Car expected = new Car("Car1", "Honda", "CRV", year, odometerReading, "Red", "diesel" );
        Car result = new Car();
        
        result.setVin("Car1");
        result.setColor("Red");
        result.setCarType("diesel");
        result.setMake("Honda");
        result.setModel("CRV");
        result.setYear(2010);
        result.setOdometerReading(10000);
        
        //assertEquals(expected.compareCar(result), true);
        String s1=expected.toString();
        String s2=result.toString();
        assertEquals(s1,s2);
    }
    
    

    @Test
    public void testcompareCar() {
    	int year = 2010;
        int odometerReading = 10000;
    	Car testCar1 = new Car("Car1", "Honda", "CRV", year, odometerReading, "Red", "diesel" );
    	Car testCar2 = new Car("Car1", "Honda", "CRV", year, odometerReading, "Red", "diesel" );
    	Car testCar3 = new Car("Car2", "Honda", "CRV", year, odometerReading, "Red", "diesel" );
    	
        // Test with same car values
        assertEquals(testCar1.compareCar(testCar2), true);
        
        // Test with different car values
        assertEquals(testCar1.compareCar(testCar3), false);

    }
}
