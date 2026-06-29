// Abstract Decorator — wraps any Notifier
// and delegates the send() call to it
public abstract class NotifierDecorator implements Notifier {

    // Holds reference to wrapped Notifier object
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        // Delegate to the wrapped notifier
        wrappedNotifier.send(message);
    }
}