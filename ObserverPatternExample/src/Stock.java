public interface Stock {

    // Register a new observer
    void registerObserver(Observer observer);

    // Remove an existing observer
    void deregisterObserver(Observer observer);

    // Notify all registered observers
    void notifyObservers();
}