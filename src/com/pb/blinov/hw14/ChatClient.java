package com.pb.blinov.hw14;

import java.io.IOException;
import java.util.Scanner;

public class ChatClient implements NetworkListener{
    private TCPConnection connection;
    public static void main(String[] args) {
        new ChatClient();
    }

    private ChatClient(){
        try {
            this.connection = new TCPConnection(this,"127.0.0.1", 9021);
            while (true){
                getMsg();
            }
        } catch (IOException e) {
            System.out.println("Client exception: "+e);
        }
    }

    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {
        System.out.println("Connection ready...");
    }

    @Override
    public void onReceiveString(TCPConnection tcpConnection, String value) {
        System.out.println(value);
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {
        System.out.println("Connection close");
    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {
        System.out.println("Connection exception:"+e);
    }

    private void getMsg(){
        System.out.println("Введите сообщение:");
        Scanner sc = new Scanner(System.in);
        String msg = sc.next();
        connection.sendString(msg);
    }
}
