
package com.automobile.cardemo.modelTests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import com.automobile.cardemo.model.Car;
import com.automobile.cardemo.model.CarTypeEnum;
import com.automobile.cardemo.model.GasCar;

public class GasCarTest {

    @Test
    public void testGetMaintenanceTasksList() {
        Car car = new GasCar();
        String[] expectedMaintenanceList = {"Battery Charger Check", "Tire Rotation", "Car Wash"};
        String[] resultMaintenanceList = car.getMaintenanceTasksList();
        assertEquals(expectedMaintenanceList, resultMaintenanceList);
    }

    @Test
    public void testClassType() {
        Car car = new GasCar();
        String expCarType = CarTypeEnum.GAS.getName();
        String actualCarType = car.getCarType();
        assertEquals(expCarType, actualCarType);
    }
}
