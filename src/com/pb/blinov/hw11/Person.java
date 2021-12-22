package com.pb.blinov.hw11;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;

public class Person {

    private String name;
    private HashSet<String> phones = new HashSet<>();
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    private String address;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime editTime;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.editTime = LocalDateTime.now();
    }

    public HashSet getPhones() {
        return phones;
    }

    public void addPhone(String phone) {
        this.phones.add(phone);
        this.editTime = LocalDateTime.now();
    }

    public void setPhones(HashSet<String> phones) {
        this.phones = phones;
        this.editTime = LocalDateTime.now();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.editTime = LocalDateTime.now();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.editTime = LocalDateTime.now();
    }

    public Person(String name, String phone, LocalDate dateOfBirth, String address) {
        this.name = name;
        this.phones.add(phone);
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.editTime = LocalDateTime.now();
    }

    public Person(String name, String[] phones, LocalDate dateOfBirth, String address) {
        this.name = name;
        this.phones = new HashSet<>(Arrays.asList(phones));
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.editTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", phones=" + phones +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", editTime=" + editTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                '}';
    }
}
