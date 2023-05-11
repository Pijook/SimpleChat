package pl.pijok.simpleChat;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class PacketListener extends Listener {

    private final Gson gson;

    public PacketListener() {
        gson = new Gson();
    }

    @Override
    public void received(Connection connection, Object object) {
        super.received(connection, object);
        if(object instanceof Packet) {
            processMessage(object);
        }

    }

    public void processMessage(Object object) {
        Packet packet = (Packet) object;

        System.out.println("Received message " + packet.getTitle());
    }

}
