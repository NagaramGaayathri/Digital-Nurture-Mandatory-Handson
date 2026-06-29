// PayPal has its OWN methods (different from our interface)
public class PayPalGateway {

    public void makePayment(String email, double amount) {
        System.out.println("[PayPal] Payment of $" + amount +
                           " processed for email: " + email);
    }

    public void initiateRefund(String paypalTransactionId, double amount) {
        System.out.println("[PayPal] Refund of $" + amount +
                           " initiated for Transaction ID: " + paypalTransactionId);
    }

    public String checkPaymentStatus(String paypalTransactionId) {
        System.out.println("[PayPal] Checking status for Transaction ID: " + paypalTransactionId);
        return "PayPal Payment - SUCCESS";
    }
}