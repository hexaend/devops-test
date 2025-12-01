package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoServcieTest {

    private final DemoServcie service = new DemoServcie();

    @Test
    void helloReturnsGreeting() {
        assertEquals("Hello, Alice!", service.hello("Alice"));
    }

    @Test
    void echoReturnsSameMessage() {
        assertEquals("message", service.echo("message"));
        assertEquals("", service.echo(""));
        assertNull(service.echo(null));
    }

    @Test
    void deleteReturnsFormattedString() {
        assertEquals("Deleted item with id: 123", service.delete("123"));
    }
}

