package com.kafka.fileservice;

import java.io.File;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafka.model.Employee;
import com.kafka.service.KafkaProducerService;

@Service
public class FileParsingService {

	@Autowired
	KafkaProducerService kafkaProducerService;

	public void parseCsvFile() {
		String fileName = "employee.csv";
		File file = new File(fileName);
		try (Scanner inputStream = new Scanner(file)) {

			while (inputStream.hasNext()) {
				String data = inputStream.next();
				String[] str = data.split(",");
				if (!str[0].equals("\"e_id\"")) {
					Employee employee = new Employee();
					employee.seteId(Integer.parseInt(str[0]));
					employee.seteName(str[1]);
					employee.setEmailId(str[1]);
					employee.setIfProcessed(Boolean.parseBoolean(str[3]));
					kafkaProducerService.post(employee);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
