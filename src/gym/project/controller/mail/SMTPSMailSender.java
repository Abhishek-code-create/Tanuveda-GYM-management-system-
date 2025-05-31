package gym.project.controller.mail;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.*;

import javax.mail.*;

import javax.mail.internet.*;

import javax.activation.*;

import javax.mail.*;

import javax.mail.internet.*;

import javax.activation.*;

public class SMTPSMailSender {

    private static final String host = "smtp.gmail.com";

    private static final String port = "587"; 

    private static final String email = "ENTER YOUR EMAIL";

    private static String password = "ENTER YOUR APP PASSWORD";



    // Send Email Method

    public static boolean sendMail(String recipient, String subject, String body) {

        // Set up properties for the email session

        Properties properties = new Properties();

        properties.setProperty("mail.smtp.host", host);

        properties.setProperty("mail.smtp.port", port);  

        properties.setProperty("mail.smtp.auth", "true");

        properties.setProperty("mail.smtp.starttls.enable", "true");  // Enable STARTTLS

        properties.put("mail.smtp.starttls.enable", "true");

        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");  // Forces TLSv1.2

        Session session = Session.getInstance(properties, new Authenticator() {Add commentMore actions

            @Override

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(email, password);

            }

        });



        try {

            // Create the messageAdd commentMore actions

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(email));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            message.setSubject(subject);

            message.setText(body);

            // Send the message

            Transport.send(message);

            System.out.println("Mail sent successfully!"+body);

            return true;

        } catch (MessagingException mex) {

            mex.printStackTrace();

            return false;

        }

    }

}


