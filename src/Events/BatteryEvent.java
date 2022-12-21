package Events;

/**
 *
 * @author Yousef Hussien
 */
public class BatteryEvent {

    private double batteryLevel;

    public BatteryEvent(double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

}
