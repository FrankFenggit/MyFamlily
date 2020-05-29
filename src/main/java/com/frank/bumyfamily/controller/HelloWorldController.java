package com.frank.bumyfamily.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloWorldController {
    private static final String template = "Hello, world! (%d times)";
    private final AtomicLong counter = new AtomicLong();

    private final static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @GetMapping("/")
    public String Hello() {
        logger.info("hello log test");
        return String.format(template, counter.incrementAndGet());
    }
}
