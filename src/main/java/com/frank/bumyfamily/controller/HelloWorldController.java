package com.frank.bumyfamily.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloWorldController {
    private static final String template = "Hello, world! (%d times)";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public String Hello() {
        return String.format(template, counter.incrementAndGet());
    }
}
