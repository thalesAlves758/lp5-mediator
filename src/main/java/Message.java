import java.util.Date;

public class Message {
    private Integer from;
    private Integer to;
    private String text;
    private Date sendingDate;

    public Message(Integer from, Integer to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
        this.sendingDate = new Date();
    }

    public String getText() {
        return this.text;
    }

    public Integer getTo() {
        return this.to;
    }

    public Integer getFrom() {
        return this.from;
    }
}
