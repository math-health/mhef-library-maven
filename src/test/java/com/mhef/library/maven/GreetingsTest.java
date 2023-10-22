package com.mhef.library.maven;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Henrik Beck
 * @version v0.0.3
 */
class GreetingsTest {
    @Test
    void helloWorld() {
        assertEquals(Greetings.helloWorld(), "Hello, World!");
        assertNotEquals(Greetings.helloWorld(), "Hello, world!");
    }
}