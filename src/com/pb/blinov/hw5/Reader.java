package com.pb.blinov.hw5;

public class Reader {
    private final String name;
    private final String cardNumber;
    private final String faculty;
    private final String dob;
    private final String phoneNumber;

    public Reader(String name, String cardNumber, String faculty, String dob, String phoneNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.faculty = faculty;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        return name +"  "+ cardNumber +"  "+ faculty +"  "+ dob +"  "+ phoneNumber;
    }

    public void takeBook(int count){
        System.out.println(name + " взял " + count + " книги");
    }

    public void takeBook(String... titles){
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" взял книги: ");
        for (String title : titles){
            sb.append(title);
            sb.append(",");
        }
        System.out.println(sb);
    }

    public void takeBook(Book... books){
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" взял книги: ");
        for (Book book : books){
            sb.append(book.toString());
            sb.append(",");
        }
        System.out.println(sb);
    }

    public void returnBook(int count){
        System.out.println(name + " вернул " + count + " книги");
    }

    public void returnBook(String... titles){
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" вернул книги: ");
        for (String title : titles){
            sb.append(title);
                sb.append(",");
        }
        System.out.println(sb);
    }

    public void returnBook(Book... books){
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" вернул книги: ");
        for (Book book : books){
            sb.append(book.toString());
            sb.append(",");
        }
        System.out.println(sb);
    }
}
