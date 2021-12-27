package com.pb.blinov.hw13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Разделяемые потоками ресурсы - буфер и монитор
        final Queue<String> sharedBuffer = new LinkedList<>();
        final Object sharedMonitor = new Object();

        // Потоки, пока не запускаются
        final Thread adder = new Adder(sharedBuffer, sharedMonitor),
                printer = new Printer(sharedBuffer, sharedMonitor);

        // Если все написано верно, вне зависимости от порядка запуска потоки
        // отрабатают без дедлоков
        if (new Random().nextBoolean()) {
            adder.start();
            printer.start();
        } else {
            printer.start();
            adder.start();
        }
    }
}
