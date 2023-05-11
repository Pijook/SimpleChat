package pl.pijok.simpleChat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class Packet {

    private String senderID;
    private String title;
    private String payload;

    public Packet() {
    }
}
