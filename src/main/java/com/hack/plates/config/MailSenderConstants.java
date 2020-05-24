package com.hack.plates.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public interface MailSenderConstants {

    @Value("${sender.email}")
    String EMAIL = "";

    @Value("${sender.password}")
    String PASSWORD = "";

}
