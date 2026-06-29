public class UPIPayment implements PaymentStrategy {

    private String upiId;
    private String upiPin;

    public UPIPayment(String upiId, String upiPin) {
        this.upiId  = upiId;
        this.upiPin = upiPin;
    }

    @Override
    public boolean validatePaymentDetails() {
        System.out.println("[UPI] Validating UPI ID...");
        if (upiId == null || !upiId.contains("@")) {
            System.out.println("[UPI] ✗ Invalid UPI ID!");
            return false;
        }
        if (upiPin == null || upiPin.length() != 6) {
            System.out.println("[UPI] ✗ Invalid UPI PIN!");
            return false;
        }
        System.out.println("[UPI] ✓ UPI ID verified!");
        return true;
    }

    @Override
    public void pay(String customerName, double amount) {
        System.out.println("[UPI] Processing payment...");
        System.out.println("  Customer   : " + customerName);
        System.out.println("  UPI ID     : " + upiId);
        System.out.println("  Amount     : ₹" + String.format("%.2f", amount));
        System.out.println("  ✓ Payment of ₹" + String.format("%.2f", amount) +
                           " successful via UPI!");
    }
}