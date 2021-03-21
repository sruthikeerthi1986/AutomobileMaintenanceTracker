
package com.automobile.cardemo.modelTests;

import static org.junit.Assert.assertArrayEquals;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import com.automobile.cardemo.model.Car;
import com.automobile.cardemo.model.CarTypeEnum;
import com.automobile.cardemo.model.ElectricCar;

public class ElectricCarTest {

    @Test
    public void testGetMaintenanceTasksList() {
        Car car = new ElectricCar();
        String[] expectedMaintenanceList = {"Battery Charger Check", "Tire Rotation", "Car Wash"};
        String[] resultMaintenanceList = car.getMaintenanceTasksList();
        assertArrayEquals(expectedMaintenanceList, resultMaintenanceList);
    }

    @Test
    public void testClassType() {
        Car car = new ElectricCar();
        String expCarType = CarTypeEnum.ELECTRIC.getName();
        String actualCarType = car.getCarType();
        assertEquals(expCarType, actualCarType);
    }
}
