package com.contactmanager;

public class Contact {
    private String name;
    private String phone;
    private String email;

    // Constructor
    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Display contact info
    public void displayContact() {
        System.out.println("Name : " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("------------------------");
    }
}
