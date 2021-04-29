package com.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kafka.fileservice.FileParsingService;

@SpringBootApplication
public class KafkaProjectApplication implements CommandLineRunner {

	@Autowired
	private FileParsingService fileParsingService;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		fileParsingService.parseCsvFile();
	}

}
