package Model;

//import esper.config;
//import events.StateEvent;
import Esper.Config;
import Events.SelfTest;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsulinPumper extends Thread {

    private final Controller controller;
    private boolean broken;

    public InsulinPumper(Controller c) {
        this.controller = c;
        broken = false;
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

    public void pumpInsulin(double insulinDose) {
        this.controller.getReservoirSensor().CollectInsulinDose(insulinDose);
        for (int i = 0; i < 5; i++) {
            System.out.println("Pumping Insulin...");
        }
    }

}
