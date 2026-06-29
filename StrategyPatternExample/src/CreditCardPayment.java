public class CreditCardPayment implements PaymentStrategy {

    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolderName,
                              String expiryDate, String cvv) {
        this.cardNumber     = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate     = expiryDate;
        this.cvv            = cvv;
    }

    @Override
    public boolean validatePaymentDetails() {
        System.out.println("[CREDIT CARD] Validating card details...");
        if (cardNumber == null || cardNumber.length() != 16) {
            System.out.println("[CREDIT CARD] ✗ Invalid card number!");
            return false;
        }
        if (cvv == null || cvv.length() != 3) {
            System.out.println("[CREDIT CARD] ✗ Invalid CVV!");
            return false;
        }
        System.out.println("[CREDIT CARD] ✓ Card details valid!");
        return true;
    }

    @Override
    public void pay(String customerName, double amount) {
        System.out.println("[CREDIT CARD] Processing payment...");
        System.out.println("  Customer   : " + customerName);
        System.out.println("  Card No    : XXXX-XXXX-XXXX-" +
                           cardNumber.substring(12));
        System.out.println("  Card Holder: " + cardHolderName);
        System.out.println("  Expiry     : " + expiryDate);
        System.out.println("  Amount     : $" + String.format("%.2f", amount));
        System.out.println("  ✓ Payment of $" + String.format("%.2f", amount) +
                           " successful via Credit Card!");
    }
}