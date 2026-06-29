public interface PaymentProcessor {

    // Every payment gateway must implement these methods
    void processPayment(String customerName, double amount);
    void refundPayment(String transactionId, double amount);
    String getPaymentStatus(String transactionId);
}