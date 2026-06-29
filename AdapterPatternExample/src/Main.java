public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   Payment Processing System Demo       ");
        System.out.println("========================================\n");

        // --- PayPal Payment ---
        System.out.println("--- Processing via PayPal ---");
        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        paypal.processPayment("Gaayathri Nagaram", 1500.00);
        System.out.println("Status: " + paypal.getPaymentStatus("PP-TXN-001"));
        paypal.refundPayment("PP-TXN-001", 500.00);

        System.out.println();

        // --- Stripe Payment ---
        System.out.println("--- Processing via Stripe ---");
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        stripe.processPayment("Ravi Kumar", 2999.99);
        System.out.println("Status: " + stripe.getPaymentStatus("STR-CHG-002"));
        stripe.refundPayment("STR-CHG-002", 999.99);

        System.out.println();

        // --- RazorPay Payment ---
        System.out.println("--- Processing via RazorPay ---");
        PaymentProcessor razorpay = new RazorPayAdapter(new RazorPayGateway());
        razorpay.processPayment("Priya Sharma", 4999.00);
        System.out.println("Status: " + razorpay.getPaymentStatus("RZP-ORD-003"));
        razorpay.refundPayment("RZP-ORD-003", 1000.00);

        System.out.println("\n========================================");
        System.out.println("            Demo Complete               ");
        System.out.println("========================================");
    }
}