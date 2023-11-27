package com.twilio.chat.app;

import com.twilio.chat.app.service.TwilioChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {



	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		TwilioChatService twilioChatService = new TwilioChatService();
		//twilioChatService.sendSms("+919629950320","+1736473837","hiBi");
		twilioChatService.makeCall("+1736473837","+919629950320");
	}

}
