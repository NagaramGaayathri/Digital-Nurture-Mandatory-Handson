import java.util.HashMap;
import java.util.Map;

public class ProxyImage implements Image {

    private String fileName;
    private String serverUrl;
    private RealImage realImage;

    // Cache stores already loaded images (shared across all ProxyImage instances)
    private static Map<String, RealImage> imageCache = new HashMap<>();

    public ProxyImage(String fileName, String serverUrl) {
        this.fileName  = fileName;
        this.serverUrl = serverUrl;
        // NOTE: RealImage is NOT created here (lazy initialization)
    }

    @Override
    public void display() {

        // Check if image is already in cache
        if (imageCache.containsKey(fileName)) {
            System.out.println("[PROXY] Loading from CACHE: " + fileName);
            realImage = imageCache.get(fileName);
        } else {
            // Not in cache — load from server and cache it
            System.out.println("[PROXY] Not in cache. Loading from server...");
            realImage = new RealImage(fileName, serverUrl);
            imageCache.put(fileName, realImage);
            System.out.println("[PROXY] Image cached: " + fileName);
        }

        // Display the image
        realImage.display();
    }

    // Show what is currently in the cache
    public static void showCache() {
        System.out.println("\n[CACHE] Currently cached images: " + imageCache.keySet());
    }
}