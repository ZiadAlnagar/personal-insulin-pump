package Events;

/**
 *
 * @author Yousef Hussien
 */
public class SwitchhEvent {
    private boolean powerState;

    public SwitchhEvent(boolean powerState) {
        this.powerState = powerState;
    }

    public boolean isPowerState() {
        return powerState;
    }

    public void setPowerState(boolean powerState) {
        this.powerState = powerState;
    }

    

}
