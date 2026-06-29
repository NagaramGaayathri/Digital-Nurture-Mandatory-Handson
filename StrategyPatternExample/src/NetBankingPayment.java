public class NetBankingPayment implements PaymentStrategy {

    private String bankName;
    private String accountNumber;
    private String password;

    public NetBankingPayment(String bankName, String accountNumber,
                              String password) {
        this.bankName      = bankName;
        this.accountNumber = accountNumber;
        this.password      = password;
    }

    @Override
    public boolean validatePaymentDetails() {
        System.out.println("[NET BANKING] Validating bank account...");
        if (accountNumber == null || accountNumber.length() < 8) {
            System.out.println("[NET BANKING] ✗ Invalid account number!");
            return false;
        }
        if (password == null || password.length() < 6) {
            System.out.println("[NET BANKING] ✗ Invalid password!");
            return false;
        }
        System.out.println("[NET BANKING] ✓ Bank account verified!");
        return true;
    }

    @Override
    public void pay(String customerName, double amount) {
        System.out.println("[NET BANKING] Processing payment...");
        System.out.println("  Customer   : " + customerName);
        System.out.println("  Bank       : " + bankName);
        System.out.println("  Account No : XXXX" +
                           accountNumber.substring(accountNumber.length() - 4));
        System.out.println("  Amount     : ₹" + String.format("%.2f", amount));
        System.out.println("  ✓ Payment of ₹" + String.format("%.2f", amount) +
                           " successful via Net Banking!");
    }
}