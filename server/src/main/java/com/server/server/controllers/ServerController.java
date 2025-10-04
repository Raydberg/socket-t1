package com.server.server.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ServerController {
    @FXML
    private TextArea taPaquetes;

    public void mostrarPaquetes(String paquetes) {
        taPaquetes.appendText(paquetes + "\n");
    }

}
