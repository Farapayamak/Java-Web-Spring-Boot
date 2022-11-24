package com.example.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.farapayamak.services.SoapService;

@SpringBootApplication
@ComponentScan({ "com.farapayamak.services" })
public class Application implements CommandLineRunner {

	private SoapService soapService;

	public Application(SoapService soapService) {
		this.soapService = soapService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// SOAP
		System.out.println(soapService.GetCredit());
	}

}
