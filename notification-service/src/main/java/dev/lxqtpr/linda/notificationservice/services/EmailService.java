package dev.lxqtpr.linda.notificationservice.services;

import dev.lxqtpr.linda.notificationservice.kafka.orders.ResponseProductDto;
import dev.lxqtpr.linda.notificationservice.models.EmailTemplates;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.context.Context;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import static dev.lxqtpr.linda.notificationservice.models.EmailTemplates.ORDER_CONFIRMATION;
import static dev.lxqtpr.linda.notificationservice.models.EmailTemplates.PAYMENT_CONFIRMATION;
import static java.nio.charset.StandardCharsets.*;

@Service
@RequiredArgsConstructor
@Slf4j

public class EmailService {
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Async
    public void sendPaymentEmail(
            String destinationEmail,
            String customerName,
            BigDecimal amount,
            String orderReference
    ) throws MessagingException {
        var message = mailSender.createMimeMessage();
        var messageHelper = new MimeMessageHelper(
                message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                UTF_8.name()
        );
        messageHelper.setFrom("lxqtpr@gmail.com");
        var templateName = PAYMENT_CONFIRMATION.getTemplate();

        var variables = new HashMap<String, Object>();
        variables.put("customerName", customerName);
        variables.put("amount", amount);
        variables.put("orderReference", orderReference);

        var context = new Context();
        context.setVariables(variables);
        messageHelper.setSubject(PAYMENT_CONFIRMATION.getSubject());

        sendMessage(destinationEmail, message, messageHelper, templateName, context);
    }

    @Async
    public void sendOrderConfirmationEmail(
            String destinationEmail,
            String customerName,
            BigDecimal amount,
            String orderReference,
            List<ResponseProductDto> products
    ) throws MessagingException {

        var mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, UTF_8.name());
        messageHelper.setFrom("lxqtpr@gmail.com");

        final String templateName = ORDER_CONFIRMATION.getTemplate();

        var variables = new HashMap<String, Object>();
        variables.put("customerName", customerName);
        variables.put("totalAmount", amount);
        variables.put("orderReference", orderReference);
        variables.put("products", products);

        Context context = new Context();
        context.setVariables(variables);
        messageHelper.setSubject(ORDER_CONFIRMATION.getSubject());

        sendMessage(destinationEmail, mimeMessage, messageHelper, templateName, context);

    }

    private void sendMessage(String destinationEmail, MimeMessage mimeMessage, MimeMessageHelper messageHelper, String templateName, Context context) {
        try {
            String htmlTemplate = templateEngine.process(templateName, context);
            messageHelper.setText(htmlTemplate, true);

            messageHelper.setTo(destinationEmail);
            mailSender.send(mimeMessage);
            log.info(String.format("INFO - Email successfully sent to %s with template %s ", destinationEmail, templateName));
        } catch (MessagingException e) {
            log.warn("WARNING - Cannot send Email to {} ", destinationEmail);
        }
    }
}
