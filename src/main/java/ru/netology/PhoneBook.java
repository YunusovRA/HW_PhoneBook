package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> contacts = new HashMap<>();
    private Map<String, String> reverseContacts = new HashMap<>();

    public int add(String name, String number) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, number);
            reverseContacts.put(number, name);
        }
        return contacts.size();
    }

    public String findByNumber(String number) {
        return reverseContacts.get(number);
    }

    public String findByName(String name) {
        return contacts.get(name);
    }

    public void printAllNames() {
        contacts.keySet().stream().sorted().forEach(System.out::println);
    }
}
