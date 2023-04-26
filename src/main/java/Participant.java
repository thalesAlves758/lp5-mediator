public class Participant {
    private Integer id;
    private String name;
    private Server server;

    public Participant(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void connect(Server server) {
        this.server = server;
        server.addParticipant(this);
    }

    public String sendMessage(int to, String text) throws NullPointerException {
        if(server == null) {
            throw new NullPointerException("there is no connection");
        }

        Message message = new Message(this.id, to, text);
        return server.sendMessage(message);
    }

    public String showMessage(Message message) {
        return message.getText();
    }

    public Integer getId() {
        return this.id;
    }
}
