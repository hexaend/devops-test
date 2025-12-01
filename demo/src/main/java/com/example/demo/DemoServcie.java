package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class DemoServcie {

    public String hello(String name) {
        return String.format("Hello, %s!", name);
    }


    public String echo(String message) {
        return message;
    }

    public String delete(String id) {
        return String.format("Deleted item with id: %s", id);
    }
}
