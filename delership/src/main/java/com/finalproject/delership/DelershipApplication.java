package com.finalproject.delership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.finalproject.*")
@EnableJpaAuditing
@EnableTransactionManagement
@EnableFeignClients
public class DelershipApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelershipApplication.class, args);
	}

}
