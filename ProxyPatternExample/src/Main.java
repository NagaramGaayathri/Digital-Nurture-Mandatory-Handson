public class Main {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("     Image Viewer Application Demo        ");
        System.out.println("==========================================\n");

        String server = "https://images.remoteserver.com";

        // Create proxy images (NO loading happens yet - lazy init)
        Image image1 = new ProxyImage("nature_wallpaper.jpg",   server);
        Image image2 = new ProxyImage("city_skyline.png",        server);
        Image image3 = new ProxyImage("mountain_sunset.jpg",     server);

        System.out.println("--- Images created (nothing loaded yet) ---\n");

        // First display — loads from server
        System.out.println("=== First Request: nature_wallpaper.jpg ===");
        image1.display();
        ProxyImage.showCache();

        System.out.println();

        // First display of image2 — loads from server
        System.out.println("=== First Request: city_skyline.png ===");
        image2.display();
        ProxyImage.showCache();

        System.out.println();

        // Second display of image1 — served from CACHE (no server call)
        System.out.println("=== Second Request: nature_wallpaper.jpg (should use cache) ===");
        image1.display();

        System.out.println();

        // Second display of image2 — served from CACHE
        System.out.println("=== Second Request: city_skyline.png (should use cache) ===");
        image2.display();

        System.out.println();

        // First display of image3 — loads from server
        System.out.println("=== First Request: mountain_sunset.jpg ===");
        image3.display();
        ProxyImage.showCache();

        System.out.println();

        // Third display of image1 — still from CACHE
        System.out.println("=== Third Request: nature_wallpaper.jpg (still from cache) ===");
        image1.display();

        System.out.println("\n==========================================");
        System.out.println("            Demo Complete                 ");
        System.out.println("==========================================");
    }
}