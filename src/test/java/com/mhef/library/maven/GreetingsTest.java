package com.mhef.library.maven;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingsTest {

    @Test
    void helloWorld() {
        assertEquals(Greetings.helloWorld(), "Hello, World!");
        assertNotEquals(Greetings.helloWorld(), "Hello, world!");
    }
}