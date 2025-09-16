abstract class Device {
    private String deviceId;
    private boolean status;

    public Device(String deviceId, boolean status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public boolean isOn() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public abstract void displayStatus();
}

class Thermostat extends Device {
    private int temperatureSetting;

    public Thermostat(String deviceId, boolean status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    public int getTemperatureSetting() {
        return temperatureSetting;
    }

    public void setTemperatureSetting(int temperatureSetting) {
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        System.out.println("Thermostat [ID: " + getDeviceId() +
                           ", Power: " + (isOn() ? "ON" : "OFF") +
                           ", Temperature: " + temperatureSetting + "°C]");
    }
}

public class SmartHomeDemo {
    public static void main(String[] args) {
        Device device = new Thermostat("T1001", true, 24);
        device.displayStatus();
    }
}
