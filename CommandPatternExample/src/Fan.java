public class Fan {

    private String location;
    private boolean isOn;
    private int     speed; // 1=Low, 2=Medium, 3=High

    public Fan(String location) {
        this.location = location;
        this.isOn     = false;
        this.speed    = 1;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("[FAN]   " + location +
                           " fan is ON  🌀 (Speed: " + getSpeedLabel() + ")");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("[FAN]   " + location +
                           " fan is OFF ⛔");
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        System.out.println("[FAN]   " + location +
                           " fan speed set to: " + getSpeedLabel());
    }

    private String getSpeedLabel() {
        switch (speed) {
            case 1:  return "Low";
            case 2:  return "Medium";
            case 3:  return "High";
            default: return "Unknown";
        }
    }

    public boolean isOn() { return isOn; }
    public int getSpeed() { return speed; }
}