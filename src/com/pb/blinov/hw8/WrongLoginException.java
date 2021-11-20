package com.pb.blinov.hw8;

public class WrongLoginException extends Exception{
    public WrongLoginException() {
        super();
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
