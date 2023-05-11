package pl.pijok.simpleChat;

import com.esotericsoftware.kryonet.Listener;
import com.google.gson.Gson;

public class PacketListener extends Listener {

    private final Gson gson;

    public PacketListener() {
        gson = new Gson();
    }

    public void processMessage(Object object) {
        String string = (String) object;

    }

}
