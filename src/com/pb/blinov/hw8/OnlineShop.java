package com.pb.blinov.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Auth auth = new Auth();
        boolean flag = false;
        String login;
        String password;
        String confirmPassword;
        String login2;
        String password2;
        System.out.println(" Регистрация...");
        do{
            System.out.println("Укажите login: ");
            login = sc.nextLine();
            System.out.println("Придумайте пароль: ");
            password = sc.nextLine();
            System.out.println("Повторите пароль:");
            confirmPassword = sc.nextLine();
            try{
                auth.signUp(login,password,confirmPassword);
                flag = false;
            }catch (WrongPasswordException | WrongLoginException e){
                System.out.println(e.getMessage());
                System.out.println("Повторите.");
                flag = true;
            }
        }while (flag);
        do{
            System.out.println("Введите Login для входа: ");
            login2 = sc.nextLine();
            System.out.println("Введите пароль: ");
            password2 = sc.nextLine();
            try {
                auth.signIn(login2,password2);
                flag = false;
            }catch (WrongLoginException e){
                System.out.println(e.getMessage());
                flag = true;
            }
        }while (flag);
        System.out.println("Конец.");
    }
}
