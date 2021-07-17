package com.anirudhb2b.mail;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {
    private final MailConfig mailConfig;
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    private static final String HEADER = "TIMESHEET";
    private static final String SUBJECT = "Notification of timesheet";

    public void sendMessage(Mail mail) {
        try {
            Context context = new Context();
            Map<String, Object> variables = new HashMap<>();

            variables.put("header", HEADER);
            variables.put("fromDate", mail.getFromDate());
            variables.put("toDate", mail.getToDate());
            variables.put("env", mailConfig.getEnvironment());

            context.setVariables(variables);
            String process = templateEngine.process("mail-template", context);
            sendHtmlMessage(SUBJECT, process, mail);
        } catch (MessagingException messagingException) {
            log.error(String.format("Error sending email: %s",messagingException.getMessage()));
        }
    }

    private void sendHtmlMessage(String subject, String htmlBody, Mail mail) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(InternetAddress.parse(mail.getToEmail()));
        helper.setSubject(subject + " " + mailConfig.getEnvironment());
        helper.setText(htmlBody, true);
        helper.setFrom(mail.getFromEmail());
        mailSender.send(message);
    }

}
