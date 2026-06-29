public class WebApp implements Observer {

    private String websiteName;

    public WebApp(String websiteName) {
        this.websiteName = websiteName;
    }

    @Override
    public void update(String stockName, double oldPrice, double newPrice) {
        double change    = newPrice - oldPrice;
        String direction = change >= 0 ? "▲ RISING" : "▼ FALLING";

        System.out.println("[WEB - " + websiteName + "]");
        System.out.println("  Stock      : " + stockName);
        System.out.println("  Old Price  : $" + String.format("%.2f", oldPrice));
        System.out.println("  New Price  : $" + String.format("%.2f", newPrice));
        System.out.println("  Trend      : " + direction);
        System.out.println("  >> Dashboard updated on " + websiteName + "!");
    }
}