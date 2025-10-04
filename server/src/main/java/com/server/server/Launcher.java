package com.server.server;

import com.server.server.controllers.ServerController;
import com.server.server.socket.SocketServer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("frmServidorChuquival.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Servidor");
        stage.show();

        ServerController controller = loader.getController();
        int puerto = 1234;

        new Thread(() -> {
            try {
                SocketServer.start(puerto, controller);
            } catch (
                    Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
