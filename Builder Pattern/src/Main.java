public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("     Builder Pattern - Computer Demo    ");
        System.out.println("========================================");

        // Config 1: Gaming PC
        Computer gamingPC = new Computer.Builder("Intel Core i9-13900K", "64GB DDR5", "2TB NVMe SSD")
                .gpu("NVIDIA RTX 4090")
                .operatingSystem("Windows 11 Pro")
                .bluetoothEnabled(true)
                .wifiEnabled(true)
                .build();
        System.out.println("\n[1] Gaming PC:");
        System.out.println(gamingPC);

        // Config 2: Office PC
        Computer officePC = new Computer.Builder("Intel Core i5-12400", "16GB DDR4", "512GB SSD")
                .operatingSystem("Windows 11 Home")
                .wifiEnabled(true)
                .build();
        System.out.println("\n[2] Office PC:");
        System.out.println(officePC);

        // Config 3: Budget PC
        Computer budgetPC = new Computer.Builder("AMD Ryzen 3 3200G", "8GB DDR4", "256GB HDD")
                .build();
        System.out.println("\n[3] Budget PC:");
        System.out.println(budgetPC);

        // Config 4: Developer Workstation
        Computer devWorkstation = new Computer.Builder("AMD Ryzen 9 7950X", "128GB DDR5", "4TB NVMe SSD")
                .gpu("NVIDIA RTX 3060")
                .operatingSystem("Ubuntu 22.04 LTS")
                .bluetoothEnabled(true)
                .wifiEnabled(true)
                .build();
        System.out.println("\n[4] Developer Workstation:");
        System.out.println(devWorkstation);

        System.out.println("\n========================================");
        System.out.println("            Demo Complete               ");
        System.out.println("========================================");
    }
}