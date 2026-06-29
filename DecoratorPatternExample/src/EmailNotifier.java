// Base component — the default notifier
public class EmailNotifier implements Notifier {

    private String emailAddress;

    public EmailNotifier(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void send(String message) {
        System.out.println("[EMAIL] Sending to: " + emailAddress);
        System.out.println("        Message   : " + message);
    }
}