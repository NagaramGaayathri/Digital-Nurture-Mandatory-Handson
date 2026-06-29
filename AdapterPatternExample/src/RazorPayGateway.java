// RazorPay has its OWN different methods
public class RazorPayGateway {

    public void sendPayment(String mobileNumber, double amount) {
        System.out.println("[RazorPay] Sending payment of ₹" + amount +
                           " to mobile: " + mobileNumber);
    }

    public void cancelPayment(String razorPayOrderId, double amount) {
        System.out.println("[RazorPay] Cancelling payment of ₹" + amount +
                           " for Order ID: " + razorPayOrderId);
    }

    public String fetchPaymentStatus(String razorPayOrderId) {
        System.out.println("[RazorPay] Fetching status for Order ID: " + razorPayOrderId);
        return "RazorPay Payment - CAPTURED";
    }
}