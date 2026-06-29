public class EmailAlert implements Observer {

    private String emailAddress;
    private double alertThreshold; // Alert only if change exceeds this %

    public EmailAlert(String emailAddress, double alertThreshold) {
        this.emailAddress     = emailAddress;
        this.alertThreshold   = alertThreshold;
    }

    @Override
    public void update(String stockName, double oldPrice, double newPrice) {
        double change    = newPrice - oldPrice;
        double changePct = Math.abs((change / oldPrice) * 100);

        System.out.println("[EMAIL ALERT]");
        System.out.println("  To         : " + emailAddress);
        System.out.println("  Stock      : " + stockName);

        if (changePct >= alertThreshold) {
            System.out.println("  ⚠ ALERT! Price changed by " +
                               String.format("%.2f", changePct) +
                               "% (threshold: " + alertThreshold + "%)");
            System.out.println("  New Price  : $" + String.format("%.2f", newPrice));
            System.out.println("  >> URGENT email sent to " + emailAddress + "!");
        } else {
            System.out.println("  Change " + String.format("%.2f", changePct) +
                               "% is below threshold (" + alertThreshold +
                               "%). No email sent.");
        }
    }
}