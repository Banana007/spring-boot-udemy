package com.mycompany.springbootudemy.config;

import com.mycompany.springbootudemy.backend.service.EmailService;
import com.mycompany.springbootudemy.backend.service.MockEmailService;
import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/spring-boot-udemy/properties/application-dev.properties")
public class DevelomentConfig {

    @Bean
    public EmailService emailService(){
        return new MockEmailService();
    }

    @Bean
    public ServletRegistrationBean h2ConsoleServletRegistration() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new WebServlet());
        bean.addUrlMappings("/console/*");
        return bean;
    }

}
