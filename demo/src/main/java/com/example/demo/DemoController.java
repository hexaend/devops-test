package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DemoController {

    private final DemoServcie demoServcie;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return demoServcie.hello(name);
    }

    @PostMapping("/echo")
    public String echo(@RequestBody String message) {
        return demoServcie.echo(message);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        return demoServcie.delete(id);
    }



}
