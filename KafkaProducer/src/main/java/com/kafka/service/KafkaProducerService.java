package com.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.model.Employee;

@Service
public class KafkaProducerService {

	@Autowired
	private KafkaTemplate<String, Employee> kafkaTemplate;

	private static final String TOPIC = "employee_data_v1";

	public void post(Employee employee) {
		kafkaTemplate.send(TOPIC, employee);
	}

}
