package singleton;

public class LoggerTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== Singleton Pattern — Logger Test ===\n");

        // Test 1: Same instance every time
        System.out.println("── Test 1: Same instance every time ──");
        Logger loggerA = Logger.getInstance();
        Logger loggerB = Logger.getInstance();
        Logger loggerC = Logger.getInstance();

        System.out.println("loggerA == loggerB : " + (loggerA == loggerB));
        System.out.println("loggerB == loggerC : " + (loggerB == loggerC));
        System.out.println("All same object: " + (loggerA == loggerB && loggerB == loggerC));
        System.out.println();

        // Test 2: Shared state
        System.out.println("── Test 2: Shared state across references ──");
        loggerA.log("Application started");
        loggerB.warn("Low memory warning");
        loggerC.error("Null pointer in module X");
        System.out.println("\nTotal log entries: " + loggerA.getLogCount());
        System.out.println();

        // Test 3: Thread safety
        System.out.println("── Test 3: Thread-safety (5 threads) ──");
        Logger[] results = new Logger[5];
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            final int idx = i;
            threads[i] = new Thread(() -> {
                results[idx] = Logger.getInstance();
                results[idx].log("Message from Thread-" + idx);
            });
        }
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        boolean allSame = true;
        for (Logger r : results) {
            if (r != loggerA) { allSame = false; break; }
        }
        System.out.println("\nAll threads got same instance: " + allSame);
        System.out.println("Final log count: " + loggerA.getLogCount());
        System.out.println("\n=== All Tests Passed! ===");
    }
}
