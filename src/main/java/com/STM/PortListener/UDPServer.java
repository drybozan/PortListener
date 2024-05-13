package com.STM.PortListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

@Component
@Slf4j
public class UDPServer {

    int port = 6003;
    public void startServer() {

        while (true) {
            try (DatagramSocket socket = new DatagramSocket(port)) {
                byte[] buffer = new byte[1024];
                for (int i = 0; i < 2; i++) {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                    socket.receive(packet);
                    String received = new String(packet.getData(), 0, packet.getLength());
                    log.info("[port]  "+ port +" : " + received);

                    // Veriyi dosyaya yaz
                    writeToFile("[port "+ port +"]: " + received.replace("\00", ""));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void writeToFile(String data) {
        String filePath = "C:/stm-log.txt";
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(data + "\n");
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
