package Model;

//import Esper.Config;
//import Events.StateEvent;
import Esper.Config;
import Events.ReservoirInserted;
import Events.SelfTest;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsulinReservoirSensor extends Thread {
    private final Controller controller;

    private double capacity;
    private double currentCapacity;
    private boolean broken;

    public InsulinReservoirSensor(Controller c, double capacity, boolean broken) {
        this.controller = c;
        this.capacity = capacity;
        this.currentCapacity = capacity;
        this.broken = broken;
    }

    public InsulinReservoirSensor(Controller c) {
        this.controller = c;
        this.capacity = 100;
        this.currentCapacity = 85;
        this.broken = false;
    }

    public double CaptureReservoirCapacity() {
        currentCapacity = 60;
        return currentCapacity;
    }

    public boolean CollectInsulinDose(double dose) {
        if (dose > currentCapacity) {
            return false;
        }

        currentCapacity -= dose;
        return true;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }

    public boolean checkHardware() {
        if (broken == false) {
            return broken;
        } else {
            return true;
        }
    }

    public void insertReservoir(double capacity) {

        if (capacity == currentCapacity) {
            System.out.println("New Reservoir Inserted Successfully...");
            Config.sendEvent(new ReservoirInserted(capacity));
        } else {
            System.out.println("Not Enough Capacity");
            controller.changeState(SystemState.SUSPENDED);
        }

    }

}
