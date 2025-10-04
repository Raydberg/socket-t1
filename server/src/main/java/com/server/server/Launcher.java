package com.server.server;

import com.server.server.socket.SocketServer;
import javafx.application.Application;

public class Launcher {
    public static void main(String[] args) {
        Application.launch(HelloApplication.class, args);
        int puerto = 1234;
        try {
            SocketServer.start(puerto);
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}
