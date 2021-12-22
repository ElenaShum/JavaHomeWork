package com.pb.blinov.hw11;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static ArrayList<Person> persons = new  ArrayList<> ();

    public static void main(String[] args) throws Exception{
        while (menu() ){
            System.out.println("*****************");
        }

    }

    public static boolean menu() throws Exception{
        boolean isContinue = true;
        System.out.println("Главное меню:");
        System.out.println("11. Добавить тестовые данные.");
        System.out.println("1. Добавление элемента.");
        System.out.println("2. Удаление элемента");
        System.out.println("3. Показать список");
        System.out.println("4. Поиск");
        System.out.println("5. Сохранить в файл");
        System.out.println("6. Загрузить из файла ");
        System.out.println("7. Сотрировка");
        System.out.println("8. Редактирование");
        System.out.println("0. Выход");
        System.out.println("Сделайте Ваш выбор: ");
        Scanner scan = new Scanner(System.in);
        int choise;
        choise = scan.nextInt();
        switch (choise){
            case 0:
                isContinue = false;
                break;
            case 11:
                addt();
                break;
            case 1:
                add();
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
            case 8:
                showList();
                edit();
                break;
            default:
                System.out.println("Я такую операцию не умею");
        }
        return isContinue;
    }

    public static void addt() throws Exception{
        persons = new  ArrayList<> (Arrays.asList(
                new Person("Пётр", "1233456", LocalDate.of(2000,5,2),"ул. Колючая 3"),
                new Person("Василий", "3234345", LocalDate.of(1990, 4, 12),"ул. Сонная 13"),
                new Person("Анна", new String[]{"5454545", "3585454545"}, LocalDate.of(1996, 1, 20),"ул. Виноградная 75")
        ));
        showList();
    }

    public static void add(){
        Person p = new Person();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите новое имя: ");
        String name = scan.next();
        p.setName(name);
        HashSet<String> phones = new HashSet<>();
        boolean fl = true;
        while (fl){
            System.out.println("Выберите действие: ");
            System.out.println("1. Добавить телефон");
            System.out.println("0. Отмена");
            int ch = scan.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Введите номер:");
                    String phone = scan.next();
                    phones.add(phone);
                    break;
                case 0:
                    fl = false;
                    break;
            }
        }
        p.setPhones(phones);
        System.out.println("Введите дату рождения (пример 1987-12-30): ");
        String date = scan.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ld = LocalDate.parse(date,formatter);
        p.setDateOfBirth(ld);
        Scanner s = new Scanner(System.in);
        System.out.println("Введите адрес: ");
        String addres = s.nextLine();
        p.setAddress(addres);
        persons.add(p);
        System.out.println(p);
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
        ArrayList <Person> found = new ArrayList<>(persons.stream().filter(person -> person.getName().contains(name)).collect(Collectors.toList()));
        if(found.isEmpty()){
            System.out.println("Ничего не найдено!");
        } else found.stream().forEach(System.out::println);

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

    public static void edit() throws Exception{
        if (persons.isEmpty()){
            System.out.println("Сначала создайте или загрузите телефонную книгу!");
        }
        System.out.println("Укажите номер записи для редактирования:");
        Scanner scan = new Scanner(System.in);
        int num;
        num = scan.nextInt();
        Person p = persons.get(num);
        System.out.println(p);
        System.out.println("Какое поле желаете изменить? :");
        System.out.println("1. Имя ");
        System.out.println("2. Номер телефона");
        System.out.println("3. Дату рождения");
        System.out.println("4. Адрес");
        System.out.println("0. Выход");
        System.out.println("Сделайте Ваш выбор: ");
        int choise;
        choise = scan.nextInt();
        switch (choise) {
            case 1:
                System.out.println("Старое имя: "+p.getName());
                System.out.println("Введите новое имя: ");
                String name = scan.next();
                p.setName(name);
                break;
            case 2:
                System.out.println("Старые телефоны: "+p.getPhones());
                HashSet<String> phones = p.getPhones();
                System.out.println("Выберите действие: ");
                System.out.println("1. Добавить телефон");
                System.out.println("2. Удалить телефон");
                System.out.println("0. Отмена");
                int ch;
                ch = scan.nextInt();
                switch (ch) {
                    case 1:
                        System.out.println("Введите номер:");
                        String phone = scan.next();
                        p.addPhone(phone);
                        break;
                    case 2:
                       int s = phones.size();
                       if ( s == 0 ){
                           System.out.println("Телефонов нет!");
                           return;
                       }
                        System.out.println("Выберите номер для удаления:");
                        String[] tmpphones = phones.toArray(new String[s]);
                        for (int i = 0; i < s; i++) {
                            System.out.printf("%d %s %n",i,tmpphones[i]);
                        }
                        int n = scan.nextInt();
                        phones.remove(tmpphones[n]);
                        p.setPhones(phones);
                        System.out.println("Удалено!");
                        break;
                    case 0:
                        return;
                }
                break;
            case 3:
                System.out.println("Старая дата рождения : "+p.getDateOfBirth());
                System.out.println("Введите новую дату рождения (пример 1987-12-30): ");
                String date = scan.next();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate ld = LocalDate.parse(date,formatter);
                p.setDateOfBirth(ld);
                break;
            case 4:
                Scanner s = new Scanner(System.in);
                System.out.println("Старый адрес: "+p.getAddress());
                System.out.println("Введите новый адрес: ");
                String addres = s.nextLine();
                p.setAddress(addres);
                break;
            default:
                System.out.println("Я так не умею");
        }
        persons.set(num,p);
        System.out.println(p);
    }

    public static void delete() throws Exception{
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
