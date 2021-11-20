package com.pb.blinov.hw8;

import java.util.regex.Pattern;

public class Auth {
    private String login;
    private String password;

    public void signUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException{
        if (!Pattern.matches("[a-zA-Z0-9]{5,20}",login)) {
            throw new WrongLoginException("Длинна Login должна быть от 5 до 20 символов. " +
                    "Login должен содержать только латинские буквы и цифры");
        }
        if (!Pattern.matches("[a-zA-Z0-9_]{5,}",password)) {
            throw new WrongPasswordException("Пароль не корректный требования: длинна более 5, только латинские буквы и цифры и знак подчеркивания.");
        }
        if (confirmPassword.equals(password)) {
            this.login = login;
            this.password = password;
            System.out.println("Регистрация успешна");
        } else {
            throw new WrongPasswordException("Пароли  не совпадает - попробуйте еще раз");
        }
    }

    public void signIn(String login, String password) throws WrongLoginException {
        if (this.login.equals(login) &&  this.password.equals(password)) {
            System.out.println("Успешный вход!");
        }
        else {
            throw new WrongLoginException("Login или Password не совпадают - попробуйте еще раз");
        }

    }
}
