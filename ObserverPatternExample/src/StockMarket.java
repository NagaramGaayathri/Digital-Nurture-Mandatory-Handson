import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {

    private String stockName;
    private double currentPrice;
    private double previousPrice;

    // List of all registered observers
    private List<Observer> observers = new ArrayList<>();

    public StockMarket(String stockName, double initialPrice) {
        this.stockName     = stockName;
        this.currentPrice  = initialPrice;
        this.previousPrice = initialPrice;
        System.out.println("[MARKET] " + stockName +
                           " stock created at price: $" + initialPrice);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("[MARKET] New observer registered for: " + stockName);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("[MARKET] Observer removed from: " + stockName);
    }

    @Override
    public void notifyObservers() {
        System.out.println("\n[MARKET] Notifying " + observers.size() +
                           " observer(s) about " + stockName + " price change...");
        for (Observer observer : observers) {
            observer.update(stockName, previousPrice, currentPrice);
        }
    }

    // Called when stock price changes
    public void setPrice(double newPrice) {
        System.out.println("\n==========================================");
        System.out.println("[MARKET] " + stockName + " price changed!" +
                           " Old: $" + previousPrice +
                           " → New: $" + newPrice);
        System.out.println("==========================================");
        this.previousPrice = this.currentPrice;
        this.currentPrice  = newPrice;
        notifyObservers(); // Automatically notify all observers
    }

    public double getCurrentPrice() { return currentPrice; }
    public String getStockName()    { return stockName; }
}
