package com.pb.blinov.hw11;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static ArrayList<Person> persons = new  ArrayList<> ();

    public static void main(String[] args) throws Exception{
//         persons = new  ArrayList<> (Arrays.asList(
//                new Person("Jack", "1233456", LocalDate.of(2000,5,2)),
//                new Person("Vasiliy", "3234345", LocalDate.of(1990, 4, 12)),
//                new Person("Anna", new String[]{"5454545", "3585454545"}, LocalDate.of(1996, 1, 20))
//        ));
        while (menu() ){
            System.out.println("*****************");
        }

    }

    public static boolean menu() throws Exception{
        boolean isContinue = true;
        System.out.println("Главное меню:");
        System.out.println("1. Добавление элемента.");
        System.out.println("2. Удаление элемента");
        System.out.println("3. Показать список");
        System.out.println("4. Поиск");
        System.out.println("5. Сохранить в файл");
        System.out.println("6. Загрузить из файла ");
        System.out.println("7. Сотрировка");
        System.out.println("0. Выход");
        System.out.println("Сделайте Ваш выбор: ");
        Scanner scan = new Scanner(System.in);
        int choise;
        choise = scan.nextInt();
        switch (choise){
            case 0:
                isContinue = false;
                break;
            case 1:
                addt();
                break;
            case 2:
                showList();
                delete();
                break;
            case 3:
                showList();
                break;
            case 4:
                search();
                break;
            case 5:
                save();
                break;
            case 6:
                load();
                break;
            case 7:
                sort();
                break;
            default:
                System.out.println("Я такую операцию не умею");
        }
        return isContinue;
    }

    public static void addt() throws Exception{
        persons.add(new Person("Hanna", new String[]{"656984545", "+86585454545"}, LocalDate.of(1993, 2, 20)));
        showList();
    }

    public static void add(){
//        Scanner scan = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate lt = LocalDate.parse("2021-31-12",formatter);
        System.out.println(lt.toString());
    }

    public static void showList(){
        if (persons.isEmpty()){
            System.out.println("Телефонная книга пуста!");
            return;
        }
        int i = 0;

        for(Person person : persons){
            System.out.print(i+".");
            System.out.println(person.toString());
            i++;
        }
    }

    public static void search(){
        System.out.println("Укажите имя человека для поиска:");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        persons.stream().filter(person -> person.getName().contains(name)).forEach(System.out::println);
    }

    public static void sort(){
        System.out.println("Выберите поле для сортировки 1. По имени. 2. По дате рождения:");
        Scanner scan = new Scanner(System.in);
        int choise;
        choise = scan.nextInt();
        switch (choise) {
            case 1:
                persons.sort(Comparator.comparing(Person::getName));
                System.out.println("Готово");
                break;
            case 2:
                persons.sort(Comparator.comparing(Person::getDateOfBirth));
                System.out.println("Готово");
                break;
            default:
                System.out.println("Я так не умею");
        }
    }

    public static void delete(){
        System.out.println("Укажите номер записи для удаления:");
        Scanner scan = new Scanner(System.in);
        int num;
        num = scan.nextInt();
        persons.remove(num);
        System.out.println("Запись удалена.");
    }

    public static void save() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        String personsJson = mapper.writeValueAsString(persons);
        mapper.writeValue(Paths.get("files/phonebook.json").toFile(),persons);
        System.out.println("Сохранено");
    }

    public static void load() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        persons = new ArrayList<Person>(Arrays.asList(mapper.readValue(Paths.get("files/phonebook.json").toFile(), Person[].class)));
        System.out.println("Загружено");
    }
}
