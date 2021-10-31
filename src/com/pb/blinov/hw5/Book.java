package com.pb.blinov.hw5;

public class Book {

    private final String title;
    private final int year;
    private final String author;

    public Book(String title, int year, String author){
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public String toString() {
        return title +" ("+author+" "+year+")";
    }

    public String getTitle() {
        return title;
    }
}
