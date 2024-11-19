package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> contacts = new HashMap<>();

    public int add(String name, String number) {
        contacts.putIfAbsent(name, number);
        return contacts.size();
    }
}
