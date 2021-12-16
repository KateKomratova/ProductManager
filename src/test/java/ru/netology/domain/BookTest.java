package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldMatchesByName() {
        Book book1 = new Book(1, "Garry Potter", 150, "Rowling J.");
        assertTrue(book1.matches("Garry Potter"));
    }

    @Test
    void shouldMatchesByAuthor() {
        Book book1 = new Book(1, "Garry Potter", 150, "Rowling J.");
        assertTrue(book1.matches("Rowling J."));
    }

    @Test
    void shouldMatchesByNameNonExistent() {
        Book book2 = new Book(2, "Fantastic Beasts", 180, "Rowling J.");
        assertFalse(book2.matches("Friends"));
    }
}