package com.pb.blinov.hw5;

public class Library {
    public static void main(String[] args) {
        Reader[] readers = new Reader[3];
        Book[] books = new Book[3];

        readers[0] = new Reader("Петров И.И.","A1","Физмат","20.10.2002","380991234567");
        readers[1] = new Reader("Сдоров А.И.","A2","История","21.02.2001","380961234567");
        readers[2] = new Reader("Иванов И.В.","Б1","Литература","10.05.2003","380671234567");

        books[0] = new Book("Приключения",2000,"Дивов О.И.");
        books[1] = new Book("Энциклопедия",2001,"Лукьяненко С.В.");
        books[2] = new Book("Фантастика",2002,"Лем С.Г.");

        System.out.println("КНИГИ:");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("\nЧИТАТЕЛИ:");
        for(Reader reader : readers){
            System.out.println(reader);
        }

        System.out.println("\nБерем");
        readers[0].takeBook(2);

        String[] takedBooks = new String[2];
        takedBooks[0] = books[1].getTitle();
        takedBooks[1] = books[2].getTitle();
        readers[1].takeBook(takedBooks);

        readers[2].takeBook(books);

        System.out.println("\nВозвращаем");
        readers[0].returnBook(2);

        readers[1].returnBook(takedBooks);

        readers[2].returnBook(books);
    }
}
