package com.client.client.socket;

import com.client.client.entity.PackageEntity;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.List;

public class ClientSocket {

    public static String IP_SERVIDOR = "192.168.18.111";
    public static int PUERTO = 1234;

    public static void enviarPaquetes(List<PackageEntity> paquetes) throws Exception {
        try (Socket socket = new Socket(IP_SERVIDOR, PUERTO);
             DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream())) {

            dataOutput.writeInt(paquetes.size());

            for (PackageEntity paquete : paquetes) {
                dataOutput.writeUTF(paquete.getCode());
                dataOutput.writeUTF(paquete.getRecipientName());
                dataOutput.writeInt(paquete.getState());
            }
        }
    }
}
