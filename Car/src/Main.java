/*
Домашнее задание: Выбрать предметную область, например:
геометрические фигуры, автомобили, животные и т.д.
Создать иерархию классов для выбранной предметной области с использованием наследования,
3 - 4 класса достаточно. Определить для каждого класса свой уникальный конструктор, методы и поля.
В классах переопределить методы toString, equals, hashCode.
Создать класс Main в котором продемонстрировать работу классов из предметной области,
создать несколько объектов с помощью оператора new, создать один объект с использованием механизма рефлексии.

Поместить созданные объекты в массив и выполнить над ними действия демонстрирующие работу полиморфизма.
 */

import passengerCars.PassengerCars;
import passengerCars.frontWheelDrive.FrontWheelDrive;
import passengerCars.frontWheelDrive.chevrolet.Chevrolet;
import passengerCars.frontWheelDrive.chevrolet.aveo.Aveo;

import java.lang.reflect.Constructor;

import static java.awt.Color.red;


public class Main {
    public static void main(String[] args) throws Exception {
         Chevrolet car = new Aveo("blue", true);
         FrontWheelDrive car2 = new FrontWheelDrive();
         Aveo car3 = new Aveo("blue", true);
         PassengerCars car4 = new PassengerCars(true, 5);

         car.setBodyType("sedan");
        String bodyType1 = car.getBodyType();

        car.setFrontWheelDrive(true);
        String wheelDrive;

        if (car.getFrontWheelDrive()) {
            wheelDrive = "Переднего привада";
        } else {
            wheelDrive = "Не переднего привада";
        }

        Aveo characteristic = new Aveo();
        characteristic.setColor("blue");
        characteristic.setConditioner(true);

        String color = characteristic.getColor();

        String conditioner;

        if (characteristic.getIsConditioner()) {
            conditioner = "В наличии";
        } else {
            conditioner = "Отсутствует";
        }

        car.setSeatsCount(5);
        int countSeats = car.getSeatsCount();



        String isPass;
        car.setPassengerCars(true);

        if (car.getPassengerCars()) {
            isPass = "Легковое";
        } else {
            isPass = " Не легковое";
        }

        StringBuilder message = new StringBuilder();
        message.append("Описание характирестик: ");
        message.append(isPass);
        message.append(" Авто ");
        message.append(" c типом кузова " + bodyType1 + " ");
        message.append( color + " цвета, " + " кондиционер ");
        message.append(conditioner + ", кол-во мест " + countSeats);


/* -- сравнение выводов данных в консоль
        System.out.println("Описание характирестик: " +
                        isPass + " Авто " + wheelDrive  + " c типом кузова " + bodyType1 + " " +
                          color + " цвета, " + " кондиционер " +
                conditioner + ", кол-во мест " + countSeats);
        System.out.println("---");
        System.out.println(message);
*/
        car.start();
        car.drive();
        car.park();


        System.out.println(car.toString());
        System.out.println(car.hashCode());
        System.out.println(car.equals(car2));
        System.out.println("-----");

        System.out.println(car3.toString());
        System.out.println(car3.hashCode());
        System.out.println(car3.equals(car2));
        System.out.println("------");

        System.out.println(car2.toString());
        System.out.println(car2.hashCode());
        System.out.println(car2.equals(car2));
        System.out.println("-----");

        System.out.println(car4.toString());
        System.out.println(car4.hashCode());
        System.out.println(car4.equals(car2));
        System.out.println("-----");

        /*
        создание объекта с помощью метода рефлексии
         */

        Class reqClass = car3.getClass();
        System.out.println(reqClass.getName()); // passengerCars.frontWheelDrive.chevrolet.aveo.Aveo

        Class newClass = Class.forName("passengerCars.frontWheelDrive.chevrolet.aveo.Aveo");
        Constructor newConstructor = newClass.getConstructor(new Class[]{String.class, boolean.class});

        Object newCar = newConstructor.newInstance("red", true);
        System.out.println(newCar.toString());

        /*
        пример работы полиморфизма
         */

        PassengerCars[] cars = new PassengerCars[] {new PassengerCars(), new Aveo()};

        for (PassengerCars auto: cars) {
            auto.isPassenger();
        }

        }
    }
