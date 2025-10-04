package com.server.server.socket;

import com.server.server.controllers.ServerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private static final Logger log = LoggerFactory.getLogger(SocketServer.class);

    public static void start(int puerto, ServerController controller) throws Exception {
        try (ServerSocket listener = new ServerSocket(puerto)) {
            log.info("Servidor listo y escuchando en {}:{}", listener.getInetAddress(), puerto);

            while (true) {
                try (Socket client = listener.accept();
                     DataInputStream dataInput = new DataInputStream(client.getInputStream())) {

                    log.info("Cliente conectado, IP {}", client.getInetAddress());

                    int cantidadPaquetes = dataInput.readInt();
                    for (int i = 0; i < cantidadPaquetes; i++) {
                        String code = dataInput.readUTF();
                        String recipientName = dataInput.readUTF();
                        int state = dataInput.readInt();

                        String estadoTexto = switch (state) {
                            case 1 ->
                                    "En camino";
                            case 2 ->
                                    "Entregado";
                            case 3 ->
                                    "Reprogramado";
                            default ->
                                    "Desconocido";
                        };

                        String paquete = String.format("Código: %s\nDestinatario: %s\nEstado: %s", code, recipientName, estadoTexto);
                        log.info("Paquete recibido: {}", paquete);

                        controller.mostrarPaquetes(paquete);
                    }
                }
            }
        }
    }
}
