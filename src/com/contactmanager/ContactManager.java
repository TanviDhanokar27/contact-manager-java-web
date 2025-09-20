package com.contactmanager;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    private ArrayList<Contact> contacts;
    private Scanner scanner;

    public ContactManager() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Add a new contact
    public void addContact() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        System.out.println("Contact added successfully!\n");
    }

    // View all contacts
    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.\n");
            return;
        }

        System.out.println("All Contacts:");
        for (Contact c : contacts) {
            c.displayContact();
        }
    }

    // Search contact by name
    public void searchContact() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact found:");
                c.displayContact();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No contact found with name: " + name + "\n");
        }
    }

    // Delete contact by name
    public void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();
        boolean removed = contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));

        if (removed) {
            System.out.println("Contact deleted successfully!\n");
        } else {
            System.out.println("No contact found with name: " + name + "\n");
        }
    }

    // Main menu
    public void menu() {
        int choice;
        do {
            System.out.println("===== Contact Manager =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> searchContact();
                case 4 -> deleteContact();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Try again.\n");
            }
        } while (choice != 5);
    }

    public static void main(String[] args) {
        ContactManager cm = new ContactManager();
        cm.menu();
    }
}
