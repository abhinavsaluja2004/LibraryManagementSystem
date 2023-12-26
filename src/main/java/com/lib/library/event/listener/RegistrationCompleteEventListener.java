package com.lib.library.event.listener;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.lib.library.event.RegistrationCompleteEvent;
import com.lib.library.model.User;
import com.lib.library.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent>{

    private final UserService userService;

    private final JavaMailSender mailSender;

    private User theUser;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //1
        theUser = event.getUser();
        //2
        String verificationToken = UUID.randomUUID().toString();
        //3
        userService.saveUserVerificationToken(theUser, verificationToken);
        //4
        String url = event.getApplicationUrl() + "/register/verifyEmail?token=" + verificationToken;
        //5
        try {
            sendVerificationEmail(url);
        } catch (UnsupportedEncodingException | MessagingException e) {
            e.printStackTrace();
        }
        log.info("Click the link to verify your registration : {}" + url);
    }

    public void sendVerificationEmail(String url) throws UnsupportedEncodingException, MessagingException{
        String subject = "Email Verification";
        String senderName = "Mars library";
        String mailContent = "<p> Hi, "+ theUser.getUserName()+ ", </p>"+
                "<p>Thank you for registering with us,"+"" +
                "Please, follow the link below to complete your registration.</p>"+
                "<a href=\"" +url+ "\">Verify your email to activate your account</a>"+
                "<p> Thank you <br> Users Registration Portal Service";
        MimeMessage message = mailSender.createMimeMessage();
        var messageHelper = new MimeMessageHelper(message);
        messageHelper.setFrom("marslibrarymanagement@gmail.com", senderName);
        messageHelper.setTo(theUser.getUserMail());
        messageHelper.setSubject(subject);
        messageHelper.setText(mailContent, true);
        mailSender.send(message);
    }
    
}
