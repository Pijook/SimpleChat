package pl.pijok.simpleChat;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Server;
import lombok.Getter;

import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    @Getter
    private static Client client;
    @Getter
    private static PacketSender packetSender;

    public static void main(String[] args) {
        Storage.USER_ID = UUID.randomUUID();
        client = new Client(51200, 51200);
        Kryo kryo = client.getKryo();
        kryo.register(Packet.class);

        client.addListener(new PacketListener());
        try {
            client.start();
            client.connect(3600, "localhost", 2137);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        packetSender = new PacketSender(client);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                String line = "";
                while(!line.equalsIgnoreCase("logout")) {
                    line = scanner.nextLine();

                    packetSender.sendTextMessage(line);
                }
            }
        }).start();

    }

}
