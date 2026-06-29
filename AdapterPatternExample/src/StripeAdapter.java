// Adapter translates our standard interface → Stripe's methods
public class StripeAdapter implements PaymentProcessor {

    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(String customerName, double amount) {
        // Translate: processPayment → charge
        String cardToken = "tok_" + customerName.toLowerCase().replace(" ", "_");
        stripeGateway.charge(cardToken, amount);
    }

    @Override
    public void refundPayment(String transactionId, double amount) {
        // Translate: refundPayment → reverseCharge
        stripeGateway.reverseCharge(transactionId, amount);
    }

    @Override
    public String getPaymentStatus(String transactionId) {
        // Translate: getPaymentStatus → retrieveChargeStatus
        return stripeGateway.retrieveChargeStatus(transactionId);
    }
}