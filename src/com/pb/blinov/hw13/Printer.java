package com.pb.blinov.hw13;

import java.util.Queue;

public class Printer extends Thread {
    private final Queue<String> buffer;
    private final Object monitor;

    public Printer(Queue<String> buffer, Object monitor) {
        this.buffer = buffer;
        this.monitor = monitor;
    }

    @Override
    public void run() {
       while(true) {
            // Захватываем монитор
            synchronized (monitor) {
                // Спим пока поток-производитель не положит в буфер строки
                while (buffer.size() < 1) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                // Достаем строки из буфера и печатаем
                System.out.println(buffer.poll());
                System.out.println("Размер буфера:"+buffer.size());
                // Будим поток-производитель
                monitor.notify();
            }
        }
    }

}
