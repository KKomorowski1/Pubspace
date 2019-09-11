package pl.komorowski.pubspace.mail;

public interface FeedbackSender {
    void sendFeedback(String from, String name, String feedback);
}
