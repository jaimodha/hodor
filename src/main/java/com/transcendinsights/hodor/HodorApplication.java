package com.transcendinsights.hodor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableZuulProxy
public class HodorApplication {

    public static void main(String[] args) {
        SpringApplication.run(HodorApplication.class, args);
    }
}
