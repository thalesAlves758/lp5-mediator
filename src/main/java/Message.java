import java.util.Date;

public class Message {
    private int from;
    private int to;
    private String text;
    private Date sendingDate;

    public Message(int from, int to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
        this.sendingDate = new Date();
    }

    public String getText() {
        return this.text;
    }

    public int getTo() {
        return this.to;
    }

    public int getFrom() {
        return this.from;
    }
}
