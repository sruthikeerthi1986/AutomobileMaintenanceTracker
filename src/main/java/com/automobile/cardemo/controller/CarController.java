package com.automobile.cardemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.automobile.cardemo.model.Car;
import com.automobile.cardemo.repository.CarRepo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class CarController {
	@Autowired
	public CarRepo carRepo;
	GsonBuilder builder;
	Gson gson;
	
	public CarController()
	{
		this.builder = new GsonBuilder(); 
	    this.gson = builder.create();
	    this.carRepo = new CarRepo();
	}
	
	@GetMapping(value="/getAllCarDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllCarDetails() throws Exception {
		return carRepo.getAllCarDetails();
    }
	
	@GetMapping(value="/getCarDetailsByVin", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getCarDetailsByVin(@RequestParam String vin) throws Exception {
		return carRepo.getCarDetailsByVin(vin);
	}
	
	@GetMapping(value="/getCarMaintenanceDetailsByVin", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getCarMaintenanceDetailsByVin(@RequestParam String vin) throws Exception {
		return carRepo.getCarMaintenanceDetailsByVin(vin);
	}
	
	@PostMapping(value="/insertCarDetails", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String postCarDetails(@RequestBody Car car) throws Exception {
		return this.gson.toJson(carRepo.insertCarDetails(car));
    }
	
	@PutMapping(value="/updateCarDetails", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateCarDetails(@RequestBody Car car) throws Exception {
	    return gson.toJson(carRepo.updateCarDetails(car)); 
	}
	
	
	@DeleteMapping(value="/deleteCarDetailsByVin", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteCarDetailsByVin(@RequestParam String vin) throws Exception {
		return carRepo.deleteCarDetailsByVin(vin);		
	}
}
