package com.twilio.chat.app.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.conversations.v1.Conversation;
import com.twilio.twiml.voice.Say;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TwilioChatService implements TwilioService {

//    @Value("${app.twillio.accountSID}")
    private String ACCOUNT_SID = "my sid";

//    @Value("${app.twillio.authToken}")
    private String AUTH_TOKEN = "my token";
    @Override
    public void sendSms(String to, String from, String body) {
        //	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	/*
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        NewKey newKey = NewKey.creator().create();
	        System.out.println(newKey);
		*/
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Conversation conversation = Conversation.creator().setFriendlyName("Room 1").create();

        Conversation conversation2 = Conversation.fetcher(conversation.getSid()).fetch();
//		 Conversation.

        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(to),
                        new com.twilio.type.PhoneNumber(from),
                        body)
                .create();
        message.getSid();

//	    System.out.println(message.getSid());
        System.out.println(  UUID.randomUUID().toString());
        System.out.println(conversation2.toString());
    }

    @Override
    public void makeCall(String from, String to) {
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);

        Call call = Call.creator(
                new PhoneNumber(to),
                new PhoneNumber(from),
                        String.valueOf(new Say.Builder("Hello, this is a voice call from your Twilio account.").build()))
                    .create();

        System.out.println("Voice call SID: " + call.getSid());

    }


}
