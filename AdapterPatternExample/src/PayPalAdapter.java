// Adapter translates our standard interface → PayPal's methods
public class PayPalAdapter implements PaymentProcessor {

    private PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(String customerName, double amount) {
        // Translate: processPayment → makePayment
        String email = customerName.toLowerCase().replace(" ", ".") + "@gmail.com";
        payPalGateway.makePayment(email, amount);
    }

    @Override
    public void refundPayment(String transactionId, double amount) {
        // Translate: refundPayment → initiateRefund
        payPalGateway.initiateRefund(transactionId, amount);
    }

    @Override
    public String getPaymentStatus(String transactionId) {
        // Translate: getPaymentStatus → checkPaymentStatus
        return payPalGateway.checkPaymentStatus(transactionId);
    }
}