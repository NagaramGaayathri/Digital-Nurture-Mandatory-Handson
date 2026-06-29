public interface PaymentStrategy {

    // Every payment method must implement this
    void pay(String customerName, double amount);

    // Validate payment details before processing
    boolean validatePaymentDetails();
}