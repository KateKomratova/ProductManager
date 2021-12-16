package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    void shouldMatchesByName() {
        Smartphone smartphone1 = new Smartphone(1, "Iphone", 56000, "Apple");
        assertTrue(smartphone1.matches("Iphone"));
    }

    @Test
    void shouldMatchesByManufacturer() {
        Smartphone smartphone1 = new Smartphone(1, "Iphone", 56000, "Apple");
        assertTrue(smartphone1.matches("Apple"));
    }

    @Test
    void shouldMatchesByManufacturerNonExistent() {
        Smartphone smartphone1 = new Smartphone(1, "Iphone", 56000, "Apple");
        assertFalse(smartphone1.matches("Microsoft"));
    }

}