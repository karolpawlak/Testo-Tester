package com.tanzu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@EntityScan({"com.tanzu.entity"})
@SpringBootApplication(scanBasePackages = "com.tanzu")
public class TestotesterWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestotesterWebApplication.class, args);
	}

}
