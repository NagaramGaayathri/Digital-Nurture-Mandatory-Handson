public class MobileApp implements Observer {

    private String appName;
    private String userName;

    public MobileApp(String appName, String userName) {
        this.appName  = appName;
        this.userName = userName;
    }

    @Override
    public void update(String stockName, double oldPrice, double newPrice) {
        double change    = newPrice - oldPrice;
        double changePct = (change / oldPrice) * 100;
        String direction = change >= 0 ? "▲ UP" : "▼ DOWN";

        System.out.println("[MOBILE - " + appName + "]");
        System.out.println("  User       : " + userName);
        System.out.println("  Stock      : " + stockName);
        System.out.println("  Old Price  : $" + String.format("%.2f", oldPrice));
        System.out.println("  New Price  : $" + String.format("%.2f", newPrice));
        System.out.println("  Change     : " + direction + " " +
                           String.format("%.2f", Math.abs(changePct)) + "%");
        System.out.println("  >> Push notification sent to " + userName + "!");
    }
}