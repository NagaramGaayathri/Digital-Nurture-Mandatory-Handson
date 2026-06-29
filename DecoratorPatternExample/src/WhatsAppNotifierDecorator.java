// Adds WhatsApp notification on top of existing notifier
public class WhatsAppNotifierDecorator extends NotifierDecorator {

    private String whatsappNumber;

    public WhatsAppNotifierDecorator(Notifier notifier, String whatsappNumber) {
        super(notifier);
        this.whatsappNumber = whatsappNumber;
    }

    @Override
    public void send(String message) {
        // First call the wrapped notifier
        wrappedNotifier.send(message);
        // Then add WhatsApp notification
        sendWhatsApp(message);
    }

    private void sendWhatsApp(String message) {
        System.out.println("[WHATSAPP] Sending to: +" + whatsappNumber);
        System.out.println("           Message   : " + message);
    }
}