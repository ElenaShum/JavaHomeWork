package com.pb.blinov.hw15;

import com.pb.blinov.hw14.NetworkListener;
import com.pb.blinov.hw14.TCPConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GuiClient extends JFrame implements ActionListener, NetworkListener {

    private static final String IP_ADDR="127.0.0.1";
    private static final int PORT = 9021;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private TCPConnection connection;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuiClient();
            }
        });
    }

    private final JTextArea log = new JTextArea();
    private final JTextField fieldInput = new JTextField();

    public GuiClient() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        log.setEditable(false);
        log.setLineWrap(true);
        add(log,BorderLayout.CENTER);
        add(fieldInput, BorderLayout.SOUTH);
        fieldInput.addActionListener(this);
        setVisible(true);
        try {
            connection = new TCPConnection(this, IP_ADDR, PORT);
        } catch (IOException e) {
            printLog("Connection exception:"+e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = fieldInput.getText();
        if(msg.equals("")) return;
        fieldInput.setText(null);
        connection.sendString(msg);
    }


    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {
        printLog("Connection ready.");
    }

    @Override
    public void onReceiveString(TCPConnection tcpConnection, String value) {
        printLog(value);
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {
        printLog("Connection close.");
    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {
        printLog("Connection exception:"+e);
    }

    private synchronized void printLog(String str){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log.append(str+"\n");
                log.setCaretPosition(log.getDocument().getLength());
            }
        });
    }
}
