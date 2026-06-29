public class Main {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("   Stock Market Monitoring System Demo    ");
        System.out.println("==========================================\n");

        // Create stock subjects
        StockMarket apple  = new StockMarket("APPLE",  150.00);
        StockMarket google = new StockMarket("GOOGLE", 2800.00);

        System.out.println();

        // Create observers
        MobileApp mobileUser1 = new MobileApp("StockTracker Pro", "Gaayathri");
        MobileApp mobileUser2 = new MobileApp("Groww App",        "Ravi");
        WebApp    dashboard   = new WebApp("NSE Dashboard");
        EmailAlert emailAlert = new EmailAlert("admin@stocks.com", 5.0); // alert if > 5% change

        // Register observers to APPLE stock
        System.out.println("\n--- Registering observers for APPLE ---");
        apple.registerObserver(mobileUser1);
        apple.registerObserver(mobileUser2);
        apple.registerObserver(dashboard);
        apple.registerObserver(emailAlert);

        // Register observers to GOOGLE stock
        System.out.println("\n--- Registering observers for GOOGLE ---");
        google.registerObserver(mobileUser1);
        google.registerObserver(dashboard);

        // Change APPLE stock price — all 4 observers notified
        System.out.println("\n--- APPLE price change (small change) ---");
        apple.setPrice(153.00); // 2% change — email threshold NOT met

        System.out.println();

        // Change APPLE price again — big change
        System.out.println("--- APPLE price change (big drop) ---");
        apple.setPrice(140.00); // big drop — email threshold MET

        System.out.println();

        // Change GOOGLE price — only 2 observers notified
        System.out.println("--- GOOGLE price change ---");
        google.setPrice(2950.00);

        System.out.println();

        // Deregister mobileUser2 from APPLE
        System.out.println("--- Removing Ravi from APPLE observers ---");
        apple.deregisterObserver(mobileUser2);

        // Change APPLE price — only 3 observers now
        System.out.println("\n--- APPLE price change after Ravi removed ---");
        apple.setPrice(145.00);

        System.out.println("\n==========================================");
        System.out.println("            Demo Complete                 ");
        System.out.println("==========================================");
    }
}