// Adapter translates our standard interface → RazorPay's methods
public class RazorPayAdapter implements PaymentProcessor {

    private RazorPayGateway razorPayGateway;

    public RazorPayAdapter(RazorPayGateway razorPayGateway) {
        this.razorPayGateway = razorPayGateway;
    }

    @Override
    public void processPayment(String customerName, double amount) {
        // Translate: processPayment → sendPayment
        String mobile = "9876543210";
        razorPayGateway.sendPayment(mobile, amount);
    }

    @Override
    public void refundPayment(String transactionId, double amount) {
        // Translate: refundPayment → cancelPayment
        razorPayGateway.cancelPayment(transactionId, amount);
    }

    @Override
    public String getPaymentStatus(String transactionId) {
        // Translate: getPaymentStatus → fetchPaymentStatus
        return razorPayGateway.fetchPaymentStatus(transactionId);
    }
}