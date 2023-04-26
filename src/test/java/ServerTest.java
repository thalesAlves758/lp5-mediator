import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServerTest {
    @Test
    void shouldSendMessage() {
        Server server = new Server();

        Participant firstParticipant = new Participant(1, "first participant");
        Participant secondParticipant = new Participant(2, "second participant");

        firstParticipant.connect(server);
        secondParticipant.connect(server);

        String result = firstParticipant.sendMessage(secondParticipant.getId(), "Test message");

        assertEquals("Participant 2:\nMessage received by participant 1: Test message", result);
    }

    @Test
    void shouldNotSendMessage() {
        Participant firstParticipant = new Participant(1, "first participant");
        Participant secondParticipant = new Participant(2, "second participant");

        try {
            firstParticipant.sendMessage(secondParticipant.getId(), "Test message");
            fail();
        } catch (NullPointerException e) {
            assertEquals("there is no connection", e.getMessage());
        }
    }

    @Test
    void shouldNotFindParticipant() {
        Server server = new Server();

        Participant firstParticipant = new Participant(1, "first participant");

        firstParticipant.connect(server);

        try {
            firstParticipant.sendMessage(2, "Test message");
            fail();
        } catch (NullPointerException e) {
            assertEquals("participant not found!", e.getMessage());
        }
    }
}
