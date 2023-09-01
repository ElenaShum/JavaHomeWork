/**
 * Описание жизненной ситуации. Поездки на автобусе.
 */

/*
Домашнее  заданиеСмоделировать  жизненную  ситуацию
(с  помощью  методов  и  свойств  объектов):
1)  Автобус  трогается  с  первой  остановки
2)  Автобус  останавливается  на  2-й  остановке  в  него  садятся  Человек  и  Собака
3)  на  4-й  остановке  они  выходят  и  входят  4  Человека
4)  4  человека  выходят  на  конечной  остановке

Все  остановки  должны  иметь  названия.
Объекты  должны  иметь  только  свои  свойства  и  методы  (без  дублирования  чужих).
Результат  работы  программы  -  в  методе  main  последовательный  вызов  нужных  методов  и
изменение  свойств  объектов  -  для  достижения  результата  задачи,  и  вывод  соответствующей  и
нформации  в  консоль.
Объекты  должны  быть  связаны  между  собой  для  определенного  действия  -  собака  не  может
сесть  в  автобус  без  человека.При  описании  классов  их  следует  разместить  по
пакетам  и  добавить  описание  методов  (javadoc).
Чем  больше  деталей  -  тем  лучше.
 */

import busPack.Bus;
import busStop.BusStop;
import humansPass.Passangers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите номер автобуса: ");

        Bus bus = new Bus();

        bus.setBusNumber(sc.nextLine());

        String busNumber = bus.getBusNumber();

        System.out.println("Введите модель автобуса на каком будет поездка: ");

        bus.setBusModel(sc.nextLine());

        String busModel = bus.getBusModel();

        BusStop busStop = new BusStop();

        int counter = 0;
        counter++;

        busStop.setBusStopStation(counter);

        int busStopStationNumber = busStop.getBusStopStation();

        System.out.println("Автобус " + busModel + " с номером " + "\"" + busNumber + "\"" +
                " отправился с остановки номер " + busStopStationNumber);

        String separateline = "---********---";

        System.out.println(separateline);

        busStopStationNumber++;

        Passangers amoutOfPassangers = new Passangers();

        System.out.println("Введите сколько пассажиров сядет в автобус на ближайшей остановке: ");

        amoutOfPassangers.setAmoutOfPassangers(sc.nextInt());

        int amountOfPass = amoutOfPassangers.getAmoutOfPassangers();

        System.out.println("Введите сколько указанные пассажиры имеют собак с собой: ");

        amoutOfPassangers.setAmoutOfDogs(sc.nextInt());
        System.out.println(separateline);

        int amountOfDogs = amoutOfPassangers.getAmoutOfDogs();

        if (amountOfDogs > amountOfPass) {
            System.out.println(separateline);
            System.out.println("Автобус не может продолжать движение");
        } else {
            System.out.println("Автобус приехал на остановку номер " + busStopStationNumber +
                    " и в него сели " + amountOfPass + " пассажира и c ними " + amountOfDogs + " собака(и)");

            System.out.println(separateline);

            busStopStationNumber++;

            System.out.println("Автобус " + busModel + " с номером " + "\"" + busNumber + "\"" +
                    " приехал на " + busStopStationNumber + " остановку. В нем находятся " + amountOfPass +
                    " пассажира и с ними " + amountOfDogs + " собака(и)");

            System.out.println(separateline);

            busStopStationNumber++;

            System.out.println("Автобус " + busModel + " приехал на основку номер " + busStopStationNumber);

            System.out.println(separateline);

            System.out.println("Из него вышли " + amountOfPass + " пассажира " + " забрав с собой " +
                    + amountOfDogs + " собака(и)");

            amountOfPass = 4;

            System.out.println(separateline);

            System.out.println("На 4ой остановке вошли " + amountOfPass + " пассажира");

            System.out.println(separateline);

            System.out.println(amountOfPass + " пассажира" + " вышли на конечной остановке");

        }

        }
}
