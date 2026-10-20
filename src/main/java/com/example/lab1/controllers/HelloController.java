package com.example.lab1.controllers;

import com.example.lab1.difexamples.ClientComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final ClientComponent clientComponent;
    private final ClientComponent anotherClientComponent;

    @Autowired
    public HelloController(ClientComponent clientComponent,
                           ClientComponent anotherClientComponent) {
        this.clientComponent = clientComponent;
        this.anotherClientComponent = anotherClientComponent;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot";
    }

    @GetMapping("/client")
    public String client() {
        return "Hello from ClientComponent = " + clientComponent;
    }

    @GetMapping("/compare")
    public String compare() {
        return "First ClientComponent = " + clientComponent
                + "\nSecond ClientComponent = " + anotherClientComponent
                + "\nSame instance = "
                + (clientComponent == anotherClientComponent);
    }
}