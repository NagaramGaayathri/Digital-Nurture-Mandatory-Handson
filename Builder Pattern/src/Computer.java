public class Computer {

    private String cpu;
    private String ram;
    private String storage;
    private String gpu;
    private String operatingSystem;
    private boolean bluetoothEnabled;
    private boolean wifiEnabled;

    private Computer(Builder builder) {
        this.cpu              = builder.cpu;
        this.ram              = builder.ram;
        this.storage          = builder.storage;
        this.gpu              = builder.gpu;
        this.operatingSystem  = builder.operatingSystem;
        this.bluetoothEnabled = builder.bluetoothEnabled;
        this.wifiEnabled      = builder.wifiEnabled;
    }

    public String getCpu()             { return cpu; }
    public String getRam()             { return ram; }
    public String getStorage()         { return storage; }
    public String getGpu()             { return gpu; }
    public String getOperatingSystem() { return operatingSystem; }
    public boolean isBluetoothEnabled(){ return bluetoothEnabled; }
    public boolean isWifiEnabled()     { return wifiEnabled; }

    @Override
    public String toString() {
        return "\n===== Computer Configuration =====" +
               "\n  CPU              : " + cpu +
               "\n  RAM              : " + ram +
               "\n  Storage          : " + storage +
               "\n  GPU              : " + (gpu != null ? gpu : "Integrated") +
               "\n  Operating System : " + (operatingSystem != null ? operatingSystem : "None") +
               "\n  Bluetooth        : " + (bluetoothEnabled ? "Yes" : "No") +
               "\n  WiFi             : " + (wifiEnabled ? "Yes" : "No") +
               "\n==================================";
    }

    public static class Builder {

        private String cpu;
        private String ram;
        private String storage;
        private String gpu;
        private String operatingSystem;
        private boolean bluetoothEnabled = false;
        private boolean wifiEnabled      = false;

        public Builder(String cpu, String ram, String storage) {
            this.cpu     = cpu;
            this.ram     = ram;
            this.storage = storage;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder operatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        public Builder bluetoothEnabled(boolean bluetoothEnabled) {
            this.bluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public Builder wifiEnabled(boolean wifiEnabled) {
            this.wifiEnabled = wifiEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}