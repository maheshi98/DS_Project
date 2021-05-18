package com.example.Mango_Restaurant.Controller;

import com.example.Mango_Restaurant.Repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

@RestController
public class EmailController {

    @Autowired
    EmailRepository emailRepository;

    @RequestMapping(value = "/sendemail")
    public String send() throws AddressException, MessagingException, IOException {
        //sendEmail();
        emailRepository.sendEmail();
        return "Email sent successfully";
    }
}
