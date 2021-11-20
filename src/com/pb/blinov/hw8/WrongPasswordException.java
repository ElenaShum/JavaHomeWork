package com.pb.blinov.hw8;

public class WrongPasswordException extends  Exception{
    public WrongPasswordException() {
        super();
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
