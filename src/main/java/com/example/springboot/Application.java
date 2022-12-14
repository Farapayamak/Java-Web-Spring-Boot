package com.example.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.farapayamak.services.RestService;
import com.farapayamak.services.SoapService;
import com.farapayamak.services.models.*;

@SpringBootApplication
@ComponentScan({ "com.farapayamak.services" })
public class Application implements CommandLineRunner {

	private SoapService soapService;
	private RestService restService;

	public Application(SoapService soapService, RestService restService) {
		this.soapService = soapService;
		this.restService = restService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// SOAP
		// System.out.println(soapService.GetCredit());
		// System.out.println(soapService.GetDeliveries(new String[]{"123456", "654123"}));
		
		// GetSmsPriceModel model = new GetSmsPriceModel();
		// model.mtnCount = 1;
		// model.irancellCount = 2;
		// model.from = "5000xxx";
		// model.text = "Sample text goes here!";
		// System.out.println(soapService.GetSmsPrice(model));

		// var model = new SendByBaseNumberModel();
		// model.bodyId = 8852;
		// model.text = new String[] {"AAA", "BBB"};
		// model.to = "09123456789";
		// System.out.println(soapService.SendByBaseNumber(model));

		var model = new SendSimpleSMS2Model();
		model.from = "5000xxx";
		model.text = "Hi there!";
		model.to = "09123456789";
		model.isflash = false;
		System.out.println(soapService.SendSimpleSMS2(model));

		// REST
		// var sendResult = restService.SendSMS("09123456789","5000xxx", "hi there!", false);
		// System.out.println(sendResult.RetStatus);
		// System.out.println(sendResult.StrRetStatus);

	}

}
