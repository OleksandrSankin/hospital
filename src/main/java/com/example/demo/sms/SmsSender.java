package com.example.demo.sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsSender {

    private static Logger logger = LoggerFactory.getLogger(SmsSender.class);

    @Value("${sms.phone.from:}")
    private String phoneFrom;

    @Value("${sms.phone.to:}")
    private String phoneTo;

    @Value("${sms.sid:}")
    private String accountSid;

    @Value("${sms.token:}")
    private String authToken;

    public void sendSms(String smsText) {
        //Twilio.init(accountSid, authToken);
        //Message.creator(new PhoneNumber(phoneTo), new PhoneNumber(phoneFrom), smsText).create();

        logger.info("Смс было отправлено: {}.", smsText);
    }
}
