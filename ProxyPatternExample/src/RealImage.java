public class RealImage implements Image {

    private String fileName;
    private String serverUrl;

    public RealImage(String fileName, String serverUrl) {
        this.fileName  = fileName;
        this.serverUrl = serverUrl;
        // Loading happens ONLY when RealImage is created
        loadFromServer();
    }

    // Simulates loading image from remote server (heavy operation)
    private void loadFromServer() {
        System.out.println("[SERVER] Connecting to: " + serverUrl);
        System.out.println("[SERVER] Downloading  : " + fileName + " ...");

        // Simulate network delay
        try {
            Thread.sleep(1500); // 1.5 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[SERVER] Download complete: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("[DISPLAY] Showing image: " + fileName);
    }

    public String getFileName() {
        return fileName;
    }
}