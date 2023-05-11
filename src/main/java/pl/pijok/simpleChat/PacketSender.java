package pl.pijok.simpleChat;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Server;

import java.util.UUID;

public class PacketSender {

    private final Client client;

    public PacketSender(Client client) {
        this.client = client;
    }

    private void sendPacket(Packet packet) {
        try {
            client.sendTCP(packet);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void sendTextMessage(String message) {
        Packet packet = Packet.builder()
                .senderID(Storage.USER_ID.toString())
                .title("text")
                .payload(message)
                .build();

        sendPacket(packet);
    }
}
