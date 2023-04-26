import java.util.HashMap;
import java.util.Map;

public class Server {
    private Map<Integer, Participant> participants = new HashMap<Integer, Participant>();

    public void addParticipant(Participant participant) {
        participants.put(participant.getId(), participant);
    }

    public String sendMessage(Message message) throws NullPointerException {
        Participant recipient = participants.get(message.getTo());

        if(recipient == null) {
            throw new NullPointerException("participant not found!");
        }

        return "Participant " + message.getTo() + ":\n" +
                "Message received by participant " + message.getFrom() + ": " + recipient.showMessage(message);
    }
}
