package com.example.Mango_Restaurant.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;

public class EmailRepository {

    @Autowired
    private JavaMailSender javaMailSender;

    /* To send a normal email*/
    public void sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("dulyakemali@gmail.com");
        msg.setSubject("Letter to myself"); //TODO:
        msg.setText("Email content goes here"); //TODO:
        //msg.setText("Hello World \n Spring Boot Email \n your payement details are Rs 200000.00");
        javaMailSender.send(msg);
    }

    /* To send a email with an attachment*/
    public void sendEmailWithAttachment() throws MessagingException, IOException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("dulyakemali@gmail.com");
        helper.setSubject("Testing from Spring Boot");
        // default = text/plain
        //helper.setText("Check attachment for image!");
        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);
        // hard coded a file path
        FileSystemResource file = new FileSystemResource(new File("Give image path"));
        helper.addAttachment("ssl4.png", file);
        javaMailSender.send(msg);
    }
}
