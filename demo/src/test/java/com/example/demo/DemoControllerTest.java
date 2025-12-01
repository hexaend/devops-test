package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DemoController.class)
class DemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DemoServcie demoServcie;

    @Test
    void helloEndpointUsesService() throws Exception {
        given(demoServcie.hello("Bob")).willReturn("Hello, Bob!");

        mockMvc.perform(get("/api/hello").param("name", "Bob"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Bob!"));
    }

    @Test
    void helloEndpointUsesDefaultName() throws Exception {
        given(demoServcie.hello(anyString())).willReturn("Hello, World!");

        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));
    }

    @Test
    void echoEndpointReturnsBody() throws Exception {
        given(demoServcie.echo("hi")).willReturn("hi");

        mockMvc.perform(post("/api/echo").contentType(MediaType.TEXT_PLAIN).content("hi"))
                .andExpect(status().isOk())
                .andExpect(content().string("hi"));
    }

    @Test
    void deleteEndpointReturnsMessage() throws Exception {
        given(demoServcie.delete("42")).willReturn("Deleted item with id: 42");

        mockMvc.perform(delete("/api/delete/42"))
                .andExpect(status().isOk())
                .andExpect(content().string("Deleted item with id: 42"));
    }
}

