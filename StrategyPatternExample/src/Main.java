public class Main {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("      Payment System Demo                 ");
        System.out.println("==========================================\n");

        // Create payment context for customer
        PaymentContext context = new PaymentContext("Gaayathri Nagaram");

        // --- Payment 1: Credit Card ---
        System.out.println("--- Payment 1: Credit Card ---");
        context.setPaymentStrategy(
            new CreditCardPayment("1234567890123456", "Gaayathri",
                                  "12/26", "123")
        );
        context.executePayment(1500.00);

        System.out.println();

        // --- Payment 2: PayPal ---
        System.out.println("--- Payment 2: PayPal ---");
        context.setPaymentStrategy(
            new PayPalPayment("gaayathri@gmail.com", "securePass123")
        );
        context.executePayment(2999.99);

        System.out.println();

        // --- Payment 3: UPI ---
        System.out.println("--- Payment 3: UPI ---");
        context.setPaymentStrategy(
            new UPIPayment("gaayathri@upi", "123456")
        );
        context.executePayment(499.00);

        System.out.println();

        // --- Payment 4: Net Banking ---
        System.out.println("--- Payment 4: Net Banking ---");
        context.setPaymentStrategy(
            new NetBankingPayment("State Bank of India",
                                  "123456789012", "bankPass@123")
        );
        context.executePayment(7500.00);

        System.out.println();

        // --- Payment 5: Invalid Credit Card (validation fails) ---
        System.out.println("--- Payment 5: Invalid Credit Card ---");
        context.setPaymentStrategy(
            new CreditCardPayment("12345", "Gaayathri", "12/26", "12")
        );
        context.executePayment(999.00);

        System.out.println("\n==========================================");
        System.out.println("            Demo Complete                 ");
        System.out.println("==========================================");
    }
}