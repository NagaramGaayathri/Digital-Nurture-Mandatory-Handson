public class PayPalPayment implements PaymentStrategy {

    private String paypalEmail;
    private String paypalPassword;

    public PayPalPayment(String paypalEmail, String paypalPassword) {
        this.paypalEmail    = paypalEmail;
        this.paypalPassword = paypalPassword;
    }

    @Override
    public boolean validatePaymentDetails() {
        System.out.println("[PAYPAL] Validating PayPal account...");
        if (paypalEmail == null || !paypalEmail.contains("@")) {
            System.out.println("[PAYPAL] ✗ Invalid email address!");
            return false;
        }
        if (paypalPassword == null || paypalPassword.length() < 6) {
            System.out.println("[PAYPAL] ✗ Invalid password!");
            return false;
        }
        System.out.println("[PAYPAL] ✓ PayPal account verified!");
        return true;
    }

    @Override
    public void pay(String customerName, double amount) {
        System.out.println("[PAYPAL] Processing payment...");
        System.out.println("  Customer   : " + customerName);
        System.out.println("  PayPal ID  : " + paypalEmail);
        System.out.println("  Amount     : $" + String.format("%.2f", amount));
        System.out.println("  ✓ Payment of $" + String.format("%.2f", amount) +
                           " successful via PayPal!");
    }
}