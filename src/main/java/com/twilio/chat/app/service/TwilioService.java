package com.twilio.chat.app.service;

import org.springframework.stereotype.Service;

@Service
public interface TwilioService {

    public void sendSms(String to, String from, String body);


    public void makeCall(String from, String to);

}
