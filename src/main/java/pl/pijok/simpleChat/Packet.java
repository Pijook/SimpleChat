package pl.pijok.simpleChat;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class Packet {

    private final UUID senderID;
    private final String title;
    private final String payload;

    public Packet(UUID senderID, String title, String payload) {
        this.senderID = senderID;
        this.title = title;
        this.payload = payload;
    }

}
