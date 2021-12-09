package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldMatchesByName() {
        Book book1 = new Book(1, "Garry Potter", 150, "Rowling J.");
        Book book2 = new Book(2, "Fantastic Beasts", 180, "Rowling J.");
        assertTrue(book1.matches("Garry Potter"));
        assertFalse(book2.matches("Glow"));
    }

    @Test
    void shouldMatchesByAuthor() {
        Book book1 = new Book(1, "Garry Potter", 150, "Rowling J.");
        Book book2 = new Book(2, "Fantastic Beasts", 180, "Rowling J.");
        assertTrue(book1.matches("Rowling J."));
        assertTrue(book2.matches("Rowling J."));
    }

    @Test
    void shouldMatchesByNameNonExistent() {
        Book book1 = new Book(1, "Garry Potter", 150, "Rowling J.");
        Book book2 = new Book(2, "Fantastic Beasts", 180, "Rowling J.");
        assertFalse(book1.matches("Gabriel"));
        assertFalse(book2.matches("Friends"));
    }
}