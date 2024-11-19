package ru.netology;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {
    @Test
    public void testAdd() {
        PhoneBook phoneBook = new PhoneBook();
        assertEquals(1, phoneBook.add("Alice", "12345"));
        assertEquals(2, phoneBook.add("Bob", "67890"));
        assertEquals(2, phoneBook.add("Alice", "12345"));
    }

    @Test
    public void testFindByNumber() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "12345");
        phoneBook.add("Bob", "67890");
        assertEquals("Alice", phoneBook.findByNumber("12345"));
        assertEquals("Bob", phoneBook.findByNumber("67890"));
        assertNull(phoneBook.findByNumber("11111"));
    }

    @Test
    public void testFindByName() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "12345");
        phoneBook.add("Bob", "67890");
        assertEquals("12345", phoneBook.findByName("Alice"));
        assertEquals("67890", phoneBook.findByName("Bob"));
        assertNull(phoneBook.findByName("Charlie"));
    }

    @Test
    public void testPrintAllNames() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Charlie", "33333");
        phoneBook.add("Alice", "12345");
        phoneBook.add("Bob", "67890");

        // Capture the output and assert the order
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        phoneBook.printAllNames();

        String expectedOutput = "Alice\nBob\nCharlie\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
