package com.client.client.controllers;

import com.client.client.entity.PackageEntity;
import com.client.client.socket.ClientSocket;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

public class EnvioPaqueteController {
    private static final Logger log = LoggerFactory.getLogger(EnvioPaqueteController.class);

    @FXML
    private TextField tfCode;

    @FXML
    private TextField tfRecipientName;

    @FXML
    private TextField tfState;

    @FXML
    protected void onSendPackageClick() throws Exception {
        String code = tfCode.getText();
        String recipientName = tfRecipientName.getText();
        int state;

        try {
            state = Integer.parseInt(tfState.getText());
        } catch (NumberFormatException e) {
            log.error("El estado debe ser un número entero");
            return;
        }

        PackageEntity packageEntity = new PackageEntity(code, recipientName, state);
        log.info("Enviando paquete {}", packageEntity);

        ClientSocket.enviarPaquetes(Collections.singletonList(packageEntity));
        log.info("Datos enviados al servidor");
    }
}
