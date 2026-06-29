public interface Observer {

    // Called whenever stock price changes
    void update(String stockName, double oldPrice, double newPrice);
}