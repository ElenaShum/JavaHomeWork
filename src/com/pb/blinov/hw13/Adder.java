package com.pb.blinov.hw13;

import java.util.Queue;

public class Adder extends Thread {
    private final Queue<String> buffer;
    private final Object monitor;

    public Adder(Queue<String> buffer, Object monitor) {
        this.buffer = buffer;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        int i = 1;
        while(true){
            // Захватываем монитор
            synchronized (monitor) {
                // Добавляем строки в буфер
                buffer.add("foo " + i);
                i++;
                System.out.println("Добавил");
                // Будим поток-потребитель
                monitor.notify();
                // И засыпаем пока он не обработает строки в буфере
                while (buffer.size() > 4) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
