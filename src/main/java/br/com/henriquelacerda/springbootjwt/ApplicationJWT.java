package br.com.henriquelacerda.springbootjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ApplicationJWT {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationJWT.class, args);
    }

}
