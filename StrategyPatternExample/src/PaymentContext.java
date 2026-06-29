public class PaymentContext {

    // Holds reference to current payment strategy
    private PaymentStrategy paymentStrategy;
    private String customerName;

    public PaymentContext(String customerName) {
        this.customerName = customerName;
    }

    // Set or change strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
        System.out.println("[CONTEXT] Payment strategy set to: " +
                           paymentStrategy.getClass().getSimpleName());
    }

    // Execute the current strategy
    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("[CONTEXT] ✗ No payment strategy selected!");
            return;
        }

        System.out.println("\n[CONTEXT] Starting payment process for: " + customerName);
        System.out.println("[CONTEXT] Amount: $" + String.format("%.2f", amount));

        // First validate, then pay
        if (paymentStrategy.validatePaymentDetails()) {
            paymentStrategy.pay(customerName, amount);
        } else {
            System.out.println("[CONTEXT] ✗ Payment failed due to invalid details!");
        }
    }
}