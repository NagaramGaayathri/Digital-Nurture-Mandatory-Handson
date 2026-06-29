public class AirConditioner {

    private String location;
    private boolean isOn;
    private int temperature;

    public AirConditioner(String location) {
        this.location    = location;
        this.isOn        = false;
        this.temperature = 24; // default temperature
    }

    public void turnOn() {
        isOn = true;
        System.out.println("[AC]    " + location +
                           " AC is ON  ❄️  (Temp: " + temperature + "°C)");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("[AC]    " + location +
                           " AC is OFF 🔴");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("[AC]    " + location +
                           " AC temperature set to: " + temperature + "°C");
    }

    public boolean isOn()        { return isOn; }
    public int getTemperature()  { return temperature; }
}