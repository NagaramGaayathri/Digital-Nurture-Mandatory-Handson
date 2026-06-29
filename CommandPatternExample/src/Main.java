public class Main {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("    Home Automation System Demo           ");
        System.out.println("==========================================\n");

        // Create Receivers
        Light          livingRoomLight = new Light("Living Room");
        Light          bedroomLight    = new Light("Bedroom");
        Fan            ceilingFan      = new Fan("Living Room");
        AirConditioner bedroomAC       = new AirConditioner("Bedroom");

        // Create Commands
        Command lightOn   = new LightOnCommand(livingRoomLight);
        Command lightOff  = new LightOffCommand(livingRoomLight);
        Command bedLightOn  = new LightOnCommand(bedroomLight);
        Command bedLightOff = new LightOffCommand(bedroomLight);
        Command fanOn     = new FanOnCommand(ceilingFan);
        Command fanOff    = new FanOffCommand(ceilingFan);
        Command acOn      = new ACOnCommand(bedroomAC);
        Command acOff     = new ACOffCommand(bedroomAC);

        // Create Invoker
        RemoteControl remote = new RemoteControl();

        // --- Test 1: Turn on Living Room Light ---
        System.out.println("--- Pressing Button: Living Room Light ON ---");
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println();

        // --- Test 2: Turn on Fan ---
        System.out.println("--- Pressing Button: Fan ON ---");
        remote.setCommand(fanOn);
        remote.pressButton();

        System.out.println();

        // --- Test 3: Turn on Bedroom AC ---
        System.out.println("--- Pressing Button: Bedroom AC ON ---");
        remote.setCommand(acOn);
        remote.pressButton();

        System.out.println();

        // --- Test 4: Turn on Bedroom Light ---
        System.out.println("--- Pressing Button: Bedroom Light ON ---");
        remote.setCommand(bedLightOn);
        remote.pressButton();

        System.out.println();

        // --- Test 5: Undo last command (Bedroom Light OFF) ---
        System.out.println("--- Pressing UNDO button ---");
        remote.pressUndo();

        System.out.println();

        // --- Test 6: Undo again (AC OFF) ---
        System.out.println("--- Pressing UNDO again ---");
        remote.pressUndo();

        System.out.println();

        // --- Test 7: Turn off Living Room Light ---
        System.out.println("--- Pressing Button: Living Room Light OFF ---");
        remote.setCommand(lightOff);
        remote.pressButton();

        System.out.println();

        // --- Test 8: Turn off Fan ---
        System.out.println("--- Pressing Button: Fan OFF ---");
        remote.setCommand(fanOff);
        remote.pressButton();

        System.out.println();

        // Show history
        remote.showHistory();

        System.out.println("\n==========================================");
        System.out.println("            Demo Complete                 ");
        System.out.println("==========================================");
    }
}