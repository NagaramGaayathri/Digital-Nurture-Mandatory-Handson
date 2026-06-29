public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("     Notification System Demo           ");
        System.out.println("========================================\n");

        // Case 1: Email only (base component)
        System.out.println("--- Case 1: Email Only ---");
        Notifier emailOnly = new EmailNotifier("gaayathri@gmail.com");
        emailOnly.send("Your order has been placed!");
        System.out.println();

        // Case 2: Email + SMS
        System.out.println("--- Case 2: Email + SMS ---");
        Notifier emailAndSMS = new SMSNotifierDecorator(
                new EmailNotifier("gaayathri@gmail.com"),
                "9876543210"
        );
        emailAndSMS.send("Your payment was successful!");
        System.out.println();

        // Case 3: Email + SMS + Slack
        System.out.println("--- Case 3: Email + SMS + Slack ---");
        Notifier emailSMSSlack = new SlackNotifierDecorator(
                new SMSNotifierDecorator(
                        new EmailNotifier("gaayathri@gmail.com"),
                        "9876543210"
                ),
                "general-alerts"
        );
        emailSMSSlack.send("Server is down! Urgent attention needed.");
        System.out.println();

        // Case 4: Email + SMS + Slack + WhatsApp (all channels)
        System.out.println("--- Case 4: All Channels ---");
        Notifier allChannels = new WhatsAppNotifierDecorator(
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier("gaayathri@gmail.com"),
                                "9876543210"
                        ),
                        "critical-alerts"
                ),
                "919876543210"
        );
        allChannels.send("CRITICAL: Database backup failed!");
        System.out.println();

        System.out.println("========================================");
        System.out.println("            Demo Complete               ");
        System.out.println("========================================");
    }
}