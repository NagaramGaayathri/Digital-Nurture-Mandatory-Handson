// Adds Slack notification on top of existing notifier
public class SlackNotifierDecorator extends NotifierDecorator {

    private String slackChannel;

    public SlackNotifierDecorator(Notifier notifier, String slackChannel) {
        super(notifier);
        this.slackChannel = slackChannel;
    }

    @Override
    public void send(String message) {
        // First call the wrapped notifier
        wrappedNotifier.send(message);
        // Then add Slack notification
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("[SLACK] Sending to: #" + slackChannel);
        System.out.println("        Message   : " + message);
    }
}