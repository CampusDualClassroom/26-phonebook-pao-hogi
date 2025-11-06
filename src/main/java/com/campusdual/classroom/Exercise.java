package com.campusdual.classroom;

import java.util.Scanner;

public class Exercise {

    public static void main(String[] args) {

        Phonebook phonebook = new Phonebook();

        Contact c1 = new Contact("Santiago", "Fernández Rocha", "654321321");
        Contact c2 = new Contact("Esteban", "Serrano del Río", "654321322");

        phonebook.addContact(c1);
        phonebook.addContact(c2);

        System.out.println("=== Listado de contactos ===");
        phonebook.showPhonebook();
    }
}