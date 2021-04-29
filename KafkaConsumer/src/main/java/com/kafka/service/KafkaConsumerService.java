package com.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.model.Employee;
import com.kafka.repository.EmployeeRepository;

@Service
public class KafkaConsumerService {

	@Autowired
	private EmployeeRepository repo;

	Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

	@KafkaListener(topics = "employee_data_v1", groupId = "employee_application", containerFactory = "employeeKafkaListenerContainerFactory")
	public void consume(Employee employee) {
		logger.info("consumer employee :{}", employee);
		if (employee.getIfProcessed().equals(false)) {
			employee.setEmailId(employee.geteName().concat("@gmail.com"));
			employee.setIfProcessed(true);
			repo.save(employee);
		}
	}

}
