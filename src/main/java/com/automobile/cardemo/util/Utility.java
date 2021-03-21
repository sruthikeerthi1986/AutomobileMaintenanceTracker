package com.automobile.cardemo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.automobile.cardemo.model.Car;
@Component
public class Utility {

	private static final String outputFile = "src/main/resources/CarList.csv";

	public void clearFile() throws IOException {
		FileWriter fw = new FileWriter(new File(outputFile));
		fw.append("");
		fw.flush();
		fw.close();
	}
	public void writeToTxt(Car car) throws Exception {
		try {
			FileWriter fw = new FileWriter(new File(outputFile),true);
			fw.append(car.getVin());
			fw.append(",");
			fw.append(car.getModel());
			fw.append(",");
			fw.append(car.getYear() + "");
			fw.append(",");
			fw.append(car.getOdometerReading() + "");
			fw.append(",");
			fw.append(car.getColor());
			fw.append(",");
			fw.append(car.getMake());
			fw.append(",");
			fw.append(car.getCarType());
			fw.append("\n");
			fw.flush();
			fw.close();
			System.out.println("File written at " + outputFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<Car> readFromCSV() throws Exception {
		System.out.println("Input file being read from " + outputFile);
		List<Car> list = new ArrayList<Car>();
		try {
			String[] strArray = null;
			BufferedReader br = new BufferedReader(new FileReader(outputFile));
			String line = br.readLine();
			Car car;
			while (line != null) {
					strArray = line.split(",");
					car = new Car();
					car.setVin(strArray[0]);
					car.setModel(strArray[1]);
					car.setYear(Integer.parseInt(strArray[2]));
					car.setOdometerReading(Integer.parseInt(strArray[3]));
					car.setColor(strArray[4]);
					car.setMake(strArray[5]);
					car.setCarType(strArray[6]);
					list.add(car);
					line = br.readLine();
			}
			
			br.close();
		} catch (IOException io) {
			io.printStackTrace();
		}
		System.out.println("Read from O/p file");
		return list;
	}
	public void OverwriteToTxt(List<Car> carList) {
		try {
			FileWriter fw = new FileWriter(new File(outputFile));
			for(Car car: carList) {
			fw.append(car.getVin());
			fw.append(",");
			fw.append(car.getModel());
			fw.append(",");
			fw.append(car.getYear() + "");
			fw.append(",");
			fw.append(car.getOdometerReading() + "");
			fw.append(",");
			fw.append(car.getColor());
			fw.append(",");
			fw.append(car.getMake());
			fw.append(",");
			fw.append(car.getCarType());
			fw.append("\n");
			}
			fw.flush();
			fw.close();
			System.out.println("File written at " + outputFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
