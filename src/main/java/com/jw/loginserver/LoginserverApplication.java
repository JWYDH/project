package com.jw.loginserver;

import com.jw.loginserver.controller.ListenServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoginserverApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(LoginserverApplication.class);

    @Autowired
    private ListenServer listenServer;

    public static void main(String[] args) {
        SpringApplication.run(LoginserverApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("登陆服务器启动...");
        listenServer.run(8080);
    }
}
