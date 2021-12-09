package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    void shouldMatchesByName() {
        Smartphone smartphone1 = new Smartphone(1, "Iphone", 56000, "Apple");
        Smartphone smartphone2 = new Smartphone(2, "Honor", 30000, "Huawei");
        assertTrue(smartphone1.matches("Iphone"));
        assertTrue(smartphone2.matches("Honor"));
    }

    @Test
    void shouldMatchesByManufacturer() {
        Smartphone smartphone1 = new Smartphone(1, "Iphone", 56000, "Apple");
        Smartphone smartphone2 = new Smartphone(2, "Honor", 30000, "Huawei");
        assertTrue(smartphone1.matches("Apple"));
        assertFalse(smartphone2.matches("Apple"));
    }

    @Test
    void shouldMatchesByManufacturerNonExistent() {
        Smartphone smartphone1 = new Smartphone(1, "Iphone", 56000, "Apple");
        Smartphone smartphone2 = new Smartphone(2, "Honor", 30000, "Huawei");
        assertFalse(smartphone1.matches("Samsung"));
        assertFalse(smartphone2.matches("Microsoft"));
    }

}