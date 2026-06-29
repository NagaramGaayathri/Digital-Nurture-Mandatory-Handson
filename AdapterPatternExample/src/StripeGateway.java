// Stripe has its OWN different methods
public class StripeGateway {

    public void charge(String cardToken, double amount) {
        System.out.println("[Stripe] Charging $" + amount +
                           " using card token: " + cardToken);
    }

    public void reverseCharge(String stripeChargeId, double amount) {
        System.out.println("[Stripe] Reversing charge of $" + amount +
                           " for Charge ID: " + stripeChargeId);
    }

    public String retrieveChargeStatus(String stripeChargeId) {
        System.out.println("[Stripe] Retrieving status for Charge ID: " + stripeChargeId);
        return "Stripe Charge - COMPLETED";
    }
}
