package com.example.Mango_Restaurant.Repository;

import com.example.Mango_Restaurant.Model.Sms;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

@Component
public class SmsRepository {

    /** Don't change these */
    private final String ACCOUNT_SID ="AC5075bcf1713c46491b558de8a541752d";
    private final String AUTH_TOKEN = "0b99d0f480289af6a8341d281ab86bc8";
    private final String FROM_NUMBER = "+17208097559";

    private final String TO_NUMBER = "+94763660208";
    private final String MESSAGE = "Sending message goes here.....";

    public void send(Sms sms){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage()).create();
        //Message hard_coded_message = Message.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER), MESSAGE).create();
        System.out.println("Message sent and message id is " + message.getSid());// Unique resource ID created to manage this transaction
    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }
}
