/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automobile.cardemo.modelTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.automobile.cardemo.model.Car;
import com.automobile.cardemo.model.CarTypeEnum;
import com.automobile.cardemo.model.DieselCar;

public class DieselCarTest {

    @Test
    public void testGetMaintenanceTasksList() {
        Car car = new DieselCar();
        String[] expectedMaintenanceList = {"Tire Rotation","Car Wash","Oil Change"};
        String[] resultMaintenanceList = car.getMaintenanceTasksList();
        assertEquals(expectedMaintenanceList, resultMaintenanceList);
    }

    @Test
    public void testClassType() {
        Car car = new DieselCar();
        String expCarType = CarTypeEnum.DIESEL.getName();
        String actualCarType = car.getCarType();
        assertEquals(expCarType, actualCarType);
    }
    
}
