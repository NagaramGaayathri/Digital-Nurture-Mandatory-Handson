// Adds SMS notification on top of existing notifier
public class SMSNotifierDecorator extends NotifierDecorator {

    private String phoneNumber;

    public SMSNotifierDecorator(Notifier notifier, String phoneNumber) {
        super(notifier);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        // First call the wrapped notifier
        wrappedNotifier.send(message);
        // Then add SMS notification
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("[SMS]   Sending to: " + phoneNumber);
        System.out.println("        Message   : " + message);
    }
}