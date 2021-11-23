package com.pb.blinov.hw9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class FileNumbers {

    public static void main(String[] args) {
        createNumbersFile();
        createOddNumbersFile();
    }

    public static void createNumbersFile(){
        Path path = Paths.get("files/numbers.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            int i;
            int j;
            int num;
            Random r = new Random();
            for( i = 0; i < 10; i++){
                for (j=0; j<10;j++){
                    num = r.nextInt(100);
                    writer.write(num + " ");
                }
                writer.newLine();
            }
        } catch (Exception ex) {
            System.out.println("Error with file write: " + ex);
        }
        System.out.println("Write to file \"" + path.toAbsolutePath() + "\" done!");
    }

    public static void createOddNumbersFile(){
        Path path = Paths.get("files/numbers.txt");
        Path path2 = Paths.get("files/odd-numbers.txt");
        try (Scanner scan = new Scanner(path)) {
            try (BufferedWriter writer = Files.newBufferedWriter(path2)) {
                int k = 1;
                while (true) {
                    int num = scan.nextInt();
                    if (num % 2 == 0) num = 0;
                    writer.write(num + " ");
                    if(k % 10 == 0) writer.newLine();
                    k++;
                }
            } catch (IOException ex) {
                System.out.println("Error with file write: " + ex);
            }
        } catch (NoSuchElementException ex) {
            System.out.println("Файл прочитан.");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        show(path);
        show(path2);
    }

    private static void show(Path path){
        System.out.println("Read text from file \"" + path.toAbsolutePath() + "\":");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            System.out.println("----------------------------------");
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("----------------------------------");

        } catch (Exception ex) {
            System.out.println("Error with file read: " + ex);
        }
    }
}
